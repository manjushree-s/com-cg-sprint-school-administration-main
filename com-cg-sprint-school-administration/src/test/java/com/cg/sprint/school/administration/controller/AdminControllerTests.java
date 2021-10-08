package com.cg.sprint.school.administration.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminControllerTests {

	private static Logger LOG = LoggerFactory.getLogger(AdminControllerTests.class);

	@Test
	public void testMethod() {
		LOG.info("testMethod");
		assertEquals(10, 10);
	}

}