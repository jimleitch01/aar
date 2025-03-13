package com.example.aar.controller;

import com.example.aar.model.Abduction;
import com.example.aar.service.AbductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private AbductionService abductionService;

    @GetMapping("/")
    public String home(Model model) {
        List<Abduction> recentAbductions = abductionService.getAllAbductions();
        model.addAttribute("recentAbductions", recentAbductions);
        return "home";
    }
}
