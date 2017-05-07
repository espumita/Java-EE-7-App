package actions;

import infrastructure.repositories.PatientRepository;
import model.Sample;

public class ActionAddSample implements  Action {
    private final Sample sample;
    private final PatientRepository patientRepository;
    private final String dni;

    public ActionAddSample(Sample sample, PatientRepository patientRepository, String dni) {

        this.sample = sample;
        this.patientRepository = patientRepository;
        this.dni = dni;
    }


    public void run() throws Exception {
        patientRepository.addSample(sample, dni);
    }
}
