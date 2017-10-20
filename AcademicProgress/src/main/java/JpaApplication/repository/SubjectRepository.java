package JpaApplication.repository;

import JpaApplication.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Artem Solomatin on 09.09.17.
 * AcademicProgress
 */

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	@Query("select s from Subject s where s.subjectName = :subjectName")
	Subject findByName(@Param("subjectName") String subjectName);

//	@Query(value = "INSERT INTO Subject values (:subjectId, :subjectNum, :subjectName)", nativeQuery = true)
//	void addSubject(@Param("subjectId") Integer subjectId, @Param("subjectNum") Integer subjectNum, @Param("subjectName") String subjectName);
}
