package utils;

import infrastructure.UserMemoryRepository;
import beans.LogBean;
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
import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.BDDAssertions.then;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;

@RunWith(MockitoJUnitRunner.class)
public class SessionShould {


    private HttpSession httpSession;
    private LogBean log;
    private Session session;

    @Before
    public void setUp() throws Exception {
        httpSession = Mockito.mock(HttpSession.class);
        log = Mockito.mock(LogBean.class);
        session = new Session(httpSession, log ,  new UserMemoryRepository());
    }

    @Test
    public void login_a_user() throws Exception {
        UserCredentials userCredentials = new UserCredentials("someDni");

        session.login(userCredentials);

        Mockito.verify(httpSession).setAttribute(any(String.class), any(User.class));
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

        try {
            session.login(userCredentials);
        }catch (BadLoginException ex){
            Mockito.verify(log).log(any(String.class));
        }

    }


    @Test
    public void logout_a_user() throws Exception {

        session.logout();

        Mockito.verify(httpSession).invalidate();
    }


    @Test
    public void tell_us_if_user_is_logged() throws Exception {
        Mockito.when(httpSession.getAttribute(any(String.class))).thenReturn("SomeSessionContent");

        boolean userLogged = session.isUserLogged();

        assertThat(userLogged, is(true));
    }


    @Test
    public void tell_us_if_user_is_not_logged() throws Exception {
        Mockito.when(httpSession.getAttribute(any(String.class))).thenReturn("");

        boolean userLogged = session.isUserLogged();

        assertThat(userLogged, is(false));
    }


}
