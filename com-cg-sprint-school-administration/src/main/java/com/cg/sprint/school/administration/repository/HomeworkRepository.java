package com.cg.sprint.school.administration.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint.school.administration.model.Homework;

@Repository
public interface HomeworkRepository extends CrudRepository<Homework, Integer> {
    
   // List<Homework> findByName(String name);
    
}