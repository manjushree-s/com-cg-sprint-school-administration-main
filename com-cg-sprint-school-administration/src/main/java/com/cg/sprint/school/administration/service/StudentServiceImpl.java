package com.cg.sprint.school.administration.service;

import java.util.Date;
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
public class StudentServiceImpl {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	ComplaintRepository complaintRepository;

	@Autowired
	TeacherRepository teacherRepository;

	private static final Logger LOG = LoggerFactory.getLogger(StudentService.class);
	
	public String loginStudent(Student student) {
		LOG.info("login Student");
		LOG.info(student.toString());
		Student student2 = studentRepository.getById(student.getStudentId());
		LOG.info(student2.toString());
		if (student.getStudentId()==(student2.getStudentId()) && student.getStudentPassword().equals(student2.getStudentPassword())) {
			LOG.info(student.toString());
			LOG.info(student2.toString());
			return "Login Succesful";
		} else {
			throw new IncorrectLoginCredentialsException("Invalid user name or password.");
		}

	}

	// Add Student
	public Student addStudent(Student student) {
		LOG.info("addStudent");
		try {
			return studentRepository.save(student);
		} catch (IllegalArgumentException iae) {
			LOG.error(iae.getMessage());
			return null;
		}
	}

	// display all student
	public List<Student> getAllStudent() {
		LOG.info("getAllStudent");
		return (List<Student>) studentRepository.findAll();
	}

	// Display Students by Id
	public Student getStudentById(int studentId) throws StudentNotFoundException {
		LOG.info("getStudentById " + studentId);
		Optional<Student> optStudent = studentRepository.findById(studentId);
		if (optStudent.isEmpty()) {
			LOG.error("Student not found.");
			throw new StudentNotFoundException("The student with ID " + studentId + " not found");
		} else
			return optStudent.get();
	}

	// Update Student Details
	public Student updateStudent(Student student) {
		LOG.info("updateStudent");
		return studentRepository.save(student);
	}

	// Delete Student
	public int deleteStudent(int studentId) {
		LOG.info("deleteStudent");
		studentRepository.deleteById(studentId);
		return studentId;
	}

	//Add Complaint
	public Complaint addComplaint(Complaint complaint) throws IllegalArgumentException {
		LOG.info("addComplaint");
		try {
			return complaintRepository.save(complaint);
		} catch (IllegalArgumentException iae) {
			LOG.error(iae.getMessage());
			return null;
		}
	}

	//Display all complaint
	public List<Complaint> getAllComplaint() {
		LOG.info("getAllCompalint");
		return (List<Complaint>) complaintRepository.findAll();
	}

	
	//Display complaint by Id
	public Complaint getComplaintById(int complaintId) throws ComplaintNotFoundException {
		LOG.info("getComplaintById " + complaintId);
		Optional<Complaint> optComplaint = complaintRepository.findById(complaintId);
		if (optComplaint.isEmpty()) {
			LOG.error("No Complaint Found.");
			throw new ComplaintNotFoundException("The complaint with ID " + complaintId + " not found");
		} else
			return optComplaint.get();
	}

	// Update Complaint Details
	public Complaint updateComplaint(Complaint complaint) {
		LOG.info("updateComplaint");
		return complaintRepository.save(complaint);
	}

	// Delete Complaint
	public int deleteComplaint(int complaintId) {
		LOG.info("deleteComplaint");
		complaintRepository.deleteById(complaintId);
		return complaintId;
	}

}