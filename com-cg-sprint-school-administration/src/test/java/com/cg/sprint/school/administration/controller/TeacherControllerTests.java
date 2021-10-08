package com.cg.sprint.school.administration.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.sprint.school.administration.model.Teacher;


@SpringBootTest
public class TeacherControllerTests{
	
	private static final Logger LOG = LoggerFactory.getLogger(TeacherControllerTests.class);
	
	@Autowired
	private TeacherControllerTests teacherController;
	
	@Autowired
	private AdminController adminController;
	
	@Test
	public void testPatientById() throws Exception{
		LOG.info("testGetTeachertById");
		
		HttpStatus expected = HttpStatus.OK;
		
		ResponseEntity<Teacher> actual = adminController.getTeacherById(2);
		assertEquals(expected, actual.getStatusCode());
	}
	

}