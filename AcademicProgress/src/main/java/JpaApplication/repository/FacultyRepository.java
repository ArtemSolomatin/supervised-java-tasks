package JpaApplication.repository;

import JpaApplication.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Artem Solomatin on 09.09.17.
 * AcademicProgress
 */

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
	@Query("select f from Faculty f where f.facultyName = :facultyName")
	Faculty findByName(@Param("facultyName") String facultyName);

//	@Query(value = "INSERT INTO Faculty values (:facultyId, :facultyNum, :facultyName)", nativeQuery = true)
//	Faculty addFaculty(@Param("facultyId") Integer facultyId, @Param("facultyNum") Integer facultyNum, @Param("facultyName") String facultyName);
}
