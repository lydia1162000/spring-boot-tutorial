package com.qacart.spring_boot_tutorial.controllers;

import com.qacart.spring_boot_tutorial.entity.Course;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CourseController {

    List<Course> courses = new ArrayList<>(
            List.of(

                    new Course(UUID.randomUUID(), "Selenium WebDriver", 30.99, 95),
                    new Course(UUID.randomUUID(), "Selenium WebDriver", 30.99, 95),
                    new Course(UUID.randomUUID(), "Selenium WebDriver", 30.99, 95)
            )
    );

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courses;
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable UUID id) {
        Optional<Course> result = courses.stream().filter(course -> course.getId().equals(id)).findFirst();
        if (result.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return result.get();
    }

    @GetMapping("/courses/search")
    public List<Course> getCoursesByTitle(@RequestParam String title) {
        return courses.stream().filter(course -> course.getTitle().contains(title)).toList();
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourseById(@PathVariable UUID id) {
        Optional<Course> result = courses.stream().filter(course -> course.getId().equals(id)).findFirst();
        if (result.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        courses.remove(result.get());
        return "Deleted";
    }

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody Course course) {
        course.setId(UUID.randomUUID());
        courses.add(course);
        return course;

    }

    @PutMapping("courses/{id}")
    public Course editeCourseById(@PathVariable UUID id, @RequestBody Course course) {
        Optional<Course> result = courses.stream().filter(c -> c.getId().equals(id)).findFirst();
        if (result.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Course oldCourse = result.get();
        oldCourse.setTitle(course.getTitle());
        oldCourse.setPrice(course.getPrice());
        oldCourse.setNumOfVideos(course.getNumOfVideos());
        return oldCourse;
    }
}