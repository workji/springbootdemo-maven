package com.ki.controller;

import com.ki.entity.JoinResultView;
import com.ki.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person")
    public String test1(Model model) {
        List<Object[]> entities = personRepository.findAllByParameter("j");

        List<JoinResultView> joins = entities.stream().map(data -> {
            JoinResultView view = new JoinResultView();
            view.setName((String)data[0]);
            view.setClassname((String)data[1]);
            return view;
        }).collect(Collectors.toList());

        model.addAttribute("persons", joins);
        return "person";
    }

    @GetMapping(path = {"/allperson", "/allperson/{page}"})
    public String test2(Model model, @PathVariable(name = "page", required = false) Integer page) {
        if (page == null) page = 0;
        Pageable pageable1 = PageRequest.of(page, 2, Sort.by(Sort.Direction.ASC, "name"));
        Page<Object[]> entities = personRepository.findAllByNo(pageable1);

        List<JoinResultView> joins = entities.stream().map(data -> {
            JoinResultView view = new JoinResultView();
            view.setName((String)data[0]);
            view.setClassname((String)data[1]);
            return view;
        }).collect(Collectors.toList());

        model.addAttribute("persons", joins);
        model.addAttribute("page", entities);

        return "person";
    }
}
