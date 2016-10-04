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
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="event_seq")
	@SequenceGenerator(
			name="event_seq",
			sequenceName="event_sequence",
			initialValue=1,
			allocationSize=1)
	private int event_id;
	@Column(length=100, nullable = false)
	private String event_name;
	@Column(length=1500, nullable = false)
	private String event_description;
	@Column(nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime event_posted_on;
	@Column(nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime event_date;
	
	
	
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getEvent_description() {
		return event_description;
	}
	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}
	public DateTime getEvent_posted_on() {
		return event_posted_on;
	}
	public void setEvent_posted_on(DateTime event_posted_on) {
		this.event_posted_on = event_posted_on;
	}
	public DateTime getEvent_date() {
		return event_date;
	}
	public void setEvent_date(DateTime event_date) {
		this.event_date = event_date;
	}
	
	
}
