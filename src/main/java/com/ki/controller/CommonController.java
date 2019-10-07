package com.ki.controller;

import com.ki.entity.Alert;
import com.ki.repository.AlertRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@ControllerAdvice
public class CommonController {

    @Autowired
    AlertRepo alertRepo;

    @ModelAttribute(name = "alerts")
    public List<Alert> getAlerts() {
        return alertRepo.findAll();
    }

    @ExceptionHandler(IOException.class)
    public String exceptionCommonDo1(IOException ioe, HandlerMethod method, HttpServletResponse response) {
        System.out.println(method.getMethod().getName() + " -> IOException.");
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return "forward:/";
    }
}
