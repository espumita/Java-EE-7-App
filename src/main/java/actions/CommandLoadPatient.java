package actions;

import infrastructure.repositories.PatientRepository;
import model.Patient;
import model.exceptions.IncompletePatient;

public class CommandLoadPatient implements Command{
    private final String dni;
    private final PatientRepository patientRepository;

    public CommandLoadPatient(String dni, PatientRepository patientRepository) {
        this.dni = dni;
        this.patientRepository = patientRepository;
    }

    public Patient run() throws IncompletePatient {
        return  patientRepository.load(dni);
    }
}
