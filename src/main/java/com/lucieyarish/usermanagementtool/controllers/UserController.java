package com.lucieyarish.usermanagementtool.controllers;

import com.lucieyarish.usermanagementtool.models.User;
import com.lucieyarish.usermanagementtool.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/")
    public String users(Model model){
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/user/{id}")
    public String modifyUserStatus(@PathVariable Long id) {
        userService.changeUserStatus(id);
        return "redirect:/";
    }

    @GetMapping("/removeUser/{id}")
    public String removeUser(@PathVariable Long id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}
