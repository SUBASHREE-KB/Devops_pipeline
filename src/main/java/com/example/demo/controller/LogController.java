package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Login;
import com.example.demo.service.LogService;
import com.example.demo.service.RegService;

@Controller
public class LogController {
 
    @Autowired
    private LogService service;
   
    @GetMapping("/")
    public String api()
    {
        return "index";
    }
 
    @PostMapping("/log")
    public String login(@ModelAttribute("user") Login user) {
 
        Login oauthUser = service.log(user.getUsername(), user.getPassword());
 
        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/disp";
        } else {
            return "redirect:/";
        }
    }
    @GetMapping("/register")
    public String apic()
    {
        return "register";
    }

   
    @GetMapping("/disp")
    public String display() {
        return "display";
    }
}
