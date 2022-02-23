package com.lucieyarish.usermanagementtool.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {

    @GetMapping(path = "/")
    public String index(){
        return "index";
    }
}
