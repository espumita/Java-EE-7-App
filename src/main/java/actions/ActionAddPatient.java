package actions;

import infrastructure.repositories.DoctorRepository;
import model.Patient;

public class ActionAddPatient implements Action {
    private final Patient patient;
    private final DoctorRepository doctorRepository;
    private final String id;

    public ActionAddPatient(Patient patient, DoctorRepository doctorRepository, String id) {

        this.patient = patient;
        this.doctorRepository = doctorRepository;
        this.id = id;
    }

    public void run() {
        doctorRepository.addPatient(patient, id);
    }
}
