package JpaApplication.service;

import JpaApplication.entity.Faculty;
import JpaApplication.repository.FacultyRepository;
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
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	private FacultyRepository facultyRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public String addFaculty(Integer facultyId, Integer facultyNum, String facultyName) {
		Query query = entityManager.createNativeQuery("INSERT INTO faculty values (?, ?, ?)");
		query.setParameter(1, facultyId);
		query.setParameter(2, facultyNum);
		query.setParameter(3, facultyName);

		int result = query.executeUpdate();
		if(result > 0) return "successfully";
		else return "unsuccessfully";
	}

	@Override
	public boolean delete(int id) {
		if(getById(id) == null){
			return false;
		}
		facultyRepository.deleteByFacultyId(id);
		return true;
	}

	@Override
	public Faculty getById(int id) {
		return facultyRepository.findByFacultyId(id);
	}

	@Override
	public List<Faculty> getAll() {
		return facultyRepository.findAll();
	}
}
