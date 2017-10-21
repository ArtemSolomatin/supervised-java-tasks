package JpaApplication.service;

import JpaApplication.entity.Student;

import java.util.List;

/**
 * Created by Artem Solomatin on 10.09.17.
 * AcademicProgress
 */
public interface StudentService {
	String addStudent(Integer studentId, Integer facultyId, Integer recordbookNum, String fullName, Integer groupNum);
	boolean delete(int id);
	Student getById(int studentId);
	List<Student> getAll();
}
