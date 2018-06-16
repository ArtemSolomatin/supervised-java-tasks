package org.cqm.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "Votes")
@NamedQuery(name = "Votes.getAll", query = "select v from Vote v")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "cqm_id_sequence")
    @Column(name = "vote_id")
    private Integer voteId;

    @Column(name = "report_id")
    private Integer reportId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "vote")
    private Integer vote;

    public Vote() {
    }

    public Vote(Integer reportId, Integer userId, Integer vote) {
        this.reportId = reportId;
        this.userId = userId;
        this.vote = vote;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "voteId=" + voteId +
                ", reportId=" + reportId +
                ", userId=" + userId +
                ", vote=" + vote +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vote vote1 = (Vote) o;

        if (voteId != null ? !voteId.equals(vote1.voteId) : vote1.voteId != null) return false;
        if (reportId != null ? !reportId.equals(vote1.reportId) : vote1.reportId != null) return false;
        if (userId != null ? !userId.equals(vote1.userId) : vote1.userId != null) return false;
        return vote != null ? vote.equals(vote1.vote) : vote1.vote == null;

    }

    @Override
    public int hashCode() {
        int result = voteId != null ? voteId.hashCode() : 0;
        result = 31 * result + (reportId != null ? reportId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (vote != null ? vote.hashCode() : 0);
        return result;
    }
}
