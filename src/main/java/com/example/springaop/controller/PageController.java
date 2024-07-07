package com.example.springaop.controller;

import com.example.springaop.dto.LoginReqDto;
import com.example.springaop.dto.SignupRequestDto;
import com.example.springaop.security.UserDetailsImpl;
import com.example.springaop.service.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PageController {
    private final UserService userService;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());
        return "index";
    }

    @GetMapping("/api/user/login-page")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/api/user/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/api/user/signup")
    public String signup(@RequestBody SignupRequestDto reqDto) {
        userService.signup(reqDto);
        return "redirect:/api/user/login-page";
    }

    // HTML 전 후 비교 @RequestBody 어노테이션
//    @PostMapping("/user/login")
//    public String login(@RequestBody LoginReqDto reqDto, HttpServletResponse res) {
//        try {
//            userService.login(reqDto, res);
//        } catch (Exception e) {
//            return "redirect:/api/user/login-page?error";
//        }
//        return "redirect:/";
//    }
}