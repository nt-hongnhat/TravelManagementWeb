package com.lth.controllers;

import com.lth.pojos.User;
import com.lth.service.CategoryService;
import com.lth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userDetailsService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") User user) {
//        xử lý password nên đặt tong validation
        String errorMessage = "";
        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (userDetailsService.registerUser(user) == true)
                return "redirect:/login";
            else
                errorMessage = "Đã có lỗi xảy ra!";
        } else
            errorMessage = "Mật khẩu không khớp!";

        model.addAttribute("errorMessage", errorMessage);
        return "register";
    }
}
