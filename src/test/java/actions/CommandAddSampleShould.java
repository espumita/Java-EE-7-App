package actions;

import infrastructure.PatientRepository;
import model.Sample;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Matchers.eq;


@RunWith(MockitoJUnitRunner.class)
public class CommandAddSampleShould {

    private PatientRepository patientRepository;

    @Before
    public void setUp() throws Exception {
        patientRepository = Mockito.mock(PatientRepository.class);
    }

    @Test
    public void persist_the_sample() throws Exception {
        Sample sample = new Sample("someLevel", new Date());
        CommandAddSample commandAddSample = new CommandAddSample(sample, patientRepository ,"someDNI");

        commandAddSample.run();

        Mockito.verify(patientRepository).addSample(eq(sample), eq("someDNI"));
    }
}
