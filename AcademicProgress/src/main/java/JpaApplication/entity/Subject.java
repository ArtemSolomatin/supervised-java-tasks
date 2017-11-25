package JpaApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Artem Solomatin on 10.09.17.
 * AcademicProgress
 */
@Entity
public class Subject implements Serializable {
	private Integer subjectId;
	private Integer subjectNum;
	private String subjectName;
	private Collection<Assessment> assessmentsBySubjectId;

	public Subject() {
	}

	public Subject(int subjectId, Integer subjectNum, String subjectName, Collection<Assessment> assessmentsBySubjectId) {
		this.subjectId = subjectId;
		this.subjectNum = subjectNum;
		this.subjectName = subjectName;
		this.assessmentsBySubjectId = assessmentsBySubjectId;
	}

	@Id
	@Column(name = "subject_id", nullable = false, unique = true)
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	@Basic
	@Column(name = "subject_num", nullable = true)
	public Integer getSubjectNum() {
		return subjectNum;
	}

	public void setSubjectNum(Integer subjectNum) {
		this.subjectNum = subjectNum;
	}

	@Basic
	@Column(name = "subject_name", nullable = true, length = 40)
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Subject subject = (Subject) o;

		if (subjectId != subject.subjectId) return false;
		if (subjectNum != null ? !subjectNum.equals(subject.subjectNum) : subject.subjectNum != null) return false;
		if (subjectName != null ? !subjectName.equals(subject.subjectName) : subject.subjectName != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = subjectId;
		result = 31 * result + (subjectNum != null ? subjectNum.hashCode() : 0);
		result = 31 * result + (subjectName != null ? subjectName.hashCode() : 0);
		return result;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "subjectBySubjectId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Collection<Assessment> getAssessmentsBySubjectId() {
		return assessmentsBySubjectId;
	}

	public void setAssessmentsBySubjectId(Collection<Assessment> assessmentsBySubjectId) {
		this.assessmentsBySubjectId = assessmentsBySubjectId;
	}

	@Override
	public String toString() {
		return "Subject{" +
				"subjectId=" + subjectId +
				", subjectNum=" + subjectNum +
				", subjectName='" + subjectName + '\'' +
				'}';
	}
}
