package com.springrest.crudrestapi.services;

import com.springrest.crudrestapi.dao.CourseDao;
import com.springrest.crudrestapi.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    //List<Course> list;
    @Autowired
    private CourseDao courseDao;

    public CourseServiceImpl(){

        /*
        list = new ArrayList<>();
        list.add(new Course(12, "Java Core", "Learn basics of java here"));
        list.add(new Course(123, "MERN Stack", "Become a mern developer"));
         */
    }

    @Override
    public List<Course> getCourses() {
        //return list;
        return courseDao.findAll();
    }

    @Override
    public Optional<Course> getCourse(int courseId){
        return courseDao.findById(courseId);
        /*
        Course c = null;
        for(Course course: list){
            if(course.getId()==courseId){
                c= course;
                break;
            }
        }
        return c;
         */
    }

    @Override
    public Course postCourse(Course course) {
        //list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        courseDao.save(course);
        return course;
        /*
        list.forEach(c ->{
            if(c.getId() == course.getId()){
                c.setTitle(course.getTitle());
                c.setDescription(course.getDescription());
            }
        });
        return course;
         */
    }

    @Override
    public void deleteCourse(int courseId){
        Course c = courseDao.getReferenceById(courseId);
        courseDao.delete(c);
        //list = this.list.stream().filter(c-> c.getId() == courseId).collect(Collectors.toList());
    }
}
