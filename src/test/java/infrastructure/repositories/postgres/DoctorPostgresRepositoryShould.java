package infrastructure.repositories.postgres;

import model.Doctor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DoctorPostgresRepositoryShould {

    private DoctorPostgresRepository doctorRepository;
    private String SOME_PATIENT_DNI = "patient";


    @Before
    public void setUp() throws Exception {
        doctorRepository = new DoctorPostgresRepository();
    }

    @Test
    public void load_a_doctor_when_the_patient_has_a_doctor() throws Exception {

        Doctor doctor = doctorRepository.simpleLoad(SOME_PATIENT_DNI);

        assertTrue(doctor instanceof Doctor);
    }
}

