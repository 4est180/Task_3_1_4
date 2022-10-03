package ru.kata.Task_3_1_4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    @Autowired
    public UserController() {}

    @GetMapping("/userpage")
    public String getUser() {
        return "userpage";
    }
}
