package model;

import model.exceptions.IncompletePatient;
import org.junit.Test;

import java.util.Date;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.BDDAssertions.then;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class PatientShould {

    @Test
    public void should_trow_an_exception_if_patient_is_incomplete() throws Exception, IncompletePatient {
        PatientBuilder patientBuilder = new PatientBuilder()
                .withGender("")
                .withName("")
                .withAddress("")
                .withAge(null)
                .withDNI(null);

        when(patientBuilder).build();

        then(caughtException()).isInstanceOf(IncompletePatient.class);
    }

    @Test
    public void should_not_trow_an_exception_if_patient_is_complete() throws Exception, IncompletePatient {
        PatientBuilder patientBuilder = new PatientBuilder()
                .withGender("Male")
                .withName("someName")
                .withAddress("someAddress")
                .withAge("someAge")
                .withDNI("someDNI");

        Object patient = patientBuilder.build();

        assertTrue(patient instanceof Patient);
    }

    @Test
    public void can_add_a_sample() throws Exception {
        Patient patient = new PatientBuilder()
                .withGender("Male")
                .withName("someName")
                .withAddress("someAddress")
                .withAge("someAge")
                .withDNI("someDNI")
                .build();
        Date now = new Date();

        patient.add(new Sample("SomeGlucoseLevel", now));

        assertThat(patient.samples().size(), is(1));
    }
}

