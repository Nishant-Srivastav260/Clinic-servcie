package com.pratian.appointmentservice.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.appointmentservice.entities.Appointment;
import com.pratian.appointmentservice.entities.Recommendation;
import com.pratian.appointmentservice.entities.Test;
import com.pratian.appointmentservice.entities.Vitals;
import com.pratian.appointmentservice.exceptions.AppointmentAlreadyExistsException;
import com.pratian.appointmentservice.exceptions.AppointmentNotFoundException;
import com.pratian.appointmentservice.exceptions.VitalsNotFoundException;
import com.pratian.appointmentservice.repository.IAppointmentRepo;
import com.pratian.appointmentservice.repository.RecommendationRepository;
import com.pratian.appointmentservice.repository.TestRepo;
import com.pratian.appointmentservice.repository.VitalsRepo;
import com.pratian.appointmentservice.service.IAppointmentService;

@Service
public class AppointmentServiceImpl implements IAppointmentService {
	@Autowired
	IAppointmentRepo appRepo;
	@Autowired
	TestRepo tRepo;

	@Autowired
	RecommendationRepository repo;

	@Autowired
	VitalsRepo vitalrepo;

	@Override
	public List<Appointment> getAllAppointments() throws AppointmentNotFoundException {
		List<Appointment> appointments = appRepo.findAll();
		if (appointments.isEmpty()) {
			throw new AppointmentNotFoundException();
		} else
			return appointments;
	}

	@Override
	public Appointment addAppointment(Appointment appointment) throws AppointmentAlreadyExistsException {
		if (appRepo.existsById(appointment.getId())) {

			throw new AppointmentAlreadyExistsException();
		} else
			return appRepo.save(appointment);
	}

	@Override
	public Appointment getAppointmentById(long id) throws AppointmentNotFoundException {

		if (appRepo.existsById(id)) {
			Appointment appointment = appRepo.getAppointmentById(id);
			return appointment;
		} else
			throw new AppointmentNotFoundException("Appointment not found for this ID");
	}

	@Override
	public List<Test> getTestsForAppointment(long id) throws AppointmentNotFoundException {

		if (!appRepo.existsById(id)) {
			throw new AppointmentNotFoundException();
		} else {
			return appRepo.getAppointmentById(id).getTests(); ///////////

		}
	}

	@Override
	public void deleteTestsfoAppointment(long id, long testId) throws AppointmentNotFoundException {
		if (appRepo.getTestsforAppointment(id) == null) {
			throw new AppointmentNotFoundException("Appointment not found.");
		} else {
			Appointment t = appRepo.getAppointmentById(id);
			Test test = tRepo.getTestById(testId);
			System.out.println(test.getTestName());
			t.getTests().remove(test);
			appRepo.save(t);
		}

	}

	@Override
	public Appointment updateRecommendationAppo(Recommendation rec[], long id) throws AppointmentNotFoundException {

		Appointment appointment = appRepo.getAppointmentById(id);

		Map<Long, Recommendation> recMap = new HashMap<Long, Recommendation>();

		for (Recommendation r : rec) {
			if (recMap.get(r.getDoctor().getId()) == null) {
				recMap.put(r.getDoctor().getId(), r);
			}
		}

		List<Recommendation> recList = recMap.values().stream().collect(Collectors.toList());

		List<Recommendation> getAllRec = new ArrayList<Recommendation>();
		for (int i = 0; i <= recList.size() - 1; i++) {
			getAllRec.add(recList.get(i));

		}
		appointment.setRecommendations(getAllRec);
		return appRepo.save(appointment);

	}

	@Override
	public void deleteRecommendationAppointment(long id, long recommendationId) throws AppointmentNotFoundException {

		if (appRepo.getAppointmentByIdForRecommendation(id) == null) {
			throw new AppointmentNotFoundException("Appointment not found.");
		} else {
			Appointment appointment = appRepo.getAppointmentById(id);
			Recommendation rec = repo.findById(recommendationId).get();
			System.out.println(rec.getDoctor());
			appointment.getRecommendations().remove(rec);
			appRepo.save(appointment);
		}

	}

	// method to get vitals by appointment id
	public Vitals getVitalsbyAppoinmentId(long id) throws AppointmentNotFoundException {
		if (!appRepo.existsById(id)) {
			throw new AppointmentNotFoundException();
		} else {
			Appointment oldAppoinment = appRepo.getAppointmentByIdForRecommendation(id);
			Vitals vital = oldAppoinment.getVitals();
			return vital;
		}
	}

