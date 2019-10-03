package com.ki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String test1() {
        return "login";
    }

    @PostMapping("/login")
    public String test2() {
        return "index";
    }

    @GetMapping("/logout")
    public String test3() {
        return "login";
    }
}
