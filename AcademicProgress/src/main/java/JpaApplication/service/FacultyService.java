package JpaApplication.service;

import JpaApplication.entity.Faculty;

import java.util.List;

/**
 * Created by Artem Solomatin on 10.09.17.
 * AcademicProgress
 */
public interface FacultyService {
	String addFaculty(Integer facultyId, Integer facultyNum, String facultyName);
	boolean delete(int id);
	Faculty getById(int id);
	List<Faculty> getAll();
}
