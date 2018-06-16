package org.cqm.data.services;

import org.cqm.data.entity.Cafeteria;
import org.cqm.data.entity.Report;
import org.cqm.data.entity.User;
import org.cqm.data.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("reportService")
public class ReportService {

    @Autowired
    ReportRepository reportRepository;

    public ReportRepository getReportRepository() {
        return this.reportRepository;
    }

    public Cafeteria findCafeteriaByReportId(Integer reportId) {
        List<Cafeteria> cafeterias = reportRepository.findCafeOfReport(reportId);
        if (cafeterias == null || cafeterias.isEmpty())
            return null;
        return cafeterias.get(0);
    }

    public List<Report> findFreshestReports() {
        List<Report> reports = reportRepository.findAllReportsOrderByDateDesc();
        if (reports.size() > 20) {
            reports.subList(0, 20);
        }
        for (int i = 0; i < reports.size(); ++i) {
            if (reports.get(i).getRating() <= -5) {
                reports.remove(i);
            }
        }
        if (reports.size() > 10) {
            reports.subList(0, 10);
        }

        return reports;
    }

    public Report findReportById(Integer reportId) {
        List<Report> reports = reportRepository.findReportById(reportId);
        if (reports == null || reports.isEmpty())
            return null;
        return reports.get(0);
    }

    public String findLoginOfTheAuthor(Integer reportId) {
        List<User> users = reportRepository.findAuthorOfReport(reportId);
        if (users == null || users.isEmpty())
            return null;
        return users.get(0).getLogin();
    }
}
