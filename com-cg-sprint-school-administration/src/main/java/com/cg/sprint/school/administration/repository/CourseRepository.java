package com.cg.sprint.school.administration.repository;
 
import java.util.List;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
import com.cg.sprint.school.administration.model.Course;
 
@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

//    List<Course> findById(String courseId);
//
//    List<Course> findByName(String name);

}