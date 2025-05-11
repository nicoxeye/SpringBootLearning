package com.example.lab92;

import com.example.lab92.model.Course;
import com.example.lab92.model.Instructor;
import com.example.lab92.model.Participant;
import com.example.lab92.repository.CourseRepository;
import com.example.lab92.repository.InstructorRepository;
import com.example.lab92.repository.ParticipantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class Lab92Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab92Application.class, args);
    }


    @Bean
    CommandLineRunner initData(InstructorRepository instructorRepository, CourseRepository courseRepository, ParticipantRepository participantRepository) {
        return args -> {
            Instructor jan = instructorRepository.save(new Instructor("Jan", "Kowalski", new ArrayList<>()));
            Instructor anna = instructorRepository.save(new Instructor("Anna", "Nowak", new ArrayList<>()));

            Course kurs1 = new Course("Java Basics", "Podstawy javy", jan);
            Course kurs2 = new Course("Spring Boot", "Aplikacje webowe w Spring", anna);

            kurs1 = courseRepository.save(kurs1);
            kurs2 = courseRepository.save(kurs2);

            participantRepository.save(new Participant("Tomasz", "Lis", kurs1));
            participantRepository.save(new Participant("Magda", "Zielinska", kurs2));
        };
    }
}
