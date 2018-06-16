package org.cqm.data.repositories;

import org.cqm.data.entity.Vote;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Integer> {

    @Query("select v from Vote v, User u where v.userId = u.userId and u.login = :login and v.reportId = :reportId")
    List<Vote> findVoteByReportAndUser(@Param("login") String login, @Param("reportId") Integer reportId);

    @Modifying
    @Transactional
    @Query("update User u set u.rating = u.rating + 1 where u.userId = :userId")
    void incrementUserRating(@Param("userId") Integer userId);

    @Modifying
    @Transactional
    @Query("update User u set u.rating = u.rating - 1 where u.userId = :userId")
    void decrementUserRating(@Param("userId") Integer userId);

    @Modifying
    @Transactional
    @Query("update Report r set r.rating = r.rating + 1 where r.reportId = :reportId")
    void incrementReportRating(@Param("reportId") Integer reportId);

    @Modifying
    @Transactional
    @Query("update Report r set r.rating = r.rating - 1 where r.reportId = :reportId")
    void decrementReportRating(@Param("reportId") Integer reportId);
}
