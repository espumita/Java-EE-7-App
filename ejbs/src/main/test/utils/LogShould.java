package utils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintWriter;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LogShould {

    private PrintWriter writer;

    @Before
    public void setUp() throws Exception {
        writer = mock(PrintWriter.class);
    }

    @Test
    public void persist_the_bad_login() throws Exception {
        Log log = new Log(writer);

        log.logException("someName");

        verify(writer).append(any(String.class));
        verify(writer).close();
    }

    @Test
    public void persist_a_sample_report() throws Exception {
        Log log = new Log(writer);

        log.logReport(2000);

        verify(writer).append(any(String.class));
        verify(writer).close();
    }
}
