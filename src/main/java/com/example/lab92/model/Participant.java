package com.example.lab92.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class Participant {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private Date registration_date;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Participant(String name, String surname, Course course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    public Participant(){}
}
