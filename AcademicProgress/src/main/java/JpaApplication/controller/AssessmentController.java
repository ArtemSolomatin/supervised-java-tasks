package JpaApplication.controller;

import JpaApplication.entity.Assessment;
import JpaApplication.entity.Faculty;
import JpaApplication.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	public @ResponseBody List<Assessment> getAllStudents(){
		List<Assessment> assessments = assessmentService.getAll();
		return assessments;
	}

	@RequestMapping(value = "addAssessment/assessmentId/{assessmentId}/studentId/{studentId}/subjectId/{subjectId}/semesterNum/{semesterNum}/mark/{mark}/examinerSurname/{examinerSurname}", method = RequestMethod.GET)
	//http://localhost:8090/addAssessment/assessmentId/0/studentId/1/subjectId/2/semesterNum/3/mark/6/examinerSurname/TestExaminer
	public ModelAndView addStudent(
		@PathVariable(value = "assessmentId") Integer assessmentId,
		@PathVariable(value = "studentId") Integer studentId,
		@PathVariable(value = "subjectId") Integer subjectId,
		@PathVariable(value = "semesterNum") Integer semesterNum,
		@PathVariable(value = "mark") Integer mark,
		@PathVariable(value = "examinerSurname") String examinerSurname
	){
		String string = assessmentService.addAssessment(assessmentId, studentId, subjectId, semesterNum, mark, examinerSurname);
		return new ModelAndView("view/models/assessment", "resultObject", "Object was added " + string);
	}

	@RequestMapping(value = "deleteAssessment/assessmentId/{assessmentId}", method = RequestMethod.GET)
	public ModelAndView deleteAssessment(@PathVariable(value = "assessmentId") Integer assessmentId){
		boolean responce = assessmentService.delete(assessmentId);
		if(responce){
			return new ModelAndView("view/models/assessment", "resultObject",
				"Assessment was deleted");
		}
		else{
			return new ModelAndView("view/models/assessment", "resultObject",
				"Assessment wasn't deleted");
		}
	}

	@RequestMapping(value = "getById/assessmentId/{assessmentId}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable(value = "assessmentId") Integer assessmentId){
		Assessment responce = assessmentService.getById(assessmentId);
		if(responce != null) {
			return new ModelAndView("view/models/assessment", "resultObject",
				responce);
		}else{
			return new ModelAndView("view/models/assessment", "resultObject",
				"No such assessment in db");
		}
	}
}
