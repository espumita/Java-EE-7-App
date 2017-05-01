package model;

import model.exceptions.IncompletePatient;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DoctorShould {

    private Patient patient;

    @Before
    public void setUp() throws IncompletePatient {
        patient = new PatientBuilder()
                .withGender("Male")
                .withName("someName")
                .withAddress("someAddress")
                .withAge("someAge")
                .withDNI("someDNI")
                .withSamplesHistory(Lists.newArrayList(
                        new Sample("someGlucoseLevel", new Date())))
                .build();
    }


    @Test
    public void can_add_a_patient_to_his_list_of_patients() throws Exception {
        Doctor doctor = new Doctor("SomeName");

        doctor.add(patient);

        assertThat(doctor.patients().size(),is(1));
    }

    @Test
    public void can_remove_a_patient_form_his_list_of_patients() throws Exception {
        Doctor doctor = new Doctor("SomeName");
        doctor.add(patient);

        doctor.removePatientWithId("someDNI");

        assertThat(doctor.patients().size(),is(0));
    }


}
