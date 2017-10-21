package JpaApplication.repository;

import JpaApplication.entity.Student;
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
public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query("select s from Student s where s.studentId = :studentId")
	Student findByStudentId(@Param("studentId") int studentId);

	@Transactional
	@Modifying
	@Query("delete from Student s where s.studentId = :studentId")
	void deleteByStudentId(@Param("studentId") int studentId);


//	@Query(value = "INSERT INTO Student values (:studentId, :facultyId, :recordbook, :fullName, :groupNum)", nativeQuery = true)
//	Student addStudent(@Param("studentId") Integer studentId, @Param("facultyId") Integer facultyId, @Param("recordbook") Integer recordbookNum, @Param("fullName") String fullName, @Param("groupNum") Integer groupNum);
}
