package JpaApplication.controller;

import JpaApplication.entity.Faculty;
import JpaApplication.service.FacultyService;
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
public class FacultyController {
	@Autowired
	FacultyService facultyService;

	@RequestMapping(value = "getAllFaculties", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody
	List<Faculty> getAllFaculties(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<Faculty> faculties = facultyService.getAll();
		return faculties;
	}

	@RequestMapping(value = "addFaculty", method = RequestMethod.GET)
	//http://localhost:8090/addFaculty?facultyId=0&facultyNum=6&facultyName=TestFaculty
	public ModelAndView addFaculty(HttpServletResponse response, HttpServletRequest request){
		Integer facultyId = Integer.parseInt(request.getParameter("facultyId"));
		Integer facultyNum = Integer.parseInt(request.getParameter("facultyNum"));
		String facultyName = request.getParameter("facultyName");
		response.setHeader("Access-Control-Allow-Origin", "*");

		String string = facultyService.addFaculty(facultyId, facultyNum, facultyName);
		return new ModelAndView("view/models/faculty", "resultObject", "Object was added " + string);
	}

	@RequestMapping(value = "deleteFaculty?facultyId={facultyId}", method = RequestMethod.GET)
	public ModelAndView deleteFaculty(HttpServletResponse response, HttpServletRequest request){
		Integer facultyId = Integer.parseInt(request.getParameter("facultyId"));
		response.setHeader("Access-Control-Allow-Origin", "*");
		boolean res = facultyService.delete(facultyId);
		if(res){
			return new ModelAndView("view/models/faculty", "resultObject",
				"Faculty was deleted");
		}
		else{
			return new ModelAndView("view/models/faculty", "resultObject",
				"Faculty wasn't deleted");
		}
	}

	@RequestMapping(value = "getById?facultyId={facultyId}", method = RequestMethod.GET)
	public ModelAndView getById(HttpServletResponse response, HttpServletRequest request){
		Integer facultyId = Integer.parseInt(request.getParameter("facultyId"));
		response.setHeader("Access-Control-Allow-Origin", "*");
		Faculty res = facultyService.getById(facultyId);
		if(res != null) {
			return new ModelAndView("view/models/faculty", "resultObject",
				res);
		}else{
			return new ModelAndView("view/models/faculty", "resultObject",
				"No such faculty in db");
		}
	}
}
