package actions;

import infrastructure.repositories.PatientRepository;
import model.Patient;
import model.exceptions.IncompletePatient;

public class ActionLoadPatient implements Action {
    private final String dni;
    private final PatientRepository patientRepository;

    public ActionLoadPatient(String dni, PatientRepository patientRepository) {
        this.dni = dni;
        this.patientRepository = patientRepository;
    }

    public Patient run() throws IncompletePatient {
        return  patientRepository.load(dni);
    }
}
