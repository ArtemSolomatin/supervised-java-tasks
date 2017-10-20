package JpaApplication.service;

import JpaApplication.entity.Student;

import java.util.List;

/**
 * Created by Artem Solomatin on 10.09.17.
 * AcademicProgress
 */
public interface StudentService {
	String addStudent(Integer studentId, Integer facultyId, Integer recordbookNum, String fullName, Integer groupNum);
	void delete(int id);
	Student getByName(String name);
	List<Student> getAll();
}
