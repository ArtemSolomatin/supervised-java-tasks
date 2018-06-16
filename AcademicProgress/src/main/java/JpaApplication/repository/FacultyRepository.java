package JpaApplication.repository;

import JpaApplication.entity.Faculty;
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
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
	@Query("select f from Faculty f where f.facultyId = :facultyId")
	Faculty findByFacultyId(@Param("facultyId") Integer facultyId);

	@Transactional
	@Modifying
	@Query("delete from Faculty f where f.facultyId = :facultyId")
	void deleteByFacultyId(@Param("facultyId") int facultyId);

//	@Query(value = "INSERT INTO Faculty values (:facultyId, :facultyNum, :facultyName)", nativeQuery = true)
//	Faculty addFaculty(@Param("facultyId") Integer facultyId, @Param("facultyNum") Integer facultyNum, @Param("facultyName") String facultyName);
}
