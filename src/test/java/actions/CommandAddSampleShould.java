package actions;

import infrastructure.repositories.PatientRepository;
import model.Sample;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class CommandAddSampleShould {

    private PatientRepository patientRepository;

    @Before
    public void setUp() throws Exception {
        patientRepository = mock(PatientRepository.class);
    }

    @Test
    public void persist_the_sample() throws Exception {
        Sample sample = new Sample("someLevel", new Date());
        CommandAddSample commandAddSample = new CommandAddSample(sample, patientRepository ,"someDNI");

        commandAddSample.run();

        verify(patientRepository).addSample(eq(sample), eq("someDNI"));
    }
}
