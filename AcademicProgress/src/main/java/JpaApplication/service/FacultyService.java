package JpaApplication.service;

import JpaApplication.entity.Faculty;

import java.util.List;

/**
 * Created by Artem Solomatin on 10.09.17.
 * AcademicProgress
 */
public interface FacultyService {
	String addFaculty(Integer facultyId, Integer facultyNum, String facultyName);
	void delete(int id);
	Faculty getByName(String name);
	List<Faculty> getAll();
}
