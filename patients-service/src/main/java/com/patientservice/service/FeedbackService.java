package com.patientservice.service;

import com.patientservice.entities.Feedback;

public interface FeedbackService {
	public long provideFeedback(long pId,Feedback feedback);
    public Feedback viewFeedback(long pId,long id);
    public Feedback editFeedback(long pId,long id,Feedback feedback);
}
