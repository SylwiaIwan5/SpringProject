package com.project.spring.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    @OneToOne()
    private Telephone telephone;
    @ManyToOne()
    private Company company;

    public Employee(String name, String surname, Telephone telephone, Company company) {
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.company = company;
    }

    public Employee(Integer id, String name, String surname, Telephone telephone, Company company) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

}
