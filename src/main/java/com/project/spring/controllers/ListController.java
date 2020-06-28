package com.project.spring.controllers;

import com.project.spring.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/list")
public class ListController {
    private EmployeeRepository employeeRepository;

    @GetMapping()
    public String getAll(Model model){
            model.addAttribute("employees", employeeRepository.findAll());
        return "List";
    }



}
