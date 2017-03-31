package model;

import model.exceptions.IncompletePattient;
import org.junit.Test;
import utils.exceptions.BadLoginException;

import java.util.Date;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.BDDAssertions.then;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PatientShould {

    @Test
    public void can_add_a_sample() throws Exception {
        Patient patient = new Patient("someId");
        Date now = new Date();

        patient.add(new Sample("SomeGlucoseLevel", now));

        assertThat(patient.samples().size(), is(1));
    }

    @Test
    public void should_trow_an_exception_if_patient_is_incomplete() throws Exception, IncompletePattient {
        PatientBuilder patientBuilder = new PatientBuilder()
                .withGender("")
                .withName("")
                .withAddress("")
                .withAge(null)
                .withDNI(null);

        when(patientBuilder).Build();

        then(caughtException()).isInstanceOf(IncompletePattient.class);
    }
}

