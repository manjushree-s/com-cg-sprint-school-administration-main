   
package com.cg.sprint.school.administration.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint.school.administration.model.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

	Teacher getById(int teacherId);
    
//    List<Teacher> findById(String teacherId);
//    
//    List<Teacher> findByName(String teacherName);
    
}