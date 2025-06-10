package com.microservice.service.implement;

import com.microservice.entities.Student;
import com.microservice.persistence.StudentRepository;
import com.microservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }
    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }
    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
    @Override
    public List<Student> findByIdCourse(Long idCourse) {
        return studentRepository.findByIdCourse(idCourse);
    }
}
