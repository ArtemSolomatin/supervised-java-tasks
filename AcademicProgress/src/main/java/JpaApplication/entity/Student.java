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
public class Student implements Serializable {
	private int studentId;
	private Integer facultyId;
	private Integer recordbookNum;
	private String fullName;
	private Integer groupNum;
	private Collection<Assessment> assessmentssByStudentId;
	private Faculty facultyByFacultyId;

	public Student() {
	}

	public Student(int studentId, Integer facultyId, Integer recordbookNum, String fullName, Integer groupNum, Collection<Assessment> assessmentssByStudentId, Faculty facultyByFacultyId) {
		this.studentId = studentId;
		this.facultyId = facultyId;
		this.recordbookNum = recordbookNum;
		this.fullName = fullName;
		this.groupNum = groupNum;
		this.assessmentssByStudentId = assessmentssByStudentId;
		this.facultyByFacultyId = facultyByFacultyId;
	}

	@Id
	@Column(name = "student_id", nullable = false)
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Basic
	@Column(name = "faculty_id", nullable = true, insertable = false, updatable = false)
	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	@Basic
	@Column(name = "recordbook_num", nullable = true)
	public Integer getRecordbookNum() {
		return recordbookNum;
	}

	public void setRecordbookNum(Integer recordbookNum) {
		this.recordbookNum = recordbookNum;
	}

	@Basic
	@Column(name = "full_name", nullable = true, length = 50)
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Basic
	@Column(name = "group_num", nullable = true)
	public Integer getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(Integer groupNum) {
		this.groupNum = groupNum;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Student student = (Student) o;

		if (studentId != student.studentId) return false;
		if (facultyId != null ? !facultyId.equals(student.facultyId) : student.facultyId != null) return false;
		if (recordbookNum != null ? !recordbookNum.equals(student.recordbookNum) : student.recordbookNum != null)
			return false;
		if (fullName != null ? !fullName.equals(student.fullName) : student.fullName != null) return false;
		if (groupNum != null ? !groupNum.equals(student.groupNum) : student.groupNum != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = studentId;
		result = 31 * result + (facultyId != null ? facultyId.hashCode() : 0);
		result = 31 * result + (recordbookNum != null ? recordbookNum.hashCode() : 0);
		result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
		result = 31 * result + (groupNum != null ? groupNum.hashCode() : 0);
		return result;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "studentByStudentId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Collection<Assessment> getAssessmentssByStudentId() {
		return assessmentssByStudentId;
	}

	public void setAssessmentssByStudentId(Collection<Assessment> assessmentssByStudentId) {
		this.assessmentssByStudentId = assessmentssByStudentId;
	}

	@ManyToOne
	@JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id")
	public Faculty getFacultyByFacultyId() {
		return facultyByFacultyId;
	}

	public void setFacultyByFacultyId(Faculty facultyByFacultyId) {
		this.facultyByFacultyId = facultyByFacultyId;
	}

	@Override
	public String toString() {
		return "Student{" +
				"studentId=" + studentId +
				", facultyId=" + facultyId +
				", recordbookNum=" + recordbookNum +
				", fullName='" + fullName + '\'' +
				", groupNum=" + groupNum +
				'}';
	}
}
