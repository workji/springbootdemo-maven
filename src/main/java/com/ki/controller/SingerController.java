package com.ki.controller;

import com.ki.entity.SingerEntity;
import com.ki.form.SingerForm;
import com.ki.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SingerController {

    @Autowired
    private SingerRepository singerRepository;

    @GetMapping(path = {"/singer", "/singer/{id}"})
    public String test2(@PathVariable(required = false) Long id, Model model) {
        SingerEntity entity = null;
        SingerForm form = new SingerForm();
        if (id != null) {
            entity = singerRepository.findById(id).get();
            form.setFirstName(entity.getFirstName());
            form.setLastName(entity.getLastName());
        }

        model.addAttribute("singerForm", form);
        return "singer";
    }

    @PostMapping("/singer")
    public String test1(@Validated SingerForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "入力ミス");
            return "singer";
        }

        SingerEntity entity = new SingerEntity();
        entity.setFirstName(form.getFirstName());
        entity.setLastName(form.getLastName());
        singerRepository.save(entity);

        return "redirect:/";
    }
}
