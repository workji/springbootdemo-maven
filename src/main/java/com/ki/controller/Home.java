package com.ki.controller;

import com.ki.repository.MultiRepository;
import com.ki.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @Autowired
    private SingerRepository singerRepository;

    @Autowired
    private MultiRepository multiRepository;

    @GetMapping("/")
    public String test1(Model model) {
        model.addAttribute("singers", singerRepository.findAll());
        model.addAttribute("multikeys", multiRepository.findAll());
        return "index";
    }
}
