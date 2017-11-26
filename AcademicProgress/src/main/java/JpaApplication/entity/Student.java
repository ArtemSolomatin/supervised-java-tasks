package JpaApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Artem Solomatin on 10.09.17.
 * AcademicProgress
 */

@ToString(exclude = {"assessmentssByStudentId", "facultyByFacultyId"})
@EqualsAndHashCode
@Entity
public class Student implements Serializable {
	@Id
	@Column(name = "student_id", nullable = false)
	@Setter @Getter private Integer studentId;

	@Column(name = "faculty_id", nullable = false, insertable = false, updatable = false)
	@Setter @Getter private Integer facultyId;

	@Column(name = "recordbook_num", nullable = false)
	@Setter @Getter private Integer recordbookNum;

	@Column(name = "full_name", nullable = false, length = 50)
	@Setter @Getter private String fullName;

	@Column(name = "group_num", nullable = false)
	@Setter @Getter private Integer groupNum;

	@JsonIgnore
	@OneToMany(mappedBy = "studentByStudentId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Setter @Getter private Collection<Assessment> assessmentssByStudentId;

	@ManyToOne
	@JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id")
	@Setter @Getter private Faculty facultyByFacultyId;

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
}