	// method to edit and save vitals by appointment id
	public Vitals editVitals(Vitals vital, long id) throws VitalsNotFoundException, AppointmentNotFoundException {
		Appointment oldAppoinment = appRepo.findById(id)
				.orElseThrow(() -> new AppointmentNotFoundException("vital not found for that appointment"));

		Vitals v = oldAppoinment.getVitals();
		v.setECG(vital.getECG());
		v.setDiabetes(vital.getDiabetes());
		v.setTemperature(vital.getTemperature());
		v.setRespiration_rate(vital.getRespiration_rate());
		return vitalrepo.save(v);

	}

	@Override
	public Appointment getAllAppointment(long appointmnetId) throws AppointmentNotFoundException {
		// List<Recommendation> lst=new ArrayList<Recommendation>();
		List<Appointment> list = appRepo.findAll();
		if (list.size() <= 0) {
			throw new AppointmentNotFoundException("Data not found");
		} else {

			return appRepo.getAppointmentByIdForRecommendation(appointmnetId);
		}
	}

	@Override
	public List<Appointment> findAll() {
		return appRepo.findAll();
	}

	public int getAcceptedAppointments() {
		List<Appointment> appiAppointments = appRepo.findAll();
		ArrayList<Appointment> acceptedAppiAppointments = new ArrayList<Appointment>();
		for (Appointment appointment : appiAppointments) {
			if (appointment.getStatus().equalsIgnoreCase("Accepted")) {
				acceptedAppiAppointments.add(appointment);
			}
		}
		return acceptedAppiAppointments.size();
	}

	@Override
	public int getCancelledAppointments() {
		List<Appointment> appiAppointments = appRepo.findAll();
		ArrayList<Appointment> cancelAppiAppointments = new ArrayList<Appointment>();
		for (Appointment appointment : appiAppointments) {
			if (appointment.getStatus().equalsIgnoreCase("Cancelled")) {
				cancelAppiAppointments.add(appointment);
			}
		}
		return cancelAppiAppointments.size();
	}

	@Override
	public int gettotalAppointments() {
		return appRepo.findAll().size();

	}

	@Override
	public List<Appointment> getfilterconfirmedAppointments() throws AppointmentNotFoundException {
		List<Appointment> appointments = appRepo.findAll();
		ArrayList<Appointment> confirmedAppointments = new ArrayList<Appointment>();
		for (Appointment appointment : appointments) {
			if (appointment.getStatus().equalsIgnoreCase("accepted")) {
				confirmedAppointments.add(appointment);
			}
		}
		if (confirmedAppointments.isEmpty()) {
			throw new AppointmentNotFoundException("No Confirmed Appointments Found");
		} else
			return confirmedAppointments;
	}

	@Override
	public List<Appointment> getfiltercancelledAppointments() throws AppointmentNotFoundException {
		List<Appointment> appointments = appRepo.findAll();
		ArrayList<Appointment> cancelledAppointments = new ArrayList<Appointment>();
		for (Appointment appointment : appointments) {
			if (appointment.getStatus().equalsIgnoreCase("Cancelled")) {
				cancelledAppointments.add(appointment);
			}
		}
		if (cancelledAppointments.isEmpty()) {
			throw new AppointmentNotFoundException("No Cancelled Appointments Found");
		} else
			return cancelledAppointments;
	}

	@Override
	public List<Appointment> getfilterclosedAppointments() throws AppointmentNotFoundException {
		List<Appointment> appointments = appRepo.findAll();
		ArrayList<Appointment> closedAppointments = new ArrayList<Appointment>();
		for (Appointment appointment : appointments) {
			if (appointment.getStatus().equalsIgnoreCase("Closed")) {
				closedAppointments.add(appointment);
			}
		}
		if (closedAppointments.isEmpty()) {
			throw new AppointmentNotFoundException("No Cancelled Appointments Found");
		} else
			return closedAppointments;
	}

	@Override
	public List<Appointment> getpendingAppointments() throws AppointmentNotFoundException {
		List<Appointment> appointments = appRepo.findAll();
		ArrayList<Appointment> pendingAppointments = new ArrayList<Appointment>();
		for (Appointment appointment : appointments) {
			if (appointment.getStatus().equalsIgnoreCase("pending")) {
				pendingAppointments.add(appointment);
			}
		}
		if (pendingAppointments.isEmpty()) {
			throw new AppointmentNotFoundException();
		} else
			return pendingAppointments;
	}

	@Override
	public void deleteAppointment(long id) throws AppointmentNotFoundException {
		if (appRepo.existsById(id)) {
			appRepo.deleteById(id);
		} else
			throw new AppointmentNotFoundException();
	}

	public Appointment updateAppointmnet(long id, String status) {
		Appointment myPatient = appRepo.getAppointmentById(id);
		myPatient.setStatus(status);
		return appRepo.save(myPatient);
	}

}
