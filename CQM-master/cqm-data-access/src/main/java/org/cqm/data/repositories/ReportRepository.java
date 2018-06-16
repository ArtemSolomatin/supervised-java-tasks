package org.cqm.data.repositories;

import org.cqm.data.entity.Cafeteria;
import org.cqm.data.entity.Report;
import org.cqm.data.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends CrudRepository<Report, Integer> {

    @Query("select r from Report r order by date desc")
    List<Report> findAllReportsOrderByDateDesc();

    @Query("select r from Report r where r.reportId = :reportId")
    List<Report> findReportById(@Param("reportId") Integer reportId);

    @Query("select u from User u, Report r where u.userId = r.userId  and r.reportId = :reportId")
    List<User> findAuthorOfReport(@Param("reportId") Integer reportId);

    @Query("select c from Cafeteria c, Report r where c.cafeId = r.cafeId  and r.reportId = :reportId")
    List<Cafeteria> findCafeOfReport(@Param("reportId") Integer reportId);
}
