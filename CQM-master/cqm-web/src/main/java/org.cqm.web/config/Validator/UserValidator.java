package org.cqm.web.config.Validator;

import org.cqm.data.entity.User;
import org.cqm.data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.apache.commons.validator.routines.EmailValidator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "username.empty", "Это поле необходимо заполнить.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty", "Это поле необходимо заполнить.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Это поле необходимо заполнить.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "confirmPassword.empty", "Это поле необходимо заполнить.");


        if (user.getLogin().length() < 6 || user.getLogin().length() > 15) {
            errors.rejectValue("login", "username.tooLong", "Длина имени пользователя от 6 до 15 символов.");
        }

        if (userService.findUserByLogin(user.getLogin()) != null) {
            errors.rejectValue("login", "username.duplicate", "Такой пользователь уже зарегистрирован.");
        }

        if (!EmailValidator.getInstance().isValid(user.getEmail())) {
            errors.rejectValue("email", "email.notValid", "Некорректный email.");
        }

        if (userService.findUserByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "email.duplicate", "Пользователь с таким email уже зарегистрирован.");
        }

        if (user.getPassword().length() < 8 || user.getPassword().length() > 25) {
            errors.rejectValue("password", "password.tooLong", "Длина пароля от 8 до 25 символов.");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "confirmPassword.passwordDontMatch", "Введенные пароли не совпадают.");
        }
    }
}
