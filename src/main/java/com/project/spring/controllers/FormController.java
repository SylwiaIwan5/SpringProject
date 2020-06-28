package com.project.spring.controllers;

import com.project.spring.entities.Company;
import com.project.spring.entities.Employee;
import com.project.spring.entities.Telephone;
import com.project.spring.repositories.CompanyRepository;
import com.project.spring.repositories.EmployeeRepository;
import com.project.spring.repositories.TelephoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/form")
public class FormController {
    private EmployeeRepository employeeRepository;
    private TelephoneRepository telephoneRepository;
    private CompanyRepository companyRepository;

    @GetMapping()
    public String openForm() {
        return "Form";
    }

    @PostMapping()
    public String addEmployee(Model model,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("telephoneNumber") Integer telephoneNumber,
            @RequestParam("businessName") String businessName) throws Exception {
        Telephone telephone = new Telephone(telephoneNumber);
        telephone = telephoneRepository.save(telephone);
        Company company = new Company(businessName);
        company = companyRepository.save(company);
        Employee employee = new Employee(name, surname, telephone, company);
        employeeRepository.save(employee);
        model.addAttribute("employees", employee);
        return "redirect:/list";
    }
}
