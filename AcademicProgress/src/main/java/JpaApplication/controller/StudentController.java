package JpaApplication.controller;

import JpaApplication.entity.Student;
import JpaApplication.entity.Subject;
import JpaApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Artem Solomatin on 22.09.17.
 * AcademicProgress
 */

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "getAllStudents", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody
	List<Student> getAllStudents(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<Student> students = studentService.getAll();
		return students;
	}

	@RequestMapping(value = "addStudent", method = RequestMethod.GET)
	//http://localhost:8090/addStudent?studentId=0&facultyId=2&recordbookNum=0&fullName=TestStudent&groupNum=533
	public ModelAndView addStudent(HttpServletResponse response, HttpServletRequest request){
		Integer studentId = Integer.parseInt(request.getParameter("studentId"));
		Integer facultyId = Integer.parseInt(request.getParameter("facultyId"));
		Integer recordbookNum = Integer.parseInt(request.getParameter("recordbookNum"));
		String fullName = request.getParameter("fullName");
		Integer groupNum = Integer.parseInt(request.getParameter("groupNum"));
		response.setHeader("Access-Control-Allow-Origin", "*");
		String string = studentService.addStudent(studentId, facultyId, recordbookNum, fullName, groupNum);
		return new ModelAndView("view/models/student", "resultObject",
			"Object was added " + string);
	}

	@RequestMapping(value = "deleteStudent", method = RequestMethod.GET)
	public ModelAndView deleteStudent(HttpServletResponse response, HttpServletRequest request){
		Integer studentId = Integer.parseInt(request.getParameter("studentId"));
		response.setHeader("Access-Control-Allow-Origin", "*");
		boolean res = studentService.delete(studentId);
		if(res){
			return new ModelAndView("view/models/student", "resultObject",
					"Student was deleted");
		}
		else{
			return new ModelAndView("view/models/student", "resultObject",
					"Student wasn't deleted");
		}
	}

	@RequestMapping(value = "getStudentById", method = RequestMethod.GET)
	public ModelAndView getById(HttpServletResponse response, HttpServletRequest request){
		Integer studentId = Integer.parseInt(request.getParameter("studentId"));
		response.setHeader("Access-Control-Allow-Origin", "*");
		Student res = studentService.getById(studentId);
		if(res != null) {
			return new ModelAndView("view/models/student", "resultObject",
				res);
		}else{
			return new ModelAndView("view/models/student", "resultObject",
				"No such student in db");
		}
	}
}
