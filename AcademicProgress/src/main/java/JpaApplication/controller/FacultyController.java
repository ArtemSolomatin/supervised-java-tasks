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
import java.util.NoSuchElementException;

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
		return facultyService.getAll();
	}

	@RequestMapping(value = "addFaculty", method = RequestMethod.GET)
	//http://localhost:8090/addFaculty?facultyId=0&facultyNum=6&facultyName=TestFaculty
	public void addFaculty(HttpServletResponse response, HttpServletRequest request){
		Integer facultyId = Integer.parseInt(request.getParameter("facultyId"));
		Integer facultyNum = Integer.parseInt(request.getParameter("facultyNum"));
		String facultyName = request.getParameter("facultyName");
		response.setHeader("Access-Control-Allow-Origin", "*");
		facultyService.addFaculty(facultyId, facultyNum, facultyName);
	}

	@RequestMapping(value = "deleteFaculty", method = RequestMethod.GET)
	public void deleteFaculty(HttpServletResponse response, HttpServletRequest request){
		Integer facultyId = Integer.parseInt(request.getParameter("facultyId"));
		response.setHeader("Access-Control-Allow-Origin", "*");
		facultyService.delete(facultyId);
	}

	@RequestMapping(value = "getFacultyById", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody Faculty getById(HttpServletResponse response, HttpServletRequest request){
		Integer facultyId = Integer.parseInt(request.getParameter("facultyId"));
		response.setHeader("Access-Control-Allow-Origin", "*");
		Faculty res = facultyService.getById(facultyId);
		if(res != null) {
			return res;
		}else{
			throw new NoSuchElementException("No such faculty in db");
		}
	}
}
