package JpaApplication.service;

import JpaApplication.entity.Assessment;
import JpaApplication.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Artem Solomatin on 09.09.17.
 * AcademicProgress
 */

@Service
@Transactional //need to update\delete queries.
public class AssessmentServiceImpl implements AssessmentService {

	@Autowired
	private AssessmentRepository assessmentRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addAssessment(Integer assessmentId, Integer studentId, Integer subjectId, Integer semesterNum, Integer mark, String examinerSurname) {
		Query query = entityManager.createNativeQuery("INSERT INTO assessment values (?, ?, ?, ?, ?, ?)");
		query.setParameter(1, assessmentId);
		query.setParameter(2, studentId);
		query.setParameter(3, subjectId);
		query.setParameter(4, semesterNum);
		query.setParameter(5, mark);
		query.setParameter(6, examinerSurname);

		query.executeUpdate();
	}

	@Override
	public void delete(int id) {
		assessmentRepository.deleteByAssessmentId(id);
	}

	@Override
	public Assessment getById(Integer assessmentId) {
		return assessmentRepository.findByAssessmentId(assessmentId);
	}

	@Override
	public List<Assessment> getAll() {

		return assessmentRepository.findAll();
	}
}
