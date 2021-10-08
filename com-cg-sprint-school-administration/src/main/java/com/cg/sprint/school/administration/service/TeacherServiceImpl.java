package com.cg.sprint.school.administration.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.school.administration.exception.*;
import com.cg.sprint.school.administration.model.*;
import com.cg.sprint.school.administration.repository.*;

@Service
public class TeacherServiceImpl {
	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	HomeworkRepository homeworkRepository;

	@Autowired
	StudyMaterialRepository studyMaterialRepository;

	private static final Logger LOG = LoggerFactory.getLogger(TeacherService.class);

	//Login Teacher
	public Teacher loginTeacher(int teacherId, String teacherPassword) throws IncorrectLoginCredentialsException {
		Teacher teacher = null;

		if (teacherRepository.existsById(teacherId)
				&& teacherRepository.getById(teacherId).getTeacherPassword().equals(teacherPassword)) {
			teacher = teacherRepository.getById(teacherId);
			LOG.info("Admin login is  successfull");
			return teacher;
		}
		LOG.error("Teacher details are incorrect");
		throw new IncorrectLoginCredentialsException("Invalid Credentials");
	}
	
	// Add Teacher
	public Teacher addTeacher(Teacher teacher) {
		LOG.info("addTeacher");
		try {
			return teacherRepository.save(teacher);
		} catch (IllegalArgumentException iae) {
			LOG.error(iae.getMessage());
			return null;
		}
	}

	// display all Teachers
	public List<Teacher> getAllTeacher() {
		LOG.info("getAllTeacher");
		return (List<Teacher>) teacherRepository.findAll();
	}

	// Display Teacher By Id
	public Teacher getTeacherById(int teacherId) throws TeacherNotFoundException {
		LOG.info("getTeacherById " + teacherId);
		Optional<Teacher> optTeacher = teacherRepository.findById(teacherId);
		if (optTeacher.isEmpty()) {
			LOG.error("Teacher not found.");
			throw new TeacherNotFoundException("The teacher with ID " + teacherId + " not found");
		} else
			return optTeacher.get();
	}

	// Update Teacher Details
	public Teacher updateTeacher(Teacher teacher) {
		LOG.info("updateTeacher");
		return teacherRepository.save(teacher);
	}

	// Delete Teacher
	public int deleteTeacher(int teacherId) {
		LOG.info("deleteTeacher");
		teacherRepository.deleteById(teacherId);
		return teacherId;
	}

	// Display course
	public List<Course> getAllCourse() {
		LOG.info("getAllCourse");
		return (List<Course>) courseRepository.findAll();
	}

	// Display Course By Id
	public Course getCourseById(int courseId) throws CourseNotFoundException {
		LOG.info("getcourseById " + courseId);
		Optional<Course> optCourse = courseRepository.findById(courseId);
		if (optCourse.isEmpty()) {
			LOG.error("Course not found.");
			throw new CourseNotFoundException("The course with ID " + courseId + " not found");
		} else
			return optCourse.get();
	}

	// Update Course Details
	public Course updateCourse(Course course) {
		LOG.info("updateCourse");
		return courseRepository.save(course);
	}

	// Delete Course
	public int deleteCourse(int courseId) {
		LOG.info("deleteCourse");
		courseRepository.deleteById(courseId);
		return courseId;
	}

	// Add StudyMaterial
	public StudyMaterial addStudyMaterial(StudyMaterial studyMaterial) {
		LOG.info("addStudyMaterial");
		try {
			return studyMaterialRepository.save(studyMaterial);
		} catch (IllegalArgumentException iae) {
			LOG.error(iae.getMessage());
			return null;
		}
	}

	// Display StudyMaterials
	public List<StudyMaterial> getAllStudyMaterial() {
		LOG.info("getAllStudyMaterial");
		return (List<StudyMaterial>) studyMaterialRepository.findAll();
	}

	// Display StudyMaterial By Id
	public StudyMaterial getStudyMaterialById(int studyId) throws StudyMaterialNotFoundException {
		LOG.info("getStudyMaterialById " + studyId);
		Optional<StudyMaterial> optStudyMaterial = studyMaterialRepository.findById(studyId);
		if (optStudyMaterial.isEmpty()) {
			LOG.error("StudyMaterial not found.");
			throw new StudyMaterialNotFoundException("The Study Material with ID " + studyId + " not found");
		} else
			return optStudyMaterial.get();
	}

	// Update StudyMaterial Details
	public StudyMaterial updateStudyMaterial(StudyMaterial studyMaterial) {
		LOG.info("updateStudyMaterial");
		return studyMaterialRepository.save(studyMaterial);
	}

	// Delete StudyMaterial
	public int deleteStudyMaterial(int studyId) {
		LOG.info("deleteStudyMaterial");
		studyMaterialRepository.deleteById(studyId);
		return studyId;
	}

	// Add Homework
	public Homework addHomework(Homework homework) {
		LOG.info("addHomework");
		try {
			return homeworkRepository.save(homework);
		} catch (IllegalArgumentException iae) {
			LOG.error(iae.getMessage());
			return null;
		}
	}

	// Display HomeWork
	public List<Homework> getAllHomework() {
		LOG.info("getAllHomework");
		return (List<Homework>) homeworkRepository.findAll();
	}

	// Display Homework By Id
	public Homework getHomeworkById(int homeId) throws HomeworkNotFoundException {
		LOG.info("getHomeworkById " + homeId);
		Optional<Homework> optHomework = homeworkRepository.findById(homeId);
		if (optHomework.isEmpty()) {
			LOG.error("Homework not found.");
			throw new HomeworkNotFoundException("The Homework with ID " + homeId + " not found");
		} else
			return optHomework.get();
	}

	// UpdateHomework Details
	public Homework updateHomework(Homework homework) {
		LOG.info("updateHomework");
		return homeworkRepository.save(homework);
	}

	// Delete Homework
	public int deleteHomework(int homeId) {
		LOG.info("deleteHomework");
		homeworkRepository.deleteById(homeId);
		return homeId;
	}

}