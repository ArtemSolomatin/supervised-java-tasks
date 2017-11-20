package JpaApplication.controller;

import JpaApplication.entity.Assessment;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Artem Solomatin on 23.09.17.
 * AcademicProgress
 */

@Controller
public class SubjectController {
	@Autowired
	SubjectService subjectService;

	@RequestMapping(value = "getAllSubjects", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody
	List<Subject> getAllSubjects(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		return subjectService.getAll();
	}

	@RequestMapping(value = "addSubject", method = RequestMethod.GET)
	//http://localhost:8090/addSubject?subjectId=0&subjectNum=0&subjectName=TestSubject
	public void addSubject(HttpServletResponse response, HttpServletRequest request){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Integer subjectId = Integer.parseInt(request.getParameter("subjectId"));
		Integer subjectNum = Integer.parseInt(request.getParameter("subjectNum"));
		String subjectName = request.getParameter("subjectName");
		subjectService.addSubject(subjectId, subjectNum, subjectName);
	}

	@RequestMapping(value = "deleteSubject", method = RequestMethod.GET)
	public void deleteSubject(HttpServletResponse response, HttpServletRequest request){
		Integer subjectId = Integer.parseInt(request.getParameter("subjectId"));
		response.setHeader("Access-Control-Allow-Origin", "*");
		subjectService.delete(subjectId);
	}

	@RequestMapping(value = "getSubjectById", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody
	Subject getById(HttpServletResponse response, HttpServletRequest request){
		Integer subjectId = Integer.parseInt(request.getParameter("subjectId"));
		response.setHeader("Access-Control-Allow-Origin", "*");
		Subject res = subjectService.getById(subjectId);
		if(res != null) {
			return res;
		}else{
			throw new NoSuchElementException("нет такого элемента в бд");
		}
	}
}
