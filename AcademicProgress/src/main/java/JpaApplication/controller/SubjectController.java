package JpaApplication.controller;

import JpaApplication.entity.Subject;
import JpaApplication.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

	@Secured(value={"ROLE_ADMIN", "ROLE_USER"})
	@RequestMapping(value = "getAllSubjects", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody
	ModelAndView getAllSubjects(){
		List<Subject> subjects = subjectService.getAll();
		return new ModelAndView("view/models/subject", "resultObject", subjects);
	}

	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "addSubject/subjectId/{subjectId}/subjectNum/{subjectNum}/subjectName/{subjectName}", method = RequestMethod.GET)
	//http://localhost:8090/addSubject/subjectId/0/subjectNum/0/subjectName/TestSubject
	public ModelAndView addSubject(
		@PathVariable(value = "subjectId") Integer subjectId,
		@PathVariable(value = "subjectNum") Integer subjectNum,
		@PathVariable(value = "subjectName") String subjectName
	) {
		String response = subjectService.addSubject(subjectId, subjectNum, subjectName);
		return new ModelAndView("view/models/subject", "resultObject", "Object was added "
			+ response);
	}

	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "deleteSubject/subjectId/{subjectId}", method = RequestMethod.GET)
	public ModelAndView deleteSubject(@PathVariable(value = "subjectId") Integer subjectId){
		boolean response = subjectService.delete(subjectId);
		if(response){
			return new ModelAndView("view/models/subject", "resultObject",
					"Subject was deleted");
		}else{
			return new ModelAndView("view/models/subject", "resultObject",
					"Subject wasn't deleted");
		}
	}

	@Secured(value={"ROLE_ADMIN", "ROLE_USER"})
	@RequestMapping(value = "getById/subjectId/{subjectId}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable(value = "subjectId") Integer subjectId){
		Subject responce = subjectService.getById(subjectId);
		if(responce != null) {
			return new ModelAndView("view/models/subject", "resultObject",
					responce);
		}else{
			return new ModelAndView("view/models/subject", "resultObject",
					"No such subject in db");
		}
	}
}
