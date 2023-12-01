package com.springrest.crudrestapi.controller;

import com.springrest.crudrestapi.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springrest.crudrestapi.services.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String home(){
        return "Welcome to courses API.";
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Optional<Course> getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Integer.parseInt(courseId));
    }

    @PostMapping(path = "/courses")
    public Course postCourse(@RequestBody Course course){
        return this.courseService.postCourse(course);
    }

    @PutMapping(path = "/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping ("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try{
            this.courseService.deleteCourse(Integer.parseInt(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
