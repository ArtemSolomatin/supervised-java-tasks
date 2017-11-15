package JpaApplication.controller;

import JpaApplication.entity.Assessment;
import JpaApplication.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
		List<Assessment> assessments = assessmentService.getAll();
		return assessments;
	}

	@RequestMapping(value = "addAssessment?assessmentId={assessmentId}&studentId={studentId}&subjectId={subjectId}&semesterNum={semesterNum}&mark={mark}&examinerSurname={examinerSurname}", method = RequestMethod.GET)
	//http://localhost:8090/addAssessment?assessmentId=0&studentId=1&subjectId=2&semesterNum=3&mark=6&examinerSurname=TestExaminer
	public ModelAndView addStudent(HttpServletResponse response, HttpServletRequest request
	){
		Integer assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
		Integer studentId = Integer.parseInt(request.getParameter("studentId"));
		Integer subjectId = Integer.parseInt(request.getParameter("subjectId"));
		Integer semesterNum = Integer.parseInt(request.getParameter("semesterNum"));
		Integer mark = Integer.parseInt(request.getParameter("mark"));
		String examinerSurname = request.getParameter("examinerSurname");
		response.setHeader("Access-Control-Allow-Origin", "*");
		String string = assessmentService.addAssessment(assessmentId, studentId, subjectId, semesterNum, mark, examinerSurname);
		return new ModelAndView("view/models/assessment", "resultObject", "Object was added " + string);
	}

	@RequestMapping(value = "deleteAssessment?assessmentId={assessmentId}", method = RequestMethod.GET)
	public ModelAndView deleteAssessment(HttpServletResponse response, HttpServletRequest request){
		Integer assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
		response.setHeader("Access-Control-Allow-Origin", "*");
		boolean res = assessmentService.delete(assessmentId);
		if(res){
			return new ModelAndView("view/models/assessment", "resultObject",
				"Assessment was deleted");
		}
		else{
			return new ModelAndView("view/models/assessment", "resultObject",
				"Assessment wasn't deleted");
		}
	}

	@RequestMapping(value = "getById?assessmentId={assessmentId}", method = RequestMethod.GET)
	public ModelAndView getById(HttpServletResponse response, HttpServletRequest request){
		Integer assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
		response.setHeader("Access-Control-Allow-Origin", "*");
		Assessment res = assessmentService.getById(assessmentId);
		if(res != null) {
			return new ModelAndView("view/models/assessment", "resultObject",
				res);
		}else{
			return new ModelAndView("view/models/assessment", "resultObject",
				"No such assessment in db");
		}
	}
}
