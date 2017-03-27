package model;

import org.junit.Test;

import java.util.Date;

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
}

