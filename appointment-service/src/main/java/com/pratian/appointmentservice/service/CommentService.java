package com.pratian.appointmentservice.service;

//import org.springframework.stereotype.Service;

import com.pratian.appointmentservice.entities.Comment;
import com.pratian.appointmentservice.exceptions.AppointmentNotFoundException;


public interface CommentService {
	public Comment addComment(Comment comment, long id) throws AppointmentNotFoundException;
	public Comment getComment(long id);
	public Comment editComment(String comment, long id);

}
