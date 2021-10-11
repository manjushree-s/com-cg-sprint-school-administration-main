package com.cg.sprint.school.administration.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.school.administration.exception.IncorrectLoginCredentialsException;
import com.cg.sprint.school.administration.exception.AdminNotFoundException;
import com.cg.sprint.school.administration.exception.ComplaintNotFoundException;
import com.cg.sprint.school.administration.exception.CourseNotFoundException;
import com.cg.sprint.school.administration.exception.NoticeNotFoundException;
import com.cg.sprint.school.administration.exception.StudentNotFoundException;
import com.cg.sprint.school.administration.exception.StudyMaterialNotFoundException;
import com.cg.sprint.school.administration.exception.TeacherNotFoundException;
import com.cg.sprint.school.administration.model.Admin;
import com.cg.sprint.school.administration.model.Complaint;
import com.cg.sprint.school.administration.model.Course;
import com.cg.sprint.school.administration.model.Homework;
import com.cg.sprint.school.administration.model.Notice;
import com.cg.sprint.school.administration.model.Student;
import com.cg.sprint.school.administration.model.StudyMaterial;
import com.cg.sprint.school.administration.model.Teacher;
import com.cg.sprint.school.administration.service.AdminService;
import com.cg.sprint.school.administration.service.AdminServiceImpl;
import com.cg.sprint.school.administration.service.StudentService;
import com.cg.sprint.school.administration.service.StudentServiceImpl;
import com.cg.sprint.school.administration.service.TeacherService;
import com.cg.sprint.school.administration.service.TeacherServiceImpl;

@RestController
@RequestMapping(path = "school-admin/admin")
public class AdminController {

	@Autowired
	private AdminServiceImpl adminService;

	@Autowired
	private StudentServiceImpl studentService;

	@Autowired
	private StudentServiceImpl complaintService;

	@Autowired
	private TeacherServiceImpl teacherService;

	@Autowired
	private TeacherServiceImpl homeworkService;

	@Autowired
	private TeacherServiceImpl studyMaterialService;

	@Autowired
	private AdminServiceImpl courseService;

	@Autowired
	private AdminServiceImpl noticeService;

	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

	@PostMapping(path = "/loginAdmin")
	public String loginAdmin(@RequestBody Admin admin) {
		LOG.info("loginAdmin");
		return this.adminService.loginAdmin(admin);
	}

	// http://localhost:8082/addAdmin
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {
		LOG.info("addAdmin");
		return adminService.addAdmin(admin);
	}

	// http://localhost:8082/getAllAdmin
	@GetMapping("/getAllAdmin")
	public List<Admin> getAllAdmin() {
		LOG.info("getAllDep");

		return adminService.getAllAdmin();

	}

	// http://localhost:8082/getAdmin/1
	@GetMapping("/getAdmin/{adminId}")
	public ResponseEntity<Admin> getAdminById(@PathVariable int adminId) {
		LOG.info("getAdmin");
		Admin adm = adminService.getAdminById(adminId);
		return new ResponseEntity<Admin>(adm, HttpStatus.OK);

	}

