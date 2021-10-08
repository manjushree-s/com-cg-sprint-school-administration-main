package com.cg.sprint.school.administration.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint.school.administration.model.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	boolean existsById(int adminId);

	Admin getById(int adminId);
	

	
}