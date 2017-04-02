package actions;

import infrastructure.DoctorRepository;
import model.Patient;

public class CommandAddPatient implements Command {
    private final Patient patient;
    private final DoctorRepository doctorRepository;
    private final String id;

    public CommandAddPatient(Patient patient, DoctorRepository doctorRepository, String id) {

        this.patient = patient;
        this.doctorRepository = doctorRepository;
        this.id = id;
    }

    @Override
    public void run() {
        doctorRepository.addPatient(patient, id);
    }
}
