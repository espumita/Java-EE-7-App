package actions;

import infrastructure.PatientRepository;
import model.Sample;

public class CommandAddSample  implements  Command{
    private final Sample sample;
    private final PatientRepository patientRepository;
    private final String dni;

    public CommandAddSample(Sample sample, PatientRepository patientRepository, String dni) {

        this.sample = sample;
        this.patientRepository = patientRepository;
        this.dni = dni;
    }

    @Override
    public void run() {
        patientRepository.addSample(sample, dni);
    }
}
