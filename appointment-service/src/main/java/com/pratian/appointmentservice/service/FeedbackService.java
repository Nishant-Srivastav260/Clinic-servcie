package com.pratian.appointmentservice.service;



import org.springframework.stereotype.Service;

import com.pratian.appointmentservice.entities.Feedback;
import com.pratian.appointmentservice.exceptions.AppointmentNotFoundException;
import com.pratian.appointmentservice.exceptions.FeedbackNotFoundException;
@Service
public interface FeedbackService {
	
	//public Feedback createFeedback(Feedback feedback);
	public Feedback getFeedback(Long id) throws FeedbackNotFoundException, AppointmentNotFoundException;
    //public Feedback addFeedback(Feedback feedback , Long id) throws AppointmentNotFoundException, FeedbackNotFoundException;

}
