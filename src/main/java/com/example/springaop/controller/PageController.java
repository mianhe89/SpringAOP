package com.example.springaop.controller;

import com.example.springaop.dto.LoginReqDto;
import com.example.springaop.dto.SignupRequestDto;
import com.example.springaop.service.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class PageController {

    private final UserService userService;

    @GetMapping("/user/login-page")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/user/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/user/signup")
    public String signup(SignupRequestDto reqDto) {
        userService.signup(reqDto);
        return "redirect:/api/user/login-page";
    }

    @PostMapping("/user/login")
    public String login(LoginReqDto reqDto, HttpServletResponse res) {
        try {
            userService.login(reqDto, res);
        } catch (Exception e) {
            return "redirect:/api/user/login-page?error";
        }
        return "redirect:/";
    }
}