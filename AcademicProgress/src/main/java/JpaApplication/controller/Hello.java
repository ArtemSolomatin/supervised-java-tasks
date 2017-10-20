package JpaApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Artem Solomatin on 20.09.17.
 * AcademicProgress
 */

@Controller
public class Hello {

	//Приветственныю страничку проще сделать красиво без json, она все равно не за что не отвечает
	@RequestMapping(value = {"/", "hello"}, method = RequestMethod.GET)
	public String hello(){
		return "view/startPage/hello";
	}
}
