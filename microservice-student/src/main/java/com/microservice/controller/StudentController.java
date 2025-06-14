package com.microservice.controller;

import com.microservice.entities.Student;
import com.microservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void saveStudent(@RequestBody Student student){
        studentService.save(student);
    }
    @GetMapping("/all")
    public ResponseEntity<?> findAllStudent(){
        return ResponseEntity.ok(studentService.findAll());
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }
    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(studentService.findByIdCourse(idCourse));
    }
}