package model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DoctorShould {

    @Test
    public void can_add_a_patient_to_is_list_of_patients() throws Exception {
        Doctor doctor = new Doctor("SomeName");
        Patient patient = new Patient("someId");

        doctor.add(patient);

        assertThat(doctor.patients().size(),is(1));
    }

    @Test
    public void can_remove_a_patient_form_his_list_of_patients() throws Exception {
        Doctor doctor = new Doctor("SomeName");
        Patient patient = new Patient("someId");
        doctor.add(patient);

        doctor.removePatientWithId("someId");

        assertThat(doctor.patients().size(),is(0));
    }


}
