package com.cg.sprint.school.administration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) 
public class HomeworkNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HomeworkNotFoundException(String str) {
		super(str);
	}

}