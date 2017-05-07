package actions;

import infrastructure.repositories.DoctorRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ActionLoadDoctorShould {

    private DoctorRepository doctorRepository;

    @Before
    public void setUp() throws Exception {
        doctorRepository = mock(DoctorRepository.class);
    }

    @Test
    public void load_the_patients_doctor() throws Exception {
        String doctorDni = "someDni";
        ActionLoadDoctor actionLoadDoctor = new ActionLoadDoctor(doctorRepository, doctorDni);

        actionLoadDoctor.run();

        verify(doctorRepository).fullLoad(eq(doctorDni));
    }
}
