package com.anand.doctor_consult_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String homePage() {

        return "index";
    }

    @GetMapping("/admin")
    public String adminPage() {

        return "admin";
    }

    @GetMapping("/user")
    public String userPage() {

        return "user";
    }

    @GetMapping("/add-doctor")
    public String addDoctorPage() {

        return "add-doctor";
    }

    @GetMapping("/edit-doctor")
    public String editDoctorPage() {

        return "edit-doctor";
    }
}