package JpaApplication.controller;

import JpaApplication.entity.Assessment;
import JpaApplication.service.AssessmentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Artem Solomatin on 23.09.17.
 * AcademicProgress
 */

@Controller
public class AssessmentController {
	@Autowired
	AssessmentService assessmentService;

	@RequestMapping(value = "getAllAssessments", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody List<Assessment> getAllStudents(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		return assessmentService.getAll();
	}
//TODO удалить все пробелы
	@RequestMapping(value = "addAssessment", method = RequestMethod.GET)
	//http://localhost:8090/addAssessment?assessmentId=0&studentId=1&subjectId=2&semesterNum=3&mark=6&examinerSurname=TestExaminer
	public void addStudent(HttpServletResponse response, HttpServletRequest request){
		Integer assessmentId = Integer.parseInt(StringUtils.deleteWhitespace(request.getParameter("assessmentId")));
		Integer studentId = Integer.parseInt(request.getParameter("studentId"));
		Integer subjectId = Integer.parseInt(request.getParameter("subjectId"));
		Integer semesterNum = Integer.parseInt(request.getParameter("semesterNum"));
		Integer mark = Integer.parseInt(request.getParameter("mark"));
		String examinerSurname = request.getParameter("examinerSurname");
		response.setHeader("Access-Control-Allow-Origin", "*");
		assessmentService.addAssessment(assessmentId, studentId, subjectId, semesterNum, mark, examinerSurname);
	}

	@RequestMapping(value = "deleteAssessment", method = RequestMethod.GET)
	public void deleteAssessment(HttpServletResponse response, HttpServletRequest request){
		Integer assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
		response.setHeader("Access-Control-Allow-Origin", "*");
		assessmentService.delete(assessmentId);
	}

	@RequestMapping(value = "getAssessmentById", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody Assessment getById(HttpServletResponse response, HttpServletRequest request){
		Integer assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
		response.setHeader("Access-Control-Allow-Origin", "*");
		Assessment res = assessmentService.getById(assessmentId);
		if(res != null) {
			return res;
		}else{
			throw new NoSuchElementException("No such assessment in db");
		}
	}
}
