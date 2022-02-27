package com.lucieyarish.usermanagementtool.controllers;

import com.lucieyarish.usermanagementtool.models.User;
import com.lucieyarish.usermanagementtool.services.UserService;
import com.lucieyarish.usermanagementtool.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserServiceImpl userServiceImpl;

    @GetMapping(path = "/")
    public String users(Model model){
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);

        return "index";
    }

    @GetMapping("/search")
    public String viewMatchingResults(Model model, @Param("keyword") String keyword) {
        List<User> users = userService.listAllContainingKeyword(keyword);
        model.addAttribute("users", users);
        model.addAttribute("keyword", keyword);

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
        user.setCreatedOn(LocalDate.now());
        userService.saveUser(user);

        return "redirect:/";
    }

    @GetMapping("/listUsers")
    public String listUsers(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<User> userPage = userServiceImpl.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("bookPage", userPage);

        int totalPages = userPage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "index";
    }

}
