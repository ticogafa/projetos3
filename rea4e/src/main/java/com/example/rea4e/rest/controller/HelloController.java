package com.example.rea4e.rest.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloController {

    public String hello(Model model){
        model.addAttribute("message", "oi mundo");
        return "index";
    }

    
}
