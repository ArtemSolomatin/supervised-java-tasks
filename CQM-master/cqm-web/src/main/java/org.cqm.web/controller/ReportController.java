package org.cqm.web.controller;

import org.cqm.data.entity.Cafeteria;
import org.cqm.data.entity.Report;
import org.cqm.data.entity.User;
import org.cqm.data.entity.Vote;
import org.cqm.data.services.ReportService;
import org.cqm.data.services.UserService;
import org.cqm.data.services.VoteService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ReportController {

    @Resource(name = "reportService")
    private ReportService reportService;

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "voteService")
    private VoteService voteService;

    @RequestMapping(value = "/reports")
    public String listReports(Model model) {
        List<Report> reports = reportService.findFreshestReports();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentName = auth.getName();

        for (int i = 0; i < reports.size(); ++i) {
            Report currentReport = reports.get(i);

            User authorOfCurrentReport = userService.findUserById(currentReport.getUserId());
            Cafeteria cafeteriaOfCurrentReport = reportService.findCafeteriaByReportId(currentReport.getReportId());

            currentReport.setAuthor(authorOfCurrentReport.getLogin());
            currentReport.setAuthorRating(authorOfCurrentReport.getRating());
            currentReport.setCafeName(cafeteriaOfCurrentReport.getCafeName());

            if (authorOfCurrentReport.getLogin().equals(currentName)) {
                currentReport.setIsAuthor(true);
            } else {
                currentReport.setIsAuthor(false);
            }

            if (voteService.voteExists(currentName, currentReport.getReportId())) {
                currentReport.setIsVoted(true);
            } else {
                currentReport.setIsVoted(false);
            }
        }
        model.addAttribute("reports", reports);
        return "report";
    }

    @RequestMapping(value = "/reports/positive/{reportId}")
    public String rateReportsPos(@PathVariable("reportId") Integer currentReportId, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentName = auth.getName();
        User currentUser = userService.findUserByLogin(currentName);
        Report currentReport = reportService.findReportById(currentReportId);
        try {
            if (reportService.findLoginOfTheAuthor(currentReportId).equals(currentName)) {
                return "redirect:/reports";
            }
            Vote vote = new Vote(currentReportId, currentUser.getId(), 1);
            voteService.saveAndIncrement(vote, currentReport.getUserId());
        } catch (Exception e) {
        } finally {
            return this.listReports(model);
        }
    }

    @RequestMapping(value = "/reports/negative/{reportId}")
    public String rateReportsNeg(@PathVariable("reportId") Integer currentReportId, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentName = auth.getName();
        User currentUser = userService.findUserByLogin(currentName);
        Report currentReport = reportService.findReportById(currentReportId);
        try {
            if (reportService.findLoginOfTheAuthor(currentReportId).equals(currentName)) {
                return "redirect:/reports";
            }
            Vote vote = new Vote(currentReportId, currentUser.getId(), -1);
            voteService.saveAndDecrement(vote, currentReport.getUserId());
        } catch (Exception e) {

        } finally {
            return this.listReports(model);
        }
    }
}
