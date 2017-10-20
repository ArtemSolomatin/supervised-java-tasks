package JpaApplication.service;

import JpaApplication.entity.Assessment;

import java.util.List;

/**
 * Created by Artem Solomatin on 09.09.17.
 * AcademicProgress
 */
public interface AssessmentService {
	String addAssessment(Integer assessmentId, Integer studentId, Integer subjectId, Integer semesterNum, Integer mark, String examinerSurname);
	void delete(int id);
	Assessment getById(Integer assessmentId);
	List<Assessment> getAll();
}
