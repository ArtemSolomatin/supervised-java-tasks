package JpaApplication.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Artem Solomatin on 10.09.17.
 * AcademicProgress
 */

@ToString(exclude = {"studentByStudentId", "subjectBySubjectId"})
@EqualsAndHashCode
@Entity
public class Assessment implements Serializable {
	@Id
	@Column(name = "assessment_id", nullable = false)
	@Getter @Setter private Integer assessmentId;

	@Column(name = "student_id", nullable = false, insertable = false, updatable = false)
	@Getter @Setter private Integer studentId;

	@Column(name = "subject_id", nullable = false, insertable = false, updatable = false)
	@Getter @Setter private Integer subjectId;

	@Column(name = "semester_num", nullable = false)
	@Getter @Setter private Integer semesterNum;

	@Column(name = "mark", nullable = false)
	@Getter @Setter private Integer mark;

	@Column(name = "examiner_surname", nullable = false, length = 40)
	@Getter @Setter private String examinerSurname;

	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
	@Getter @Setter private Student studentByStudentId;

	@ManyToOne
	@JoinColumn(name = "subject_id", referencedColumnName = "subject_id", nullable = false)
	@Getter @Setter private Subject subjectBySubjectId;

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
}
