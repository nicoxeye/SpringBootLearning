package com.example.lab92.service;

import com.example.lab92.model.Course;
import com.example.lab92.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Page<Course> getAll(Pageable pageable){
        return courseRepository.findAll(pageable);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }
}
