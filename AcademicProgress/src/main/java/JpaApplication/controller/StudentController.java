package JpaApplication.controller;

import JpaApplication.entity.Student;
import JpaApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	List<Student> getAllStudents(){
		List<Student> students = studentService.getAll();
		return students;
	}

	@RequestMapping(value = "addStudent/studentId/{studentId}/facultyId/{facultyId}/recordbookNum/{recordbookNum}/fullName/{fullName}/groupNum/{groupNum}", method = RequestMethod.GET)
	//http://localhost:8090/addStudent/studentId/0/facultyId/2/recordbookNum/0/fullName/TestStudent/groupNum/533
	public ModelAndView addStudent(
		@PathVariable(value = "studentId") Integer studentId,
		@PathVariable(value = "facultyId") Integer facultyId,
		@PathVariable(value = "recordbookNum") Integer recordbookNum,
		@PathVariable(value = "fullName") String fullName,
		@PathVariable(value = "groupNum") Integer groupNum
	){
		String string = studentService.addStudent(studentId, facultyId, recordbookNum, fullName, groupNum);
		return new ModelAndView("view/models/student", "resultObject",
			"Object was added " + string);
	}

	@RequestMapping(value = "deleteStudent/studentId/{studentId}", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@PathVariable(value = "studentId") Integer studentId){
			boolean response = studentService.delete(studentId);
			if(response){
				return new ModelAndView("view/models/student", "resultObject",
					"Student was deleted");
			}
			else{
				return new ModelAndView("view/models/student", "resultObject",
					"Student wasn't deleted");
			}
	}

	@RequestMapping(value = "getById/studentId/{studentId}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable(value = "studentId") Integer studentId){
		Student response = studentService.getById(studentId);
		if(response != null) {
			return new ModelAndView("view/models/student", "resultObject",
				response);
		}else{
			return new ModelAndView("view/models/student", "resultObject",
				"No such student in db");
		}
	}
}
