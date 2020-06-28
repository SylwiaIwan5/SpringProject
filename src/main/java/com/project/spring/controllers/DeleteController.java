package com.project.spring.controllers;

import com.project.spring.repositories.CompanyRepository;
import com.project.spring.repositories.EmployeeRepository;
import com.project.spring.repositories.TelephoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Controller
@RequestMapping("/delete")
public class DeleteController {
    private EmployeeRepository employeeRepository;
    private TelephoneRepository telephoneRepository;
    private CompanyRepository companyRepository;

    @GetMapping()
    public String delete(@RequestParam("id") Integer id, Model model){
        employeeRepository.deleteById(id);
        model.addAttribute("employees", employeeRepository.findAll());
        return "redirect:/list";
    }
}
