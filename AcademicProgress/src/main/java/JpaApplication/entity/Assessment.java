package JpaApplication.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Artem Solomatin on 10.09.17.
 * AcademicProgress
 */

//TODO убрать примитивы и заменить их обертками
@Entity
public class Assessment implements Serializable {
	private int assessmentId;
	private int studentId;
	private int subjectId;
	private Integer semesterNum;
	private Integer mark;
	private String examinerSurname;
	private Student studentByStudentId;
	private Subject subjectBySubjectId;

	public Assessment() {
	}

	public Assessment(int studentId, int subjectId, Integer semesterNum, Integer mark, String examinerSurname, Student studentByStudentId, Subject subjectBySubjectId) {
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.semesterNum = semesterNum;
		this.mark = mark;
		this.examinerSurname = examinerSurname;
		this.studentByStudentId = studentByStudentId;
		this.subjectBySubjectId = subjectBySubjectId;
	}

	@Id
	@Column(name = "assessment_id", nullable = false)
	public int getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}

	@Basic
	@Column(name = "student_id", nullable = false, insertable = false, updatable = false)
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Basic
	@Column(name = "subject_id", nullable = false, insertable = false, updatable = false)
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	@Basic
	@Column(name = "semester_num", nullable = true)
	public Integer getSemesterNum() {
		return semesterNum;
	}

	public void setSemesterNum(Integer semesterNum) {
		this.semesterNum = semesterNum;
	}

	@Basic
	@Column(name = "mark", nullable = true)
	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	@Basic
	@Column(name = "examiner_surname", nullable = true, length = 40)
	public String getExaminerSurname() {
		return examinerSurname;
	}

	public void setExaminerSurname(String examinerSurname) {
		this.examinerSurname = examinerSurname;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Assessment that = (Assessment) o;

		if (assessmentId != that.assessmentId) return false;
		if (studentId != that.studentId) return false;
		if (subjectId != that.subjectId) return false;
		if (semesterNum != null ? !semesterNum.equals(that.semesterNum) : that.semesterNum != null) return false;
		if (mark != null ? !mark.equals(that.mark) : that.mark != null) return false;
		if (examinerSurname != null ? !examinerSurname.equals(that.examinerSurname) : that.examinerSurname != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = assessmentId;
		result = 31 * result + studentId;
		result = 31 * result + subjectId;
		result = 31 * result + (semesterNum != null ? semesterNum.hashCode() : 0);
		result = 31 * result + (mark != null ? mark.hashCode() : 0);
		result = 31 * result + (examinerSurname != null ? examinerSurname.hashCode() : 0);
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
	public Student getStudentByStudentId() {
		return studentByStudentId;
	}

	public void setStudentByStudentId(Student studentByStudentId) {
		this.studentByStudentId = studentByStudentId;
	}

	@ManyToOne
	@JoinColumn(name = "subject_id", referencedColumnName = "subject_id", nullable = false)
	public Subject getSubjectBySubjectId() {
		return subjectBySubjectId;
	}

	public void setSubjectBySubjectId(Subject subjectBySubjectId) {
		this.subjectBySubjectId = subjectBySubjectId;
	}

	@Override
	public String toString() {
		return "Assessment{" +
				"assessmentId=" + assessmentId +
				", studentId=" + studentId +
				", subjectId=" + subjectId +
				", semesterNum=" + semesterNum +
				", mark=" + mark +
				", examinerSurname='" + examinerSurname + '\'' +
				'}';
	}
}
