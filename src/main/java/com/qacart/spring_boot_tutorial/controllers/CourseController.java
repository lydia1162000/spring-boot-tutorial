package com.qacart.spring_boot_tutorial.controllers;

import com.qacart.spring_boot_tutorial.entity.Course;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    List<Course> courses = new ArrayList<>(
            List.of(

                    new Course(1, "Selenium WebDriver", 30.99, 95),
                    new Course(2, "Selenium WebDriver", 30.99, 95),
                    new Course(3, "Selenium WebDriver", 30.99, 95)
            )
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
    @DeleteMapping("/courses/{id}")
    public String deleteCourseById(@PathVariable int id){
        Optional<Course> result =courses.stream().filter(course->course.getId() == id).findFirst();
        if(result.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        courses.remove(result.get());
        return "Deleted";
    }
}