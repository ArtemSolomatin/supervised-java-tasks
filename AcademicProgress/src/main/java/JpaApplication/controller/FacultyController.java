package JpaApplication.controller;

import JpaApplication.entity.Faculty;
import JpaApplication.entity.Student;
import JpaApplication.service.FacultyService;
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
public class FacultyController {
	@Autowired
	FacultyService facultyService;

	@RequestMapping(value = "getAllFaculties", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody ModelAndView getAllFaculties(){
		List<Faculty> faculties = facultyService.getAll();
		return new ModelAndView("view/models/faculty", "resultObject", faculties);
	}

	@RequestMapping(value = "addFaculty/facultyId/{facultyId}/facultyNum/{facultyNum}/facultyName/{facultyName}", method = RequestMethod.GET)
	//http://localhost:8090/addFaculty/facultyId/0/facultyNum/6/facultyName/TestFaculty
	public ModelAndView addFaculty(
		@PathVariable(value = "facultyId") Integer facultyId,
		@PathVariable(value = "facultyNum") Integer facultyNum,
		@PathVariable(value = "facultyName") String facultyName
	){
		String string = facultyService.addFaculty(facultyId, facultyNum, facultyName);
		return new ModelAndView("view/models/faculty", "resultObject", "Object was added " + string);
	}

	@RequestMapping(value = "deleteFaculty/facultyId/{facultyId}", method = RequestMethod.GET)
	public ModelAndView deleteFaculty(@PathVariable(value = "facultyId") Integer facultyId){
		boolean responce = facultyService.delete(facultyId);
		if(responce){
			return new ModelAndView("view/models/faculty", "resultObject",
				"Faculty was deleted");
		}
		else{
			return new ModelAndView("view/models/faculty", "resultObject",
				"Faculty wasn't deleted");
		}
	}

	@RequestMapping(value = "getById/facultyId/{facultyId}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable(value = "facultyId") Integer facultyId){
		Faculty responce = facultyService.getById(facultyId);
		if(responce != null) {
			return new ModelAndView("view/models/faculty", "resultObject",
				responce);
		}else{
			return new ModelAndView("view/models/faculty", "resultObject",
				"No such faculty in db");
		}
	}
}
