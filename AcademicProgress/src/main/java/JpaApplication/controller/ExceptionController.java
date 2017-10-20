package JpaApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Artem Solomatin on 23.09.17.
 * AcademicProgress
 */

/**
 * Обрабатывается в HandlerException
 */
@Controller
public class ExceptionController {
	@RequestMapping(value = "/runtimeException", method = RequestMethod.GET)
	public void throwException( ) {
		throw new RuntimeException();
	}
}
