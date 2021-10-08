   
package com.cg.sprint.school.administration.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint.school.administration.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	Student getById(int studentId);
    
//    List<Student> findByName(String studentName);
//    
//    List<Student> findById(String studentId);
    
}