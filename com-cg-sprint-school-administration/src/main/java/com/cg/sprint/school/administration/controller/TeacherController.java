package com.cg.sprint.school.administration.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.school.administration.exception.ComplaintNotFoundException;
import com.cg.sprint.school.administration.exception.CourseNotFoundException;
import com.cg.sprint.school.administration.exception.HomeworkNotFoundException;
import com.cg.sprint.school.administration.exception.IncorrectLoginCredentialsException;
import com.cg.sprint.school.administration.exception.NoticeNotFoundException;
import com.cg.sprint.school.administration.exception.StudentNotFoundException;
import com.cg.sprint.school.administration.exception.StudyMaterialNotFoundException;
import com.cg.sprint.school.administration.model.Admin;
import com.cg.sprint.school.administration.model.Complaint;
import com.cg.sprint.school.administration.model.Course;
import com.cg.sprint.school.administration.model.Homework;
import com.cg.sprint.school.administration.model.Notice;
//import com.cg.sprint.school.administration.model.Complaint;
//import com.cg.sprint.school.administration.model.Course;
//import com.cg.sprint.school.administration.model.Homework;
//import com.cg.sprint.school.administration.model.Notice;
import com.cg.sprint.school.administration.model.Student;
import com.cg.sprint.school.administration.model.StudyMaterial;
import com.cg.sprint.school.administration.model.Teacher;
import com.cg.sprint.school.administration.service.AdminServiceImpl;
//import com.cg.sprint.school.administration.model.StudyMaterial;
import com.cg.sprint.school.administration.service.StudentService;
import com.cg.sprint.school.administration.service.TeacherService;
import com.cg.sprint.school.administration.service.TeacherServiceImpl;

@RestController
//@RequestMapping(path = "school-admin/teacher")
public class TeacherController {
	@Autowired
	private TeacherServiceImpl teacherService;

	@Autowired
	private TeacherServiceImpl courseService;

	@Autowired
	private TeacherServiceImpl studyMaterialService;

	@Autowired
	private TeacherServiceImpl homeworkService;

	@Autowired
	private AdminServiceImpl noticeService;

	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);
	
	@PostMapping(path = "/loginTeacher")
	public String loginTeacher(@RequestBody Teacher teacher) {
		LOG.info("loginTeacher");
		return this.teacherService.loginTeacher(teacher);
	}


	// http://localhost:8082/teacher/getAllNotice
	@GetMapping("/teacher/getAllNotice")
	public List<Notice> getAllNotice() {
		LOG.info("getAllNotice");

		return noticeService.getAllNotice();

	}

	// http://localhost:8082/teacher/getAllNoticeById/{noticeId}
	@GetMapping("/teacher/getNoticeById/{noticeId}")
	public ResponseEntity<Notice> getNoticeById(@PathVariable int noticeId) {
		LOG.info("getNotice");
		Notice not = noticeService.getNoticeById(noticeId);
		return new ResponseEntity<Notice>(not, HttpStatus.OK);
	}

	// http://localhost:8082/teacher/getAllCourse
	@GetMapping("/teacher/getAllCourse")
	public List<Course> getAllCourse() {
		LOG.info("getAllCourse");

		return courseService.getAllCourse();

	}

	// http://localhost:8082/teacher/getCourseById/1
	@GetMapping("/teacher/getCourseById/{courseId}")
	public ResponseEntity<Course> getCourseById(@PathVariable int courseId) {
		LOG.info("getCourse");
		Course cou = courseService.getCourseById(courseId);
		return new ResponseEntity<Course>(cou, HttpStatus.OK);
	}

	// http://localhost:8082/teacher/updateCourse
	@PutMapping("/teacher/updateCourse")
	public Course updateCourse(@RequestBody Course course) {
		LOG.info("updateCourse");
		return courseService.updateCourse(course);
	}

	// http://localhost:8082/teacher/deleteCourse/{coursetId}
	@DeleteMapping("/taecher/deleteCourse/{courseId}")
	public int deleteCourse(@PathVariable int courseId) {
		LOG.info("deleteCourse");

		return courseService.deleteCourse(courseId);

	}

	// http://localhost:8082/teacher/addStudyMaterial
	@PostMapping("/teacher/addStudyMaterial")
	public StudyMaterial addStudyMaterial(@RequestBody StudyMaterial studyMaterial) {
		LOG.info("addStudyMaterial");
		return studyMaterialService.addStudyMaterial(studyMaterial);
	}

	// http://localhost:8082/teacher/getAllStudyMaterial
	@GetMapping("/teacher/getAllStudyMaterial")
	public List<StudyMaterial> getAllStudyMaterial() {
		LOG.info("getAllStudyMaterial");

		return studyMaterialService.getAllStudyMaterial();

	}

	// http://localhost:8082/teacher/getStudyMaterialById/1
	@GetMapping("/teacher/getStudyMaterialById/{studyId}")
	public ResponseEntity<StudyMaterial> getStudyMaterialById(@PathVariable int studyId) {
		LOG.info("getStudyMaterial");
		StudyMaterial sm = studyMaterialService.getStudyMaterialById(studyId);
		return new ResponseEntity<StudyMaterial>(sm, HttpStatus.OK);
	}

	// http://localhost:8082/teacher/updateStudyMaterial
	@PutMapping("/teacher/updateStudyMaterial")
	public StudyMaterial updateStudyMaterial(@RequestBody StudyMaterial studyMaterial) {
		LOG.info("updateStudyMaterial");
		return studyMaterialService.updateStudyMaterial(studyMaterial);
	}

	// http://localhost:8082/teacher/deleteStudyMaterial/{studyId}
	@DeleteMapping("/taecher/deleteStudyMaterial/{studyId}")
	public int deleteStudyMaterial(@PathVariable int studyId) {
		LOG.info("deleteStudyMaterial");

		return studyMaterialService.deleteStudyMaterial(studyId);

	}

	// http://localhost:8082/teacher/addHomework
	@PostMapping("/teacher/addHomework")
	public Homework addHomework(@RequestBody Homework homework) {
		LOG.info("addHomework");
		return homeworkService.addHomework(homework);
	}

	// http://localhost:8082/teacher/getHomework
	@GetMapping("/teacher/getHomework")
	public List<Homework> getAllHomework() {
		LOG.info("getAllHomework");

		return homeworkService.getAllHomework();

	}

	// http://localhost:8082/teacher/getHomeworkById/1
	@GetMapping("/teacher/getHomeworkById/{homeId}")
	public ResponseEntity<Homework> getHomeworkById(@PathVariable int homeId) {
		LOG.info("getHomework");
		Homework hw = homeworkService.getHomeworkById(homeId);
		return new ResponseEntity<Homework>(hw, HttpStatus.OK);
	}

	// http://localhost:8082/teacher/updateHomework
	@PutMapping("/teacher/updateHomework")
	public Homework updateHomework(@RequestBody Homework homework) {
		LOG.info("updateHomework");
		return homeworkService.updateHomework(homework);
	}

	// http://localhost:8082/teacher/deleteHomework/{homeId}
	@DeleteMapping("/teacher/deleteHomework/{homeId}")
	public int deleteHomework(@PathVariable int homeId) {
		LOG.info("deleteHomework");

		return homeworkService.deleteHomework(homeId);

	}


}
