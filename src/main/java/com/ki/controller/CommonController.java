package com.ki.controller;

import com.ki.entity.Alert;
import com.ki.repository.AlertRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class CommonController {

    @Autowired
    AlertRepo alertRepo;

    @ModelAttribute(name = "alerts")
    public List<Alert> getAlerts() {
        return alertRepo.findAll();
    }
}
