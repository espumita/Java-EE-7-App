package actions;

import infrastructure.PatientRepository;
import model.Patient;
import model.PatientBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

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
                .build();
        CommandAddPatient commandAddPatient = new CommandAddPatient(patient, doctorRepository ,"someId");

        commandAddPatient.run();

        verify(doctorRepository).addPatient(eq(patient), eq("someId"));
    }

}
