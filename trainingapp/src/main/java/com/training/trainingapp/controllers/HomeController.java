package com.training.trainingapp.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/{id}/user")
    public String showIndexPage(@PathVariable("id") String id, Model model, Principal principal) {
        return "user";
    }
}
