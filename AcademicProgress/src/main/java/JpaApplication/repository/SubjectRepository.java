package JpaApplication.repository;

import JpaApplication.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Artem Solomatin on 09.09.17.
 * AcademicProgress
 */

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	@Query("select s from Subject s where s.subjectId = :subjectId")
	Subject findBySubjectId(@Param("subjectId") int subjectId);

	@Transactional
	@Modifying
	@Query("delete from Subject s where s.subjectId = :subjectId")
	void deleteBySubjectId(@Param("subjectId") int subjectId);

//	@Query(value = "INSERT INTO Subject values (:subjectId, :subjectNum, :subjectName)", nativeQuery = true)
//	void addSubject(@Param("subjectId") Integer subjectId, @Param("subjectNum") Integer subjectNum, @Param("subjectName") String subjectName);
}
