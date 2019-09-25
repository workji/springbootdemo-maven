package com.ki.controller;

import com.ki.entity.MultiEntity;
import com.ki.entity.MultiKeysClass;
import com.ki.form.MultiForm;
import com.ki.repository.MultiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MultiController {

    @Autowired
    private MultiRepository multiRepository;

    @GetMapping(path = {"/multi", "/multi/{ids}"})
    public String test2(@PathVariable(required = false) String ids, Model model) {
        MultiKeysClass entityKey = new MultiKeysClass();
        MultiForm form = new MultiForm();
        if (ids != null) {
            String[] id = ids.split("");
            entityKey.setKey1(id[0]);
            entityKey.setKey2(id[1]);
            entityKey.setKey3(id[2]);
            MultiEntity entity = multiRepository.findById(entityKey).get();
            form.setKey1(entity.getKey1());
            form.setKey2(entity.getKey2());
            form.setKey3(entity.getKey3());
            form.setValue(entity.getValue());
        }
        model.addAttribute("multiForm", form);

        return "multi";
    }

    @PostMapping("/multi")
    public String test1(@Validated MultiForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "入力ミス");
            return "multi";
        }

        MultiEntity entity = new MultiEntity();
        entity.setKey1(form.getKey1());
        entity.setKey2(form.getKey2());
        entity.setKey3(form.getKey3());
        entity.setValue(form.getValue());
        multiRepository.save(entity);

        return "redirect:/";
    }
}
