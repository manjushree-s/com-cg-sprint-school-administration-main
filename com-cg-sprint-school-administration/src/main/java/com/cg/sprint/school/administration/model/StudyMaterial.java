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
@Table(name = "STUDYMATERIAL")
public class StudyMaterial {
	
	@Id
	@Column(name="STUDY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int studyId;
    
    
    @Column(name = "name")
    private String name;
	
	@ManyToOne
	@JoinColumn(name = "TEACHER_ID")
	private Teacher teacherId;
    
    public StudyMaterial() {
    }

	public StudyMaterial(int studyId, String name) {
		super();
		this.studyId = studyId;
		this.name = name;
	}

	public StudyMaterial(int studyId, String name, Teacher teacherId) {
		super();
		this.studyId = studyId;
		this.name = name;
		this.teacherId = teacherId;
	}

	public int getStudyId() {
		return studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Teacher teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public String toString() {
		return "StudyMaterial [studyId=" + studyId + ", name=" + name + ", teacherId=" + teacherId
				+ "]";
	}

    
   
}