package com.pratian.appointmentservice.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.appointmentservice.entities.Appointment;
import com.pratian.appointmentservice.entities.Comment;
import com.pratian.appointmentservice.exceptions.AppointmentNotFoundException;
import com.pratian.appointmentservice.repository.CommentRepo;
import com.pratian.appointmentservice.repository.IAppointmentRepo;
import com.pratian.appointmentservice.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {


	@Autowired
	CommentRepo commentRepo;
	@Autowired
	IAppointmentRepo appointmentRepo;
	@Override
	public Comment getComment(long id) {
		
//		return commentRepo.getCommentById(id);
		Comment com= appointmentRepo.getAppointmentById(id).getComment();
		return com;
	}
	
	@Override
	public Comment addComment(Comment comment, long id) throws AppointmentNotFoundException {
	if(appointmentRepo.existsById(id)) {	
	      Appointment appointment=appointmentRepo.getAppointmentById(id);
	    appointment.setComment(comment);
	    commentRepo.save(comment);
		  //appointmentRepo.save(appointment);
		  return comment;
    }
	else {
		throw new AppointmentNotFoundException();
	}
	
	
	
	}
	@Override
	public Comment editComment(String comment, long  id) {
		// TODO Auto-generated method stub
		Comment com= commentRepo.getCommentById(id);
		com.setComment_name(comment);
		return commentRepo.save(com);
		
	}
	
	
}
