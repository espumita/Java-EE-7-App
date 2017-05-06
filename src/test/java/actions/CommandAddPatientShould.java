package actions;

import infrastructure.repositories.DoctorRepository;
import model.Patient;
import model.PatientBuilder;
import model.Sample;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CommandAddPatientShould {

    private DoctorRepository doctorRepository;

    @Before
    public void setUp() throws Exception {
        doctorRepository = mock(DoctorRepository.class);
    }

    @Test
    public void add_a_patient_to_a_doctor_patients_list() throws Exception {
        Patient patient = new PatientBuilder()
                .withGender("Male")
                .withName("someName")
                .withAddress("someAddress")
                .withAge("someAge")
                .withDNI("someDNI")
                .withSamplesHistory(Lists.newArrayList(
                        new Sample("someGlucoseLevel", new Date().toString())))
                .build();
        CommandAddPatient commandAddPatient = new CommandAddPatient(patient, doctorRepository ,"someId");

        commandAddPatient.run();

        verify(doctorRepository).addPatient(eq(patient), eq("someId"));
    }

}