	// http://localhost:8082/addStudent
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		LOG.info("addStudent");
		return studentService.addStudent(student);
	}

	// http://localhost:8082/getAllStudent
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent() {
		LOG.info("getAllStudent");

		return studentService.getAllStudent();

	}

	@GetMapping("/getStudentById/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable int studentId) {
		LOG.info("getEmp");
		Student stu = studentService.getStudentById(studentId);
		return new ResponseEntity<Student>(stu, HttpStatus.OK);
	}

	// http://localhost:8082/updateStudent
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		LOG.info("updateStudent");
		return studentService.updateStudent(student);
	}

	// http://localhost:8082/deleteStudent/{studentId}
	@DeleteMapping("/deleteStudent/{studentId}")
	public int deleteStudent(@PathVariable int studentId) {
		LOG.info("deleteStudent");

		return studentService.deleteStudent(studentId);

	}

	// http://localhost:8082/addTeacher
	@PostMapping("/addTeacher")
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		LOG.info("addTeacher");
		return teacherService.addTeacher(teacher);
	}

	// http://localhost:8082/getAllTeacher
	@GetMapping("/getAllTeacher")
	public List<Teacher> getAllTeacher() {
		LOG.info("getAllTeacher");

		return teacherService.getAllTeacher();

	}

	@GetMapping("/getTeacherById/{teacherId}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable int teacherId) {
		LOG.info("getTeacher");
		Teacher tea = teacherService.getTeacherById(teacherId);
		return new ResponseEntity<Teacher>(tea, HttpStatus.OK);
	}

	// http://localhost:8082/updateTeacher
	@PutMapping("/updateTeacher")
	public Teacher updateTeacher(@RequestBody Teacher teacher) {
		LOG.info("updateTeacher");
		return teacherService.updateTeacher(teacher);
	}

	// http://localhost:8082/deleteTeacher/{teacherId}
	@DeleteMapping("/deleteTeacher/{teacherId}")
	public int deleteTeacher(@PathVariable int teacherId) {
		LOG.info("deleteTeacher");

		return teacherService.deleteTeacher(teacherId);

	}

	// http://localhost:8082/getAllComplaint
	@GetMapping("/getAllComplaint")
	public List<Complaint> getAllComplaint() {
		LOG.info("getAllComplaint");

		return complaintService.getAllComplaint();

	}

	// http://localhost:8082/getComplaintById/1
	@GetMapping("/getComplaintById/{complaintId}")
	public ResponseEntity<Complaint> getComplaintById(@PathVariable int complaintId) {
		LOG.info("getComplaint");
		Complaint com = complaintService.getComplaintById(complaintId);
		return new ResponseEntity<Complaint>(com, HttpStatus.OK);

	}

	// http://localhost:8082/deleteComplaint/{complaintId}
	@DeleteMapping("/deleteComplaint/{complaintId}")
	public int deleteComplaint(@PathVariable int complaintId) {
		LOG.info("deleteComplaint");

		return complaintService.deleteComplaint(complaintId);

	}

	// http://localhost:8082/addNotice
	@PostMapping("/addNotice")
	public Notice addNotice(@RequestBody Notice notice) {
		LOG.info("addNotice");
		return noticeService.addNotice(notice);
	}

	// http://localhost:8082/getAllNotice
	@GetMapping("/getAllNotice")
	public List<Notice> getAllNotice() {
		LOG.info("getAllNotice");

		return noticeService.getAllNotice();

	}

	@GetMapping("/getNoticeById/{noticeId}")
	public ResponseEntity<Notice> getNoticeById(@PathVariable int noticeId) {
		LOG.info("getNotice");
		Notice not = noticeService.getNoticeById(noticeId);
		return new ResponseEntity<Notice>(not, HttpStatus.OK);
	}

	// http://localhost:8082/updateNotice
	@PutMapping("/updateNotice")
	public Notice updateNotice(@RequestBody Notice notice) {
		LOG.info("updateNotice");
		return noticeService.updateNotice(notice);
	}

	// http://localhost:8082/deleteNotice/{noticeId}
	@DeleteMapping("/deleteNotice/{noticeId}")
	public boolean deleteNotice(@PathVariable int noticeId) {
		LOG.info("deleteNotice");

		return noticeService.removeNotice(noticeId);

	}

	// http://localhost:8082/admin/addCourse
	@PostMapping("/addCourse")
	public Course addCourse(@RequestBody Course course) {
		LOG.info("addCourse");
		return courseService.addCourse(course);
	}

	// http://localhost:8082/getAllCourse
	@GetMapping("/getAllCourse")
	public List<Course> getAllCourse() {
		LOG.info("getAllCourse");
		return courseService.getAllCourse();

	}

	// http://localhost:8082/getAllStudyMaterial
	@GetMapping("/getAllStudyMaterial")
	public List<StudyMaterial> getAllStudyMaterial() {
		LOG.info("getAllStudyMaterial");

		return studyMaterialService.getAllStudyMaterial();

	}

	// http://localhost:8082/getStudyMaterialById/1
	@GetMapping("/getStudyMaterialById/{studyId}")
	public ResponseEntity<StudyMaterial> getStudyMaterialById(@PathVariable int studyId) {
		LOG.info("getStudyMaterial");
		StudyMaterial sm = studyMaterialService.getStudyMaterialById(studyId);
		return new ResponseEntity<StudyMaterial>(sm, HttpStatus.OK);
	}

	// http://localhost:8082/deleteStudyMaterial/{studyId}
	@DeleteMapping("/deleteStudyMaterial/{studyId}")
	public int deleteStudyMaterial(@PathVariable int studyId) {
		LOG.info("deleteStudyMaterial");
		return studyMaterialService.deleteCourse(studyId);

	}

}
