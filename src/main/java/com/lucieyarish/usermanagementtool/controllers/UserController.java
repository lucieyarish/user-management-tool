package com.lucieyarish.usermanagementtool.controllers;

import com.lucieyarish.usermanagementtool.models.User;
import com.lucieyarish.usermanagementtool.services.UserService;
import com.lucieyarish.usermanagementtool.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String getAllPages(Model model){

        return getOnePage(model, 1);
    }

    @GetMapping("/page/{pageNumber}")
    public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {

        Page<User> page = userService.findPage(currentPage);
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<User> users = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("users", users);

        return "index";
    }

    @GetMapping("/search")
    public String viewMatchingResults(Model model, @Param("keyword") String keyword) {

        List<User> users = userService.listAllContainingKeyword(keyword);
        int currentPage = 1;
        Page<User> page = userService.findPage(currentPage);
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();

        model.addAttribute("users", users);
        model.addAttribute("keyword", keyword);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);

            return "index";

    }

    @GetMapping("/searchByDate")
    public String viewMatchingDate(Model model, String startDate, String endDate) {

        List<User> users = userService.searchByDate(LocalDate.parse(startDate), LocalDate.parse(endDate));

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
        user.setCreatedOn(LocalDate.now());
        userService.saveUser(user);

        return "redirect:/";
    }
}
