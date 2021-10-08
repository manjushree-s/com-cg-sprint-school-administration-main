package com.cg.sprint.school.administration.service;

import java.util.List;

import com.cg.sprint.school.administration.exception.*;
import com.cg.sprint.school.administration.model.Course;
import com.cg.sprint.school.administration.model.Homework;
//import com.cg.sprint.school.administration.model.Course;
//import com.cg.sprint.school.administration.model.Homework;
//import com.cg.sprint.school.administration.model.Notice;
import com.cg.sprint.school.administration.model.Student;
import com.cg.sprint.school.administration.model.StudyMaterial;
//import com.cg.sprint.school.administration.model.StudyMaterial;
import com.cg.sprint.school.administration.model.Teacher;

public interface TeacherService {
	
	public String loginTeacher(Teacher teacher);
	
	public Teacher addTeacher(Teacher teacher);
	
	public List<Teacher> getAllTeacher();
	
	public Teacher getTeacherById(int teacherId) throws TeacherNotFoundException;
	
	public Teacher updateTeacher(Teacher teacher);
	
	public int deleteTeacher(int teacherId);
	
	public List<Course> getAllCourse();
	
	public Course getCourseById(int courseId) throws CourseNotFoundException;
	
	public Course updateCourse(Course course);
	
	public int deleteCourse(int courseId);
	
	public StudyMaterial addStudyMaterial(StudyMaterial studyMaterial);
	
	public List<StudyMaterial> getAllStudyMaterial();
	
	public StudyMaterial getStudyMaterialById(int studyId) throws StudyMaterialNotFoundException;
	
	public StudyMaterial updateStudyMaterial(StudyMaterial studyMaterial);
	
	public int deleteStudyMaterial(int studyId);
	
	public Homework addHomework(Homework homework);
	
	public List<Homework> getAllHomework();
	
	public Homework getHomeworkById(int homeId) throws HomeworkNotFoundException;
	
	public Homework updateHomework(Homework homework);
	
	public int deleteHomework(int homeId);


}