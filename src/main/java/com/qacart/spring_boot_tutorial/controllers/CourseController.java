package com.qacart.spring_boot_tutorial.controllers;

import com.qacart.spring_boot_tutorial.entity.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    List <Course> courses = List.of(
            new Course(1, "Selenium WebDriver", 30.99, 95),
            new Course(2, "Selenium WebDriver", 30.99, 95),
            new Course(3, "Selenium WebDriver", 30.99, 95)
    );
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courses;
    }
}