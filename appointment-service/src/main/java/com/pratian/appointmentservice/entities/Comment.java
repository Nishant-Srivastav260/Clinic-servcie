package com.pratian.appointmentservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;
 private String comment_name;
 
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getComment_name() {
	return comment_name;
}
public void setComment_name(String comment_name) {
	this.comment_name = comment_name;
}
 
}
