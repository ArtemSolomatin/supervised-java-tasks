package org.cqm.data.entity;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "Reports")
@NamedQuery(name = "Reports.getAll", query = "select r from Report r")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "cqm_id_sequence")
    @Column(name = "report_id")
    private Integer reportId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "cafe_id")
    private Integer cafeId;

    @Column(name = "load")
    private Integer load;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    Date date;

    @Column(name = "rating")
    private Integer rating;

    private String author;

    private Integer authorRating;

    private String cafeName;

    private Boolean isVoted;

    private Boolean isAuthor;

    public Report() {
    }

    public Report(int cafeId, int userId, int load, Date date, int rating) {
        this.cafeId = cafeId;
        this.userId = userId;
        this.load = load;
        this.date = date;
        this.rating = rating;
    }


    public Boolean getIsVoted() {
        return isVoted;
    }

    public void setIsVoted(Boolean isVoted) {
        this.isVoted = isVoted;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAuthorRating() {
        return authorRating;
    }

    public void setAuthorRating(Integer authorRating) {
        this.authorRating = authorRating;
    }

    public String getCafeName() {
        return cafeName;
    }

    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }

    public Report(Integer reportId) {
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

    public Integer getCafeId() {
        return cafeId;
    }

    public void setCafeId(Integer cafeId) {
        this.cafeId = cafeId;
    }

    public Integer getLoad() {
        return load;
    }

    public void setLoad(Integer load) {
        this.load = load;
    }

    public String getDate() {
        String format = new SimpleDateFormat("dd MMMM HH:mm").format(date);
        return format;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Boolean getIsAuthor() {
        return isAuthor;
    }

    public void setIsAuthor(Boolean isAuthor) {
        this.isAuthor = isAuthor;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportId=" + reportId +
                ", userId=" + userId +
                ", cafeId=" + cafeId +
                ", load=" + load +
                ", date=" + date +
                ", rating=" + rating +
                ", author='" + author + '\'' +
                ", authorRating=" + authorRating +
                ", cafeName='" + cafeName + '\'' +
                ", isVoted=" + isVoted +
                ", isAuthor=" + isAuthor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        if (reportId != null ? !reportId.equals(report.reportId) : report.reportId != null) return false;
        if (userId != null ? !userId.equals(report.userId) : report.userId != null) return false;
        if (cafeId != null ? !cafeId.equals(report.cafeId) : report.cafeId != null) return false;
        if (load != null ? !load.equals(report.load) : report.load != null) return false;
        if (date != null ? !date.equals(report.date) : report.date != null) return false;
        if (rating != null ? !rating.equals(report.rating) : report.rating != null) return false;
        if (author != null ? !author.equals(report.author) : report.author != null) return false;
        if (authorRating != null ? !authorRating.equals(report.authorRating) : report.authorRating != null)
            return false;
        if (cafeName != null ? !cafeName.equals(report.cafeName) : report.cafeName != null) return false;
        if (isVoted != null ? !isVoted.equals(report.isVoted) : report.isVoted != null) return false;
        return isAuthor != null ? isAuthor.equals(report.isAuthor) : report.isAuthor == null;

    }

    @Override
    public int hashCode() {
        int result = reportId != null ? reportId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (cafeId != null ? cafeId.hashCode() : 0);
        result = 31 * result + (load != null ? load.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (authorRating != null ? authorRating.hashCode() : 0);
        result = 31 * result + (cafeName != null ? cafeName.hashCode() : 0);
        result = 31 * result + (isVoted != null ? isVoted.hashCode() : 0);
        result = 31 * result + (isAuthor != null ? isAuthor.hashCode() : 0);
        return result;
    }
}
