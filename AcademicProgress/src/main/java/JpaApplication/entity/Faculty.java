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

@ToString(exclude = "studentsByFacultyId")
@EqualsAndHashCode
@Entity
public class Faculty implements Serializable {
	@Id
	@Column(name = "faculty_id", nullable = false)
	@Getter @Setter private Integer facultyId;

	@Column(name = "faculty_num", nullable = false)
	@Getter @Setter private Integer facultyNum;

	@Column(name = "faculty_name", nullable = false, length = 40)
	@Getter @Setter private String facultyName;

	@JsonIgnore
	@OneToMany(mappedBy = "facultyByFacultyId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Getter @Setter private Collection<Student> studentsByFacultyId;

	public Faculty() {
	}

	public Faculty(int facultyId, Integer facultyNum, String facultyName, Collection<Student> studentsByFacultyId) {
		this.facultyId = facultyId;
		this.facultyNum = facultyNum;
		this.facultyName = facultyName;
		this.studentsByFacultyId = studentsByFacultyId;
	}
}
