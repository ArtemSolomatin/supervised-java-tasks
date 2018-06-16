package org.cqm.web.controller;

import org.cqm.data.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class IndexController {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "/")
    public String printIndex(ModelMap model) {
        return "index";
    }
}
