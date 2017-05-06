package infrastructure.repositories.postgres;

import model.Patient;
import model.Sample;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class PatientPostgresRepositoryShould {

    private PatientPostgresRepository patientRepository;
    private final static String SOME_PATIENT_DNI = "patient";

    @Before
    public void setUp() throws Exception {
        patientRepository = new PatientPostgresRepository();
    }

    @Test
    public void load_an_existing_patient() throws Exception {

        Object patient = patientRepository.load(SOME_PATIENT_DNI);

        assertTrue(patient instanceof Patient);
    }


    @Test
    public void add_a_sample_to_a_user() throws Exception {
        Sample sample = new Sample("123", new Date().toString());

        patientRepository.addSample(sample, SOME_PATIENT_DNI);

        Patient patient = patientRepository.load(SOME_PATIENT_DNI);
        assertTrue(patient.sampleHistory().size() > 5);
    }
}
