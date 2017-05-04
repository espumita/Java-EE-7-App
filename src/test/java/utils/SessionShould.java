package utils;

import beans.LogBean;
import infrastructure.UserMemoryRepository;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import utils.exceptions.BadLoginException;

import javax.servlet.http.HttpSession;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.BDDAssertions.then;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SessionShould {


    private HttpSession httpSession;
    private LogBean log;
    private Session session;
    private static final String A_PATIENT_DNI = "patient";
    private static final String A_DOCTOR_DNI = "doctor";

    @Before
    public void setUp() throws Exception {
        httpSession = mock(HttpSession.class);
        log = mock(LogBean.class);
        session = new Session(httpSession, log ,  new UserMemoryRepository());
    }

    @Test
    public void login_a_user() throws Exception {
        UserCredentials userCredentials = new UserCredentials(A_PATIENT_DNI);

        session.login(userCredentials);

        verify(httpSession).setAttribute(eq("dni"), any(User.class));
    }

    @Test
    public void set_the_patient_role_when_the_user_logs_as_a_patient() throws Exception {
        UserCredentials userCredentials = new UserCredentials(A_PATIENT_DNI);

        session.login(userCredentials);

        verify(httpSession).setAttribute(eq("role"), eq("PATIENT"));
    }

    @Test
    public void set_the_doctor_role_when_the_user_logs_as_a_doctor() throws Exception {
        UserCredentials userCredentials = new UserCredentials(A_DOCTOR_DNI);

        session.login(userCredentials);

        verify(httpSession).setAttribute(eq("role"), eq("DOCTOR"));
    }

    @Test
    public void trow_an_exception_when_an_unknown_user_tries_to_login() throws Exception {
        UserCredentials userCredentials = new UserCredentials("unknownUser");

        when(session).login(userCredentials);

        then(caughtException()).isInstanceOf(BadLoginException.class);
    }

    @Test
    public void log_the_exception_when_an_unknown_user_tries_to_login() throws Exception {
        UserCredentials userCredentials = new UserCredentials("unknownUser");

        when(session).login(userCredentials);

        verify(log).log(any(String.class));
        then(caughtException()).isInstanceOf(BadLoginException.class);
    }


    @Test
    public void logout_a_user() throws Exception {

        session.logout();

        verify(httpSession).invalidate();
    }


    @Test
    public void tell_us_if_user_is_logged() throws Exception {
        Mockito.when(httpSession.getAttribute(eq("dni"))).thenReturn("SomeSessionContent");

        boolean userLogged = session.isUserLogged();

        assertThat(userLogged, is(true));
    }


    @Test
    public void tell_us_if_user_is_not_logged() throws Exception {
        Mockito.when(httpSession.getAttribute(eq("dni"))).thenReturn("");

        boolean userLogged = session.isUserLogged();

        assertThat(userLogged, is(false));
    }

    @Test
    public void tell_us_if_the_user_is_a_patient() throws Exception {
        Mockito.when(httpSession.getAttribute(eq("role"))).thenReturn("PATIENT");

        boolean isUserAPatient = session.isUserAPatient();

        assertThat(isUserAPatient, is(true));
    }

    @Test
    public void tell_us_if_the_user_is_not_a_patient() throws Exception {
        Mockito.when(httpSession.getAttribute(eq("role"))).thenReturn("DOCTOR");

        boolean isUserAPatient = session.isUserAPatient();

        assertThat(isUserAPatient, is(false));
    }
}
