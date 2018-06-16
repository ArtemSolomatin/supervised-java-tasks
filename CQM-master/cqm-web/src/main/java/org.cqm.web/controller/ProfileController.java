package org.cqm.web.controller;

import org.cqm.data.entity.User;
import org.cqm.data.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class ProfileController {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "/profile")
    public String printIndex(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User currentUser = userService.findUserByLogin(name);
        model.addAttribute("rating", currentUser.getRating());
        return ("profile");
    }
}
