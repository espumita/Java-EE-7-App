package actions;

import infrastructure.repositories.PatientRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ActionLoadPatientShould {

    private PatientRepository patientRepository;

    @Before
    public void setUp() throws Exception {
        patientRepository = mock(PatientRepository.class);
    }

    @Test
    public void load_a_patient() throws Exception {
        ActionLoadPatient actionLoadPatient = new ActionLoadPatient("someDni", patientRepository);

        actionLoadPatient.run();

        verify(patientRepository).load(eq("someDni"));
    }
}
