package com.microservice.service;

import com.microservice.entities.Course;
import com.microservice.http.response.StudentByCourseResponse;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course findById(Long id);
    void save(Course course);
    StudentByCourseResponse findStudentsByIdCourse(Long idCourse);
}