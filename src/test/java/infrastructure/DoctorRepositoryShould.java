package infrastructure;

import model.Doctor;
import org.junit.Before;
import org.junit.Test;

import static model.Doctor.*;
import static org.junit.Assert.assertTrue;

public class DoctorRepositoryShould {

    private DoctorRepository doctorRepository;
    private static final String SOME_DNI = "patient";

    @Before
    public void setUp(){
        doctorRepository = new DoctorMemoryRepository();
    }

    @Test
    public void load_a_doctor_when_the_patient_has_a_doctor() throws Exception {

        Doctor doctor = doctorRepository.load(SOME_DNI);

        assertTrue(doctor instanceof Doctor);
    }

    @Test
    public void load_a_not_assigned_doctor_when_the_patient_has_no_doctor() throws Exception {

        Doctor doctor = doctorRepository.load("otherDni");

        assertTrue(doctor instanceof NotAssignedDoctor);
    }
}
