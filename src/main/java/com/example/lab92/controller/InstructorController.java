package com.example.lab92.controller;

import com.example.lab92.model.Instructor;
import com.example.lab92.repository.InstructorRepository;
import com.example.lab92.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public List<Instructor> getAll(){
        return instructorService.findAll();
    }

    @PostMapping
    public Instructor add(@RequestBody Instructor instructor) {
        return instructorService.save(instructor);
    }
}
