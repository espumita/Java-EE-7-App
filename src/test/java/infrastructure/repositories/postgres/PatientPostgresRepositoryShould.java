package infrastructure.repositories.postgres;

import model.Patient;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PatientPostgresRepositoryShould {

    @Test
    public void load_an_existing_patient() throws Exception {
        PatientPostgresRepository patientRepository = new PatientPostgresRepository();

        Object patient = patientRepository.load("patient");

        assertTrue(patient instanceof Patient);
    }
}
