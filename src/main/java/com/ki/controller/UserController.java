package com.ki.controller;

import com.ki.entity.UserEntity;
import com.ki.form.UserForm;
import com.ki.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = {"", "/", "/{page}"})
    public String test2(@PathVariable(required = false) Integer page, Model model) {
        if (page == null) page = 0;
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id").ascending());
        Page<UserEntity> users = userRepository.findAll(pageable);
        model.addAttribute("users", users);
        model.addAttribute("userForm", new UserForm());
        return "user/list";
    }

    @PostMapping("/new")
    public String test1(UserForm userForm) {
        UserEntity entity = new UserEntity();
        entity.setId(userForm.getId());
        entity.setName(userForm.getName());
        entity.setEmail(userForm.getEmail());
        entity.setPassword(userForm.getPassword());
        userRepository.save(entity);

        return "redirect:/user/";
    }
}
