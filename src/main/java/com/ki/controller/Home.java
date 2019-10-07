package com.ki.controller;

import com.ki.entity.Alert;
import com.ki.repository.MultiRepository;
import com.ki.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class Home {

    @Autowired
    private SingerRepository singerRepository;

    @Autowired
    private MultiRepository multiRepository;

    @GetMapping("/")
    public String test1(@ModelAttribute("alerts") List<Alert> alerts, Model model) {
        alerts.forEach(System.out::println);
        model.addAttribute("singers", singerRepository.findAll());
        model.addAttribute("multikeys", multiRepository.findAll());
        return "index";
    }

    @GetMapping("/doerror")
    public void test3() throws IOException {
        throw new IOException("test");
    }

    @PostMapping("/search")
    public String test4(@RequestParam("searchKey") String searchKey) {
        System.out.println(searchKey); // want ">GoXXXGo<" , but "XXX"
        return "index";
    }
}
