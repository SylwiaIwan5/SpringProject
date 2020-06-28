package com.project.spring.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String businessName;
    @OneToMany(mappedBy = "company")
    private List<Employee> employees;

    public Company(String businessName) {
        this.businessName = businessName;
        this.employees = new ArrayList<>();
    }

    public Company(Integer id, String businessName) {
        this.id = id;
        this.businessName = businessName;
    }

    public Integer getId() {
        return id;
    }
}
