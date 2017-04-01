package actions;

import infrastructure.PatientRepository;

public class CommandLoadPatient implements Command{
    private final String dni;
    private final PatientRepository patientRepository;

    public CommandLoadPatient(String dni, PatientRepository patientRepository) {
        this.dni = dni;
        this.patientRepository = patientRepository;
    }

    @Override
    public void run() {
        patientRepository.load(dni);
    }
}
