package com.collab.hive.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="job_seq")
	@SequenceGenerator(
			name="job_seq",
			sequenceName="job_sequence",
			initialValue=1,
			allocationSize=1)
	private int job_id;
	@Column(length=100, nullable = false)
	private String job_title;
	@Column(length=1500, nullable = false)
	private String job_details;
	@Column(nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime posted_date;
	
	
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getJob_details() {
		return job_details;
	}
	public void setJob_details(String job_details) {
		this.job_details = job_details;
	}
	public DateTime getPosted_date() {
		return posted_date;
	}
	public void setPosted_date(DateTime posted_date) {
		this.posted_date = posted_date;
	}
	
	
	
	
	
}
