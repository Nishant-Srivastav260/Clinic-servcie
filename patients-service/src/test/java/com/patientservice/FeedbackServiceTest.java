package com.patientservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.patientservice.entities.Feedback;
import com.patientservice.entities.Patient;
import com.patientservice.exception.FeedbackNotFoundException;
import com.patientservice.repository.FeedbackRepository;
import com.patientservice.repository.PatientRepository;
import com.patientservice.service.impl.FeedbackServiceImpl;
@ExtendWith(MockitoExtension.class)
class FeedbackServiceTest {

	@Mock
    FeedbackRepository feedbackRepositoryFake;

    @Mock
    PatientRepository patientRepository;

    
    @InjectMocks
    FeedbackServiceImpl feedbackServiceImpl;


    @Test
    public void viewFeedback_ReturnsValidFeedback()
    {

        long id =1l;

        Patient patient = new Patient();
        patient.setPatientId(id);

        Feedback feedback = new Feedback();
        feedback.setFeedbackId(1l);
        feedback.setComment("Comment");
        feedback.setQ1("q1");
        feedback.setQ2("q2");
        feedback.setQ3("q3");
        feedback.setQ4("q4");

        Feedback feedbackToBeReturned = new Feedback();
        feedbackToBeReturned.setFeedbackId(1l);
        feedbackToBeReturned.setComment("Comment");
        feedbackToBeReturned.setQ1("q1");
        feedbackToBeReturned.setQ2("q2");
        feedbackToBeReturned.setQ3("q3");
        feedbackToBeReturned.setQ4("q4");


        when(patientRepository.existsById(ArgumentMatchers.any())).thenReturn(true);
        when(feedbackRepositoryFake.existsById(ArgumentMatchers.any())).thenReturn(true);
        when(feedbackRepositoryFake.getById(id)).thenReturn(feedback);
        Feedback feedbackReturned = feedbackServiceImpl.viewFeedback(id, id);
        assertEquals(id, feedbackReturned.getFeedbackId());

    }

    @Test
    public void viewFeedback_ThrowsException()
    {

        long id = 5l;
        when(patientRepository.existsById(ArgumentMatchers.any())).thenReturn(true);
        Mockito.when(feedbackRepositoryFake.existsById(ArgumentMatchers.anyLong())).thenReturn(false);
        assertThrows(FeedbackNotFoundException.class,()-> feedbackServiceImpl.viewFeedback(id, id));

    }

    @Test
    public void editFeedback_ReturnsValid_EditedFeedback()
    {
        long id = 1l;

        Feedback feedback = new Feedback();
        feedback.setFeedbackId(1l);
        feedback.setComment("Comment");
        feedback.setQ1("q1");
        feedback.setQ2("q2");
        feedback.setQ3("q3");
        feedback.setQ4("q4");

        Feedback feedbackToBeReturned = new Feedback();
        feedbackToBeReturned.setFeedbackId(1l);
        feedbackToBeReturned.setComment("Comment");
        feedbackToBeReturned.setQ1("q1");
        feedbackToBeReturned.setQ2("q2");
        feedbackToBeReturned.setQ3("q3");
        feedbackToBeReturned.setQ4("q4");

        when(patientRepository.existsById(ArgumentMatchers.any())).thenReturn(true);
        Mockito.when(feedbackRepositoryFake.existsById(ArgumentMatchers.anyLong())).thenReturn(true);
        when(feedbackRepositoryFake.getById(ArgumentMatchers.anyLong())).thenReturn(feedback);
        when(feedbackRepositoryFake.save(ArgumentMatchers.any())).thenReturn(feedback);
        Feedback f1 = feedbackServiceImpl.editFeedback(id, id, feedbackToBeReturned);

        assertEquals(f1.getFeedbackId(), feedback.getFeedbackId());
        assertEquals(f1.getComment(), feedback.getComment());
        assertEquals(f1.getQ1(), feedback.getQ1());
        assertEquals(f1.getQ2(), feedback.getQ2());
        assertEquals(f1.getQ3(), feedback.getQ3());
        assertEquals(f1.getQ4(), feedback.getQ4());

    }


    @Test
    public void editFeedback_ThrowsException()
    {

        long id = 5l;

        Feedback feedback = new Feedback();
        feedback.setFeedbackId(1l);
        feedback.setComment("Comment");
        feedback.setQ1("q1");
        feedback.setQ2("q2");
        feedback.setQ3("q3");
        feedback.setQ4("q4");
        when(patientRepository.existsById(ArgumentMatchers.any())).thenReturn(true);
        Mockito.when(feedbackRepositoryFake.existsById(ArgumentMatchers.anyLong())).thenReturn(false);
        assertThrows(FeedbackNotFoundException.class,()-> feedbackServiceImpl.editFeedback(id, id, feedback));

    }
}
