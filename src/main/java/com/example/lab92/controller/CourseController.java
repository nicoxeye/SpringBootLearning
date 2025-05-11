package com.example.lab92.controller;

import com.example.lab92.model.Course;
import com.example.lab92.repository.CourseRepository;
import com.example.lab92.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public Page<Course> getCourses(@RequestParam int page, @RequestParam int size) {
        return courseService.getAll(PageRequest.of(page, size));
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseService.save(course);
    }
}
