package com.patientservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientservice.entities.Feedback;
import com.patientservice.entities.Patient;
import com.patientservice.exception.FeedbackNotFoundException;
import com.patientservice.exception.PatientNotFoundException;
import com.patientservice.repository.FeedbackRepository;
import com.patientservice.repository.PatientRepository;
import com.patientservice.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService{
	@Autowired
	public FeedbackRepository feedbackRepository;

	@Autowired
	PatientRepository patientRepository;

	@Override
	public long provideFeedback(long pId,Feedback feedback) {
		if(patientRepository.existsById(pId)) {
			Patient patient =patientRepository.getPatientById(pId);
			Feedback feedBackObj = feedbackRepository.save(feedback);
			patient.getFeedbacks().add(feedBackObj);
			patientRepository.save(patient);
			return feedBackObj.getFeedbackId();
		}
		else
		{
			throw new PatientNotFoundException("Patient_Not_found");
		}

	}

	@Override
	public Feedback viewFeedback(long pId,long id) {
		if(patientRepository.existsById(pId)) {
			if(feedbackRepository.existsById(id))
			{
				Feedback f1 = feedbackRepository.getById(id);
				return f1;
			}
			else
			{
				throw new FeedbackNotFoundException("Feedback_Does_Not_Exits");
			}
		}
		else
		{
			throw new PatientNotFoundException("Patient_Not_found");
		}
	}

	@Override
	public Feedback editFeedback(long pId,long id,Feedback feedback) {
		if(patientRepository.existsById(pId)) {
			if(feedbackRepository.existsById(id))
			{
				Feedback f1 = feedbackRepository.getById(id);
				f1.setComment(feedback.getComment());
				f1.setQ1(feedback.getQ1());
				f1.setQ2(feedback.getQ2());
				f1.setQ3(feedback.getQ3());
				f1.setQ4(feedback.getQ4());
				return feedbackRepository.save(f1);
			}
			else
			{
				throw new FeedbackNotFoundException("Feedback_Does_Not_Exits");
			}
		}
		else
		{
			throw new PatientNotFoundException("Patient_Not_found");
		}

	}
}
