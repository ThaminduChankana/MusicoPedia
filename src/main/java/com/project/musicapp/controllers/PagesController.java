package com.project.musicapp.controllers;

import com.project.musicapp.models.LogModel;
import com.project.musicapp.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PagesController {

    @Autowired
    LogRepository Log;
    LogModel Date = new LogModel();
    @GetMapping("/page")
    public ModelAndView page() {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "Welcome Page");
        modelAndView.addObject("message", "Welcome to The App");
        return modelAndView;
    }

}
