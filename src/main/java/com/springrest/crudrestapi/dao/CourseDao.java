package com.springrest.crudrestapi.dao;

import com.springrest.crudrestapi.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Integer> {

}
