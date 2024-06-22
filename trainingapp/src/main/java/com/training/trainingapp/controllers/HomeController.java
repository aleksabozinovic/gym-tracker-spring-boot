package com.training.trainingapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/user")
    public String showIndexPage() {
        return "user";
    }
}
