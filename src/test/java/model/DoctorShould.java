package model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DoctorShould {

    @Test
    public void can_add_a_patient_to_is_patient_list() throws Exception {
        Doctor doctor = new Doctor();
        Patient patient = new Patient();

        doctor.add(patient);

        assertThat(doctor.patients().size(),is(1));
    }
}
