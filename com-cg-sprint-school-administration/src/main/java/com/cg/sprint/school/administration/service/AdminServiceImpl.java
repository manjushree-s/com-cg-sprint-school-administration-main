package com.cg.sprint.school.administration.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.school.administration.exception.AdminNotFoundException;
import com.cg.sprint.school.administration.exception.IncorrectLoginCredentialsException;
import com.cg.sprint.school.administration.exception.NoticeNotFoundException;
import com.cg.sprint.school.administration.exception.StudyMaterialNotFoundException;
import com.cg.sprint.school.administration.model.Admin;
import com.cg.sprint.school.administration.model.Course;
import com.cg.sprint.school.administration.model.Notice;
import com.cg.sprint.school.administration.model.StudyMaterial;
import com.cg.sprint.school.administration.repository.AdminRepository;
import com.cg.sprint.school.administration.repository.NoticeRepository;
import com.cg.sprint.school.administration.repository.StudentRepository;
import com.cg.sprint.school.administration.repository.TeacherRepository;
import com.cg.sprint.school.administration.repository.StudyMaterialRepository;
import com.cg.sprint.school.administration.repository.CourseRepository;

@Service
public class AdminServiceImpl {

	private static final Logger LOG = LoggerFactory.getLogger(AdminService.class);

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private NoticeRepository noticeRepository;
	@Autowired
	private StudyMaterialRepository studyMaterialRepository;
	@Autowired
	private CourseRepository courseRepository;

	// Admin Functionalities

	// Login Function for Admin
	public Admin loginAdmin(int adminId, String password) throws IncorrectLoginCredentialsException {
		Admin admin = null;

		if (adminRepository.existsById(adminId)
				&& adminRepository.getById(adminId).getAdminPassword().equals(password)) {
			admin = adminRepository.getById(adminId);
			LOG.info("Admin login is  successfull");
			return admin;
		}
		LOG.error("Admin details are incorrect");
		throw new IncorrectLoginCredentialsException("Invalid Credentials");
	}

	// Add Admin
	public Admin addAdmin(Admin admin) {
		LOG.info("addAdmin");
		try {
			return adminRepository.save(admin);
		} catch (IllegalArgumentException iae) {
			LOG.error(iae.getMessage());
			return null;
		}
	}

	// Get Admin By Id
	public Admin getAdminById(int adminId) throws AdminNotFoundException {
		LOG.info("getAdminById " + adminId);
		Optional<Admin> optAdmin = adminRepository.findById(adminId);
		if (optAdmin.isEmpty()) {
			LOG.error("Admin not found.");
			throw new AdminNotFoundException("The admin with ID " + adminId + " not found");
		} else
			return optAdmin.get();
	}

	// Get All Admin
	public List<Admin> getAllAdmin() {
		LOG.info("getAllAdmin");
		return adminRepository.findAll();
	}

	// Update Admin Details
	public Admin updateAdmin(Admin admin) {
		LOG.info("updateAdmin");
		return adminRepository.save(admin);
	}

	// Delete Admin
	public int deleteAdmin(int adminId) {
		LOG.info("deleteAdmin");
		try {
			adminRepository.deleteById(adminId);
			return adminId;
		} catch (AdminNotFoundException ex) {
			LOG.error("Admin Not Found");
			return -1;
		}
	}

	// Notice Functionalities

	// Add Notice
	public Notice addNotice(Notice notice) throws IllegalArgumentException {
		LOG.info("addNotice");
		try {
			return noticeRepository.save(notice);
		} catch (IllegalArgumentException iae) {
			LOG.error(iae.getMessage());
			return null;
		}
	}

	// get Notice
	public List<Notice> getAllNotice() {
		LOG.info("getAllNotice");
		return (List<Notice>) noticeRepository.findAll();
	}

	// get Notice By Id
	public Notice getNoticeById(int noticeId) throws NoticeNotFoundException {
		LOG.info("getNoticeById " + noticeId);
		Optional<Notice> optNotice = noticeRepository.findById(noticeId);
		if (optNotice.isEmpty()) {
			LOG.error("No Notice Found.");
			throw new NoticeNotFoundException("The notice with ID " + noticeId + " not found");
		} else
			return optNotice.get();
	}

	// Update Notice Details
	public Notice updateNotice(Notice notice) {
		LOG.info("updateNotice");
		return noticeRepository.save(notice);
	}

	// Delete Notice
	public boolean removeNotice(int noticeId) throws NoticeNotFoundException {
		if (noticeRepository.existsById(noticeId)) {
			noticeRepository.deleteById(noticeId);
			LOG.info("removeNotice");
			return true;
		}
		LOG.error("Given id does not exist to remove Notice");
		throw new NoticeNotFoundException("Given id does not exist to remove Notice");
	}

	// StudyMaterial Functionalities

	// Add StudyMaterial
	public StudyMaterial addStudyMaterial(StudyMaterial studyMaterial) throws IllegalArgumentException {
		LOG.info("addStudyMaterial");
		try {
			return studyMaterialRepository.save(studyMaterial);
		} catch (IllegalArgumentException iae) {
			LOG.error(iae.getMessage());
			return null;
		}
	}

	// get StudyMaterial
	public List<StudyMaterial> getAllStudyMaterial() {
		LOG.info("getAllStudyMaterial");
		return (List<StudyMaterial>) studyMaterialRepository.findAll();
	}

	// get StudyMaterial By Id
	public StudyMaterial getStudyMaterialById(int studyId) throws StudyMaterialNotFoundException {
		LOG.info("getStudyMaterialById " + studyId);
		Optional<StudyMaterial> optStudyMaterial = studyMaterialRepository.findById(studyId);
		if (optStudyMaterial.isEmpty()) {
			LOG.error("No Notice Found.");
			throw new NoticeNotFoundException("The Study Material with ID " + studyId + " not found");
		} else
			return optStudyMaterial.get();
	}

	// Update StudyMaterial Details
	public StudyMaterial updateStudyMaterial(StudyMaterial studyMaterial) {
		LOG.info("updateStudyMaterial");
		return studyMaterialRepository.save(studyMaterial);
	}

	// Delete StudyMaterial
	public boolean deleteStudyMaterial(int studyId) throws StudyMaterialNotFoundException {
		if (studyMaterialRepository.existsById(studyId)) {
			studyMaterialRepository.deleteById(studyId);
			LOG.info("deleteStudyMaterial");
			return true;
		}
		LOG.error("Given id does not exist to remove StudyMaterial");
		throw new StudyMaterialNotFoundException("Given id does not exist to remove StudyMaterial");
	}
	
	//Course Functionalitites

	// Add Course
	public Course addCourse(Course course) {
		LOG.info("addCourse");
		try {
			return courseRepository.save(course);
		} catch (IllegalArgumentException iae) {
			LOG.error(iae.getMessage());
			return null;
		}
	}

	public List<Course> getAllCourse() {
		LOG.info("getAllCourse");
		return (List<Course>) courseRepository.findAll();
	}

}
