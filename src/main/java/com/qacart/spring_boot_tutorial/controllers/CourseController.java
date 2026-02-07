package com.qacart.spring_boot_tutorial.controllers;

import com.qacart.spring_boot_tutorial.entity.Course;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    List<Course> courses = List.of(

            new Course(1, "Selenium WebDriver", 30.99, 95),
            new Course(2, "Selenium WebDriver", 30.99, 95),
            new Course(3, "Selenium WebDriver", 30.99, 95)
    );

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courses;
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable int id) {
        Optional<Course> result = courses.stream().filter(course -> course.getId() == id).findFirst();
        if (result.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return result.get();
    }
    @GetMapping("/courses/search")
    public  List<Course> getCoursesByTitle(@RequestParam String title){
        return courses.stream().filter(course -> course.getTitle().contains(title)).toList();
    }
}