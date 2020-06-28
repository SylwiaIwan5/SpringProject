package com.project.spring.controllers.searchControllers;

import com.project.spring.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Controller
@RequestMapping("/searchByName")
public class SearchNameController {
    private EmployeeRepository employeeRepository;

    @GetMapping()
    public String searchByName(@RequestParam("name") String name, Model model){
        model.addAttribute("employees", employeeRepository.searchByName(name));
        return "List";
    }
}
