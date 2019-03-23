package com.akomlev.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Anton Komlev");
        model.addAttribute("email", "test@test.com");
        return "index";
    }
}
