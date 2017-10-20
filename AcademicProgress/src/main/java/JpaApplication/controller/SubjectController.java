package JpaApplication.controller;

import JpaApplication.entity.Subject;
import JpaApplication.service.SubjectService;
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
public class SubjectController {
	@Autowired
	SubjectService subjectService;

	@RequestMapping(value = "getAllSubjects", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody List<Subject> getAllSubjects(){
		List<Subject> subjects = subjectService.getAll();
		return subjects;
	}

	@RequestMapping(value = "addSubject/subjectId/{subjectId}/subjectNum/{subjectNum}/subjectName/{subjectName}", method = RequestMethod.GET)
	//http://localhost:8090/addSubject/subjectId/3/subjectNum/3/subjectName/TestSubject
	public ModelAndView addStudent(
		@PathVariable(value = "subjectId") Integer subjectId,
		@PathVariable(value = "subjectNum") Integer subjectNum,
		@PathVariable(value = "subjectName") String subjectName
	){
		String string = subjectService.addSubject(subjectId, subjectNum, subjectName);
		return new ModelAndView("view/models/subject", "resultObject", "Object was added " + string);
	}
}
