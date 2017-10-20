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
public class Faculty implements Serializable {
	private int facultyId;
	private Integer facultyNum;
	private String facultyName;
	private Collection<Student> studentsByFacultyId;

	public Faculty() {
	}

	public Faculty(int facultyId, Integer facultyNum, String facultyName, Collection<Student> studentsByFacultyId) {
		this.facultyId = facultyId;
		this.facultyNum = facultyNum;
		this.facultyName = facultyName;
		this.studentsByFacultyId = studentsByFacultyId;
	}

	@Id
	@Column(name = "faculty_id", nullable = false)
	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	@Basic
	@Column(name = "faculty_num", nullable = true)
	public Integer getFacultyNum() {
		return facultyNum;
	}

	public void setFacultyNum(Integer facultyNum) {
		this.facultyNum = facultyNum;
	}

	@Basic
	@Column(name = "faculty_name", nullable = true, length = 40)
	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Faculty faculty = (Faculty) o;

		if (facultyId != faculty.facultyId) return false;
		if (facultyNum != null ? !facultyNum.equals(faculty.facultyNum) : faculty.facultyNum != null) return false;
		if (facultyName != null ? !facultyName.equals(faculty.facultyName) : faculty.facultyName != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = facultyId;
		result = 31 * result + (facultyNum != null ? facultyNum.hashCode() : 0);
		result = 31 * result + (facultyName != null ? facultyName.hashCode() : 0);
		return result;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "facultyByFacultyId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Collection<Student> getStudentsByFacultyId() {
		return studentsByFacultyId;
	}

	public void setStudentsByFacultyId(Collection<Student> studentsByFacultyId) {
		this.studentsByFacultyId = studentsByFacultyId;
	}

	@Override
	public String toString() {
		return "Faculty{" +
				"facultyId=" + facultyId +
				", facultyNum=" + facultyNum +
				", facultyName='" + facultyName + '\'' +
				'}';
	}
}
