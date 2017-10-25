package JpaApplication.service;

import JpaApplication.entity.Student;
import JpaApplication.repository.StudentRepository;
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
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@PersistenceContext
	private EntityManager entityManager;

//FIXME Если добавлять уже существующий элемент, то бросается исключение, блок try/catch не помогает
	@Override
	public String addStudent(Integer studentId, Integer facultyId, Integer recordbookNum, String fullName, Integer groupNum) {
		Query query = entityManager.createNativeQuery("INSERT INTO Student values (?, ?, ?, ?, ?)");
		query.setParameter(1, studentId);
		query.setParameter(2, facultyId);
		query.setParameter(3, recordbookNum);
		query.setParameter(4, fullName);
		query.setParameter(5, groupNum);

		int result = query.executeUpdate();
		if(result > 0) return "successfully";
		else return "unsuccessfully";
	}

	@Override
	public boolean delete(int id) {
		if(getById(id) == null){
			return false;
		}
		studentRepository.deleteByStudentId(id);
		return true;
	}

	@Override
	public Student getById(int studentId) {
		return studentRepository.findByStudentId(studentId);
	}

	@Override
	public List<Student> getAll() {
		return studentRepository.findAll();
	}
}
