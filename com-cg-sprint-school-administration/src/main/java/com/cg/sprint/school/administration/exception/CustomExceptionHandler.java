package com.cg.sprint.school.administration.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Object> handleStudentNotFoundException() {
		LOG.error("handleStudentNotFoundException");
		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(TeacherNotFoundException.class)
	public ResponseEntity<Object> handleTeacherNotFoundException() {
		LOG.error("handleTeacherNotFoundException");
		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ComplaintNotFoundException.class)
	public ResponseEntity<Object> handleComplaintNotFoundException() {
		LOG.error("handleComplaintNotFoundException");
		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<Object> handleCourseNotFoundException() {
		LOG.error("handleCourseNotFoundException");
		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(NoticeNotFoundException.class)
	public ResponseEntity<Object> handleNoticeNotFoundException() {
		LOG.error("handleNoticeNotFoundException");
		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(HomeworkNotFoundException.class)
	public ResponseEntity<Object> handleHomeworkNotFoundException() {
		LOG.error("handleHomeworkNotFoundException");
		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(StudyMaterialNotFoundException.class)
	public ResponseEntity<Object> handleStudyMaterialNotFoundException() {
		LOG.error("handleStudyMaterialNotFoundException");
		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(IncorrectLoginCredentialsException.class)
	public ResponseEntity<Object> handleIncorrectLoginCredentialsException() {
		LOG.error("handleIncorrectLoginCredentialsException");
		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);

	}
	
}