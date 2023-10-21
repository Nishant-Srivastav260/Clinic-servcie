package com.pratian.appointmentservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.appointmentservice.entities.Appointment;
import com.pratian.appointmentservice.entities.Feedback;
import com.pratian.appointmentservice.exceptions.AppointmentNotFoundException;
import com.pratian.appointmentservice.exceptions.FeedbackNotFoundException;
import com.pratian.appointmentservice.repository.FeedbackRepository;
import com.pratian.appointmentservice.repository.IAppointmentRepo;
import com.pratian.appointmentservice.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository repo;
	@Autowired
	IAppointmentRepo iApprepo;



	@Override
	public Feedback getFeedback(Long id) throws FeedbackNotFoundException, AppointmentNotFoundException {
		System.out.println("appoinment id :" + id);
		Appointment oldAppointment = iApprepo.findById(id)
				.orElseThrow(() -> new AppointmentNotFoundException("appointment not found"));
		
		System.out.println(" patient feedback :" + oldAppointment.getFeedback().getComment());
		return oldAppointment.getFeedback();
	}

}
