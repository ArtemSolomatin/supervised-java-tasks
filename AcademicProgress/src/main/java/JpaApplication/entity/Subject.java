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

@ToString(exclude = "assessmentsBySubjectId")
@EqualsAndHashCode
@Entity
public class Subject implements Serializable {
	@Id
	@Column(name = "subject_id", nullable = false, unique = true)
	@Setter @Getter private Integer subjectId;

	@Column(name = "subject_num", nullable = false)
	@Setter @Getter private Integer subjectNum;

	@Column(name = "subject_name", nullable = false, length = 40)
	@Setter @Getter private String subjectName;

	@JsonIgnore
	@OneToMany(mappedBy = "subjectBySubjectId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Setter @Getter private Collection<Assessment> assessmentsBySubjectId;

	public Subject() {
	}

	public Subject(int subjectId, Integer subjectNum, String subjectName, Collection<Assessment> assessmentsBySubjectId) {
		this.subjectId = subjectId;
		this.subjectNum = subjectNum;
		this.subjectName = subjectName;
		this.assessmentsBySubjectId = assessmentsBySubjectId;
	}
}
