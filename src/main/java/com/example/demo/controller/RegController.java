package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.domain.Login;
import com.example.demo.service.RegService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegController {
    @Autowired
    private RegService service;

    @PostMapping("/reg")
    public String login(@ModelAttribute("user") Login user) {
        service.saveuser(user.getUsername(), user.getPassword());
       
            return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String api()
    {
        return "index";
    }
}
