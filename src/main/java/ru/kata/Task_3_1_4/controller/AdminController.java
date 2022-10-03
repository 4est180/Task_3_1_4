package ru.kata.Task_3_1_4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.Task_3_1_4.service.RoleService;

@Controller
public class AdminController {

    private final RoleService roleService;

    @Autowired
    public AdminController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/adminpage")
    public String userList(Model model) {
        model.addAttribute("amountOfRoles", roleService.findAll());
        return "adminpage";
    }
}