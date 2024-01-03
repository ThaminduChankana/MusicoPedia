package com.project.musicapp.controllers;

import com.project.musicapp.models.LogModel;
import com.project.musicapp.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    LogRepository Log;

    @GetMapping(path="/all")
    public Iterable<LogModel> showAllLog(){
        return Log.findAll();
    }
}
