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
@RequestMapping("/update")
public class UpdateController {
    private EmployeeRepository employeeRepository;
    private TelephoneRepository telephoneRepository;
    private CompanyRepository companyRepository;

    @GetMapping()
    public String getUpdateForm(@RequestParam("id") Integer id, Model model) throws Exception {
        model.addAttribute("employees", employeeRepository.findById(id));
        return "Update";
    }

    @PostMapping()
    public String update(
            @RequestParam("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("telephone.id") Integer telephoneId,
            @RequestParam("telephone.telephoneNumber") Integer telephoneNumber,
            @RequestParam("company.id") Integer companyId,
            @RequestParam("company.businessName") String businessName, Model model)
            throws Exception {
        Telephone telephone = new Telephone(telephoneId, telephoneNumber);
        telephone = telephoneRepository.save(telephone);
        Company company = new Company(companyId, businessName);
        company = companyRepository.save(company);
        Employee employee = new Employee(id, name, surname, telephone, company);
        employeeRepository.save(employee);
        model.addAttribute("employees", employee);
        return "redirect:/list";
    }
}
