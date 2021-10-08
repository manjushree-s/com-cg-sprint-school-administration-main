package com.cg.sprint.school.administration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "COURSE")
public class Course {

	@Id
	@Column(name = "COURSE_ID")
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;

	@NotBlank(message = "Name is mandatory")
	@Column(name = "name")
	private String name;

	@Column(name = "numhrs")
	private String numhrs;

	@ManyToOne
	@JoinColumn(name = "TEACHER_ID")
	private Teacher teacherId;

	public Course() {
	}

	public Course(int courseId, @NotBlank(message = "Name is mandatory") String name, String numhrs) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.numhrs = numhrs;
	}

	public Course(int courseId, @NotBlank(message = "Name is mandatory") String name, String numhrs,
			Teacher teacherId) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.numhrs = numhrs;
		this.teacherId = teacherId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumhrs() {
		return numhrs;
	}

	public void setNumhrs(String numhrs) {
		this.numhrs = numhrs;
	}

	public Teacher getTeacherId() {
		return teacherId;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", numhrs=" + numhrs + ", teacher=" + teacherId
				+ "]";
	}

}