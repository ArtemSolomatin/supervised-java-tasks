package JpaApplication.service;

import JpaApplication.entity.Subject;

import java.util.List;

/**
 * Created by Artem Solomatin on 10.09.17.
 * AcademicProgress
 */
public interface SubjectService {
	String addSubject(Integer subjectId, Integer subjectNum, String subjectName);
	void delete(int id);
	Subject getByName(String name);
	List<Subject> getAll();
}
