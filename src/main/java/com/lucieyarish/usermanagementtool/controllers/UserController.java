package com.lucieyarish.usermanagementtool.controllers;

import com.lucieyarish.usermanagementtool.models.User;
import com.lucieyarish.usermanagementtool.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @GetMapping("/changeStatus/{id}")
    public String modifyUserStatus(@PathVariable Long id) {
        userService.changeUserStatus(id);
        return "redirect:/";
    }

    @GetMapping("/removeUser/{id}")
    public String removeUser(@PathVariable Long id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @GetMapping("/user/{id}")
    public String displayUser(@PathVariable Long id, Model model) {
        model.addAttribute("userInfo", userService.getUserById(id));
        return "editUser";
    }

    @PostMapping("/editUser")
    public String editUser(@ModelAttribute User user) {
        user.setCreatedOn(LocalDateTime.now());
        userService.saveUser(user);
        return "redirect:/";
    }
}
