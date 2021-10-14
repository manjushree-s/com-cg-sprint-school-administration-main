package com.cg.sprint.school.administration.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.cg.sprint.school.administration.service.AdminServiceImpl;
//import com.cg.sprint.school.administration.model.StudyMaterial;
import com.cg.sprint.school.administration.service.StudentService;
import com.cg.sprint.school.administration.service.StudentServiceImpl;
import com.cg.sprint.school.administration.service.TeacherServiceImpl;

@RestController
@RequestMapping(path = "school-admin")
@CrossOrigin(origins = "*")
public class StudentController {
	@Autowired
	private StudentServiceImpl studentService;

	@Autowired
	private StudentServiceImpl complaintService;

	@Autowired
	private AdminServiceImpl noticeService;

	@Autowired
	private TeacherServiceImpl courseService;

	@Autowired
	private TeacherServiceImpl studyMaterialService;

	@Autowired
	private TeacherServiceImpl homeworkService;

	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);
	
	@PostMapping(path = "/student/loginStudent")
	public String loginStudent(@RequestBody Student student) {
		LOG.info("loginStudent");
		return this.studentService.loginStudent(student);
	}


	// http://localhost:8082/student/addComplaint
	@PostMapping("/student/addComplaint")
	public Complaint addComplaint(@RequestBody Complaint complaint) {
		LOG.info("addComplaint");
		return complaintService.addComplaint(complaint);
	}

	// http://localhost:8082/student/getAllComplaint
	@GetMapping("/student/getAllComplaint")
	public List<Complaint> getAllComplaint() {
		LOG.info("getAllComplaint");

		return complaintService.getAllComplaint();

	}

	// http://localhost:8082/student/getComplaintById/1
	@GetMapping("/student/getComplaintById/{complaintId}")
	public ResponseEntity<Complaint> getComplaintById(@PathVariable int complaintId) {
		LOG.info("getComplaint");
		Complaint com = complaintService.getComplaintById(complaintId);
		return new ResponseEntity<Complaint>(com, HttpStatus.OK);
	}

	// http://localhost:8082/student/updateComplaint
	@PutMapping("/student/updateComplaint")
	public Complaint updateComplaint(@RequestBody Complaint complaint) {
		LOG.info("updateComplaint");
		return complaintService.updateComplaint(complaint);
	}

	// http://localhost:8082/student/deleteComplaint/{complaintId}
	@DeleteMapping("/student/deleteComplaint/{complaintId}")
	public int deleteComplaint(@PathVariable int complaintId) {
		LOG.info("deleteComplaint");
		return complaintService.deleteComplaint(complaintId);

	}

	// http://localhost:8082/student/getAllNotice
	@GetMapping("/student/getAllNotice")
	public List<Notice> getAllNotice() {
		LOG.info("getAllNotice");

		return noticeService.getAllNotice();

	}

	// http://localhost:8082/student/getAllNoticeById/{noticeId}
	@GetMapping("/student/getNoticeById/{noticeId}")
	public ResponseEntity<Notice> getNoticeById(@PathVariable int noticeId) {
		LOG.info("getNotice");
		Notice not = noticeService.getNoticeById(noticeId);
		return new ResponseEntity<Notice>(not, HttpStatus.OK);
	}

	// http://localhost:8082/student/getAllCourse
	@GetMapping("/student/getAllCourse")
	public List<Course> getAllCourse() {
		LOG.info("getAllCourse");

		return courseService.getAllCourse();

	}

	// http://localhost:8082/student/getCourseById/1
	@GetMapping("/student/getCourseById/{courseId}")
	public ResponseEntity<Course> getCourseById(@PathVariable int courseId) {
		LOG.info("getCourse");
		Course cou = courseService.getCourseById(courseId);
		return new ResponseEntity<Course>(cou, HttpStatus.OK);
	}

	// http://localhost:8082/student/getAllStudyMaterial
	@GetMapping("/student/getAllStudyMaterial")
	public List<StudyMaterial> getAllStudyMaterial() {
		LOG.info("getAllStudyMaterial");

		return studyMaterialService.getAllStudyMaterial();

	}

	// http://localhost:8082/student/getStudyMaterialById/1
	@GetMapping("/student/getStudyMaterialById/{studyId}")
	public ResponseEntity<StudyMaterial> getStudyMaterialById(@PathVariable int studyId) {
		LOG.info("getStudyMaterial");
		StudyMaterial sm = studyMaterialService.getStudyMaterialById(studyId);
		return new ResponseEntity<StudyMaterial>(sm, HttpStatus.OK);
	}

	// http://localhost:8082/student/getHomework
	@GetMapping("/student/getHomework")
	public List<Homework> getAllHomework() {
		LOG.info("getAllHomework");

		return homeworkService.getAllHomework();

	}

	// http://localhost:8082/student/getHomeworkById/1
	@GetMapping("/student/getHomeworkById/{homeId}")
	public ResponseEntity<Homework> getHomeworkById(@PathVariable int homeId) {
		LOG.info("getHomework");
		Homework hw = homeworkService.getHomeworkById(homeId);
		return new ResponseEntity<Homework>(hw, HttpStatus.OK);
	}

	// http://localhost:8082/student/updateHomework
	@PutMapping("/student/updateHomework")
	public Homework updateHomework(@RequestBody Homework homework) {
		LOG.info("updateHomework");
		return homeworkService.updateHomework(homework);
	}


}