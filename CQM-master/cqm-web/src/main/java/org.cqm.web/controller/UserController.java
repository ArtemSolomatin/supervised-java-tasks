package org.cqm.web.controller;

import org.cqm.data.entity.User;
import org.cqm.data.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "/users")
    public String listRatingTable(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentName = auth.getName();
        User currentUser = null;
        List<User> users = userService.getUserRepository().findUsersOrderByRatingDesc();
        int rank = 1;
        int shift = 1;
        users.get(0).setRank(1);
        for (int i = 1; i < users.size(); i++) {
            if (users.get(i).getRating() == users.get(i - 1).getRating()) {
                shift++;
                users.get(i).setRank(rank);
            }
            if (users.get(i).getRating() != users.get(i - 1).getRating()) {
                rank += shift;
                users.get(i).setRank(rank);
                shift = 1;
            }
            if (users.get(i - 1).getLogin().equals(currentName)) {
                currentUser = users.get(i - 1);
            }
        }

        if (users.get(users.size() - 1).getLogin().equals(currentName)) {
            currentUser = users.get(users.size() - 1);
        }

        if (users.size() < 5) {
        } else {
            users = users.subList(0, 5);
        }
        model.addAttribute("users", users);
        model.addAttribute("currentName", currentName);
        model.addAttribute("currentRating", currentUser.getRating());
        model.addAttribute("currentRank", currentUser.getRank());
        return "user";
    }
}
