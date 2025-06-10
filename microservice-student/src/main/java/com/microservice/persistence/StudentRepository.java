package com.microservice.persistence;

import com.microservice.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    /*@Query(value = "SELECT s FROM students s WHERE s.idCourse = ?1")
    List<Student> findAllStudent(Long idCourse);
    List<Student> findAllByCourseId(Long idCourse);
    Both are the same, except that in one you use
    the name of what you are going to do and in the
    other you use a Query so that SQL recognizes it
    as a method
    */
    List<Student> findByIdCourse(Long idCourse);
}