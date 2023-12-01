package com.springrest.crudrestapi.services;

import com.springrest.crudrestapi.entities.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    public List<Course> getCourses();
    public Optional<Course> getCourse(int courseId);
    public Course postCourse(Course course);
    public Course updateCourse(Course course);
    public void deleteCourse(int courseId);
}
