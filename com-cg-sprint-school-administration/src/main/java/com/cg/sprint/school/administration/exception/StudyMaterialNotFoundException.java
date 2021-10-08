package com.cg.sprint.school.administration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) 
public class StudyMaterialNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StudyMaterialNotFoundException(String str) {
		super(str);
	}

}