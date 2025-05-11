package com.example.lab92.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Instructor {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;

    public Instructor() {}

    public Instructor(String name, String surname, List<Course> courses) {
        this.name = name;
        this.surname = surname;
        this.courses = courses;
    }
}
