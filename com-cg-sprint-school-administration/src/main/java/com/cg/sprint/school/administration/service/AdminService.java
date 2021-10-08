package com.cg.sprint.school.administration.service;

import java.util.List;
import com.cg.sprint.school.administration.exception.AdminNotFoundException;
import com.cg.sprint.school.administration.exception.ComplaintNotFoundException;
import com.cg.sprint.school.administration.exception.CourseNotFoundException;
import com.cg.sprint.school.administration.exception.IncorrectLoginCredentialsException;
import com.cg.sprint.school.administration.exception.NoticeNotFoundException;
import com.cg.sprint.school.administration.exception.StudentNotFoundException;
import com.cg.sprint.school.administration.exception.StudyMaterialNotFoundException;
import com.cg.sprint.school.administration.exception.TeacherNotFoundException;
import com.cg.sprint.school.administration.model.Admin;
import com.cg.sprint.school.administration.model.Course;
import com.cg.sprint.school.administration.model.Notice;
import com.cg.sprint.school.administration.model.Student;
import com.cg.sprint.school.administration.model.StudyMaterial;

public interface AdminService {
	public String loginAdmin(Admin admin);

	public Admin getAdminById(int adminId) throws AdminNotFoundException;

	public List<Admin> getAdminByName(String adminName) throws AdminNotFoundException;

	public List<Admin> getAllAdmin();

	public Admin addAdmin(Admin admin);

	public Student getStudentById(String studentId) throws StudentNotFoundException;

	public List<Student> getAllStudent();

	public boolean addStudent(Student student);

	public Notice addNotice(Notice notice) throws IllegalArgumentException;

	public List<Notice> getAllNotice();

	public Notice getNoticeById(int noticeId) throws NoticeNotFoundException;

	public Notice updateNotice(Notice notice);

	public boolean removeNotice(int noticeId) throws NoticeNotFoundException;
	
	public Course addCourse(Course course);
	
	public List<Course> getAllCourse();
	
	public boolean deleteStudyMaterial(int studyId) throws StudyMaterialNotFoundException;
	
	public StudyMaterial updateStudyMaterial(StudyMaterial studyMaterial);
	
	public StudyMaterial getStudyMaterialById(int studyId) throws StudyMaterialNotFoundException;
	
	public List<StudyMaterial> getAllStudyMaterial();
	
	public StudyMaterial addStudyMaterial(StudyMaterial studyMaterial) throws IllegalArgumentException;

}