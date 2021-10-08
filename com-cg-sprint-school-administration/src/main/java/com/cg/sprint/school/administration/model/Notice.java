package com.cg.sprint.school.administration.model;

import java.util.Date;

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
@Table(name = "NOTICE")
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int noticeId;

	@NotBlank(message = "Name is mandatory")
	@Column(name = "name")
	private String name;

	@Column(name = "date")
	private Date date;

	@Column(name = "notice")
	private String notice;

	public Notice() {
	}

	public Notice(int noticeId, @NotBlank(message = "Name is mandatory") String name, Date date, String notice) {
		super();
		this.noticeId = noticeId;
		this.name = name;
		this.date = date;
		this.notice = notice;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", name=" + name + ", date=" + date + ", notice=" + notice + "]";
	}

}