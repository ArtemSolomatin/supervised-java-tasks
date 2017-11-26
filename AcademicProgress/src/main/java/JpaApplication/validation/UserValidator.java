package JpaApplication.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import JpaApplication.entity.User;
import JpaApplication.service.UserService;

/**
 * Created by Artem Solomatin on 25.10.17.
 * AcademicProgress
 *
 * To provide input-data validation for /registration controller with Spring Validator, we implement org.springframework.validation.Validator.
 */

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

	@Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

	/**
	 * Отсеиваем плохие значения login и password
	 */
	@Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        if (user.getUsername().length() < 4 || user.getUsername().length() > 16) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getPassword().length() < 4 || user.getPassword().length() > 12) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }
    }
}
