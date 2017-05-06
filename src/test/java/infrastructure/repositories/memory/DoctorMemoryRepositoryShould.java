package infrastructure.repositories.memory;

import infrastructure.repositories.DoctorRepository;
import model.Doctor;
import org.junit.Before;
import org.junit.Test;

import static model.Doctor.NotAssignedDoctor;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class DoctorMemoryRepositoryShould {

    private DoctorRepository doctorRepository;
    private static final String SOME_DNI = "patient";

    @Before
    public void setUp(){
        doctorRepository = new DoctorMemoryRepository();
    }

    @Test
    public void load_a_doctor_when_the_patient_has_a_doctor() throws Exception {

        Doctor doctor = doctorRepository.simpleLoad(SOME_DNI);

        assertTrue(doctor instanceof Doctor);
    }

    @Test
    public void load_a_not_assigned_doctor_when_the_patient_has_no_doctor() throws Exception {

        Doctor doctor = doctorRepository.simpleLoad("otherDni");

        assertTrue(doctor instanceof NotAssignedDoctor);
    }

    @Test
    public void full_load_a_doctor() throws Exception {

        Doctor doctor = doctorRepository.fullLoad("aDni");

        assertThat(doctor.patients().size(), is(3));
    }
}
