package com.microservice.service.implement;

import com.microservice.client.StudentClient;
import com.microservice.dto.StudentDTO;
import com.microservice.entities.Course;
import com.microservice.http.response.StudentByCourseResponse;
import com.microservice.persistence.CourseRepository;
import com.microservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentClient studentClient;
    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }
    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }
    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {
        //Check the course
        Course course=courseRepository.findById(idCourse).orElse(new Course());
        //Get the students
        List<StudentDTO> studentDTOList= studentClient.findAllStudentByCourse(idCourse);
        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}