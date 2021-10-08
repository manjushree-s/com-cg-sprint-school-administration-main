package com.cg.sprint.school.administration.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint.school.administration.model.StudyMaterial;

@Repository
public interface StudyMaterialRepository extends CrudRepository<StudyMaterial, Integer> {
    
//    List<StudyMaterial> findByCourse(String course);
//    
//    List<StudyMaterial> findByName(String name);
    
}