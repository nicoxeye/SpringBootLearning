package com.example.lab92.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Course {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Instructor instructor;

    @OneToMany(mappedBy = "course")
    private List<Participant> participants;

    public Course(String title, String description, Instructor instructor) {
        this.title = title;
        this.description = description;
        this.instructor = instructor;
    }

    public Course(){}

}
