package com.lucieyarish.usermanagementtool.controllers;

import com.lucieyarish.usermanagementtool.models.User;
import com.lucieyarish.usermanagementtool.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/users")
    public String users(Model model){
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "users";
    }
}
