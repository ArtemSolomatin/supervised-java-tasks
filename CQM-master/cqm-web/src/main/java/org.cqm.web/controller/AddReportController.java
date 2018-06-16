package org.cqm.web.controller;


import org.cqm.data.entity.Cafeteria;
import org.cqm.data.entity.Report;
import org.cqm.data.entity.User;
import org.cqm.data.services.CafeteriaService;
import org.cqm.data.services.ReportService;
import org.cqm.data.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AddReportController {

    @Resource
    private UserService userService;

    @Resource
    private ReportService reportService;

    @Resource
    private CafeteriaService cafeteriaService;

    @RequestMapping(value = "/addreport", method = RequestMethod.GET)
    public String getReportForm(Model model) {
        List<Cafeteria> cafeterias = cafeteriaService.getCafeteriaRepository().findAllCafeteriasOrderByCafeIdAsc();
        List<String> cafeNames = new ArrayList<>();
        List<Integer> cafeLoads = new ArrayList<>();
        for (int i = 0; i < cafeterias.size(); i++) {
            cafeNames.add(i, cafeterias.get(i).getCafeName());
        }
        for (int i = 0; i < 11; i++) {
            cafeLoads.add(i, i);
        }
        model.addAttribute("rating", userService.getUserRepository().findUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get(0).getRating());
        model.addAttribute("cafeNames", cafeNames);
        model.addAttribute("cafeLoads", cafeLoads);
        model.addAttribute("reportForm", new Report());
        return "addreport";
    }

    @RequestMapping(value = "/addreport", method = RequestMethod.POST)
    public String addReportForm(@ModelAttribute("reportForm") Report reportForm) {
        String currentName = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userService.findUserByLogin(currentName);
        Report report = new Report(cafeteriaService.findCafeIdByCafeName(reportForm.getCafeName()),
                currentUser.getId(), reportForm.getLoad(), new Date(), 0);
        reportService.getReportRepository().save(report);
        return "redirect:/reports";
    }
}
