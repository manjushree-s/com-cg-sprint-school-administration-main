package com.cg.sprint.school.administration.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.cg.sprint.school.administration.exception.*;
import com.cg.sprint.school.administration.model.Complaint;
//import com.cg.sprint.school.administration.model.Complaint;
//import com.cg.sprint.school.administration.model.Course;
//import com.cg.sprint.school.administration.model.Homework;
//import com.cg.sprint.school.administration.model.Notice;
//import com.cg.sprint.school.administration.model.StudyMaterial;
import com.cg.sprint.school.administration.model.Student;

public interface StudentService {
	
	public Student loginStudent(int studentId, String studentPassword) throws IncorrectLoginCredentialsException;
	
	public Student addStudent(Student student);
	
	public List<Student> getAllStudent();
	
	public Student getStudentById(int studentId) throws StudentNotFoundException;
	
	public Student updateStudent(Student student);
	
	public int deleteStudent(int studentId);
	
	public Complaint addComplaint(Complaint complaint) throws IllegalArgumentException;
	
	public List<Complaint> getAllComplaint();
	
	public Optional<Complaint> getComplaintById(int complaintId) throws ComplaintNotFoundException;
		
	public List<Complaint> getComplaintByDate(Date date) throws ComplaintNotFoundException;
	
	public Complaint updateComplaint(Complaint complaint);
	
	public int deleteComplaint(int complaintId);
	

}