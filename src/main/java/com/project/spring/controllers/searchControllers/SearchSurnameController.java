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
@RequestMapping("/searchBySurname")
public class SearchSurnameController {
    private EmployeeRepository employeeRepository;

    @GetMapping()
    public String searchBySurname(@RequestParam("surname") String surname, Model model){
        model.addAttribute("employees", employeeRepository.searchBySurname(surname));
        return "List";
    }
}
