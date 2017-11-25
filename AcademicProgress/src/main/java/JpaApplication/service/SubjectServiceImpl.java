package JpaApplication.service;

import JpaApplication.entity.Subject;
import JpaApplication.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Artem Solomatin on 10.09.17.
 * AcademicProgress
 */

@Service
@Transactional //need to update\delete queries.
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addSubject(Integer subjectId, Integer subjectNum, String subjectName) {
		Query query = entityManager.createNativeQuery("INSERT INTO subject values (?, ?, ?)");
		query.setParameter(1, subjectId);
		query.setParameter(2, subjectNum);
		query.setParameter(3, subjectName);

		query.executeUpdate();
	}

	@Override
	public void delete(int id) {
		subjectRepository.deleteBySubjectId(id);
	}

	@Override
	public Subject getById(Integer id) {
		return subjectRepository.findBySubjectId(id);
	}

	@Override
	public List<Subject> getAll() {
		return subjectRepository.findAll();
	}
}
