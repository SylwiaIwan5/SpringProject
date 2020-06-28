package com.project.spring.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 11)
    private Integer telephoneNumber;

    public Telephone(Integer telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Telephone(Integer id, Integer telephoneNumber) {
        this.id = id;
        this.telephoneNumber = telephoneNumber;
    }

    public Integer getId() {
        return id;
    }
}
