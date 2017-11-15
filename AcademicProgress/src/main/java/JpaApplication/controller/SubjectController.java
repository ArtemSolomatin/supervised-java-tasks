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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public @ResponseBody
	List<Subject> getAllSubjects(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<Subject> subjects = subjectService.getAll();
		return subjects;
	}

	@RequestMapping(value = "addSubject?subjectId={subjectId}&subjectNum={subjectNum}&subjectName={subjectName}", method = RequestMethod.GET)
	//http://localhost:8090/addSubject?subjectId=0&subjectNum=0&subjectName=TestSubject
	public ModelAndView addSubject(HttpServletResponse response, HttpServletRequest request){
		Integer subjectId = Integer.parseInt(request.getParameter("subjectId"));
		Integer subjectNum = Integer.parseInt(request.getParameter("subjectNum"));
		String subjectName = request.getParameter("subjectName");
		response.setHeader("Access-Control-Allow-Origin", "*");
		String res = subjectService.addSubject(subjectId, subjectNum, subjectName);
		return new ModelAndView("view/models/subject", "resultObject", "Object was added "
			+ res);
	}

	@RequestMapping(value = "deleteSubject?subjectId={subjectId}", method = RequestMethod.GET)
	public ModelAndView deleteSubject(@PathVariable(value = "subjectId") Integer subjectId, HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		boolean res = subjectService.delete(subjectId);
		if(res){
			return new ModelAndView("view/models/subject", "resultObject",
					"Subject was deleted");
		}else{
			return new ModelAndView("view/models/subject", "resultObject",
					"Subject wasn't deleted");
		}
	}

	@RequestMapping(value = "getById?subjectId={subjectId}", method = RequestMethod.GET)
	public ModelAndView getById(HttpServletResponse response, HttpServletRequest request){
		Integer subjectId = Integer.parseInt(request.getParameter("subjectId"));
		response.setHeader("Access-Control-Allow-Origin", "*");
		Subject res = subjectService.getById(subjectId);
		if(res != null) {
			return new ModelAndView("view/models/subject", "resultObject",
					res);
		}else{
			return new ModelAndView("view/models/subject", "resultObject",
					"No such subject in db");
		}
	}
}
