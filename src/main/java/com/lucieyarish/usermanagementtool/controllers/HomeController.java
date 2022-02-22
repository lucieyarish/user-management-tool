package com.lucieyarish.usermanagementtool.controllers;

import com.lucieyarish.usermanagementtool.UserManagementToolApplication;
import com.lucieyarish.usermanagementtool.models.User;
import com.lucieyarish.usermanagementtool.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class HomeController {

    private final UserRepository userRepository;

//    @GetMapping(path = "/")
//    @ResponseBody
//    public String index(){
//        return "Hello World!";
//    }

    @GetMapping(path = "/")
    @ResponseBody
    public List<User> index(){
        List<User> users = userRepository.findAll();
        return users;
    }
}
