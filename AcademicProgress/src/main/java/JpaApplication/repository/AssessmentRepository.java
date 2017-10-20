package JpaApplication.repository;

import JpaApplication.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Artem Solomatin on 09.09.17.
 * AcademicProgress
 */

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {
	@Query("select a from Assessment a where a.assessmentId = :assessmentId")
	Assessment findById(@Param("assessmentId") Integer assessmentId);

//	@Query(value = "INSERT INTO Assessment values (:assessmentId, :studentId, :subjectId, :semester, :mark, :examiner)", nativeQuery = true)
//	Assessment addAssessment(@Param("assessmentId") Integer assessmentId, @Param("studentId") Integer studentId, @Param("subjectId") Integer subjectId, @Param("semester") Integer semesterNum, @Param("mark") Integer mark, @Param("examiner") String examinerSurname);
}
