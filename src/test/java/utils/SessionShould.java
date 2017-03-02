package utils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpSession;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SessionShould {


    private HttpSession httpSession;
    private Session session;

    @Before
    public void setUp() throws Exception {
        httpSession = mock(HttpSession.class);
        session = Session.in(httpSession);
    }

    @Test
    public void login_a_user() {
        User user = new User("someUserName");

        session.login(user);

        verify(httpSession).setAttribute(any(String.class), eq(user.name()));
    }


    @Test
    public void logout_a_user() throws Exception {

        session.logout();

        verify(httpSession).invalidate();
    }


    @Test
    public void tell_us_if_user_is_logged() throws Exception {
        when(httpSession.getAttribute(any(String.class))).thenReturn("SomeSessionContent");

        boolean userLogged = session.isUserLogged();

        assertThat(userLogged, is(true));
    }


    @Test
    public void tell_us_if_user_is_not_logged() throws Exception {
        when(httpSession.getAttribute(any(String.class))).thenReturn("");

        boolean userLogged = session.isUserLogged();

        assertThat(userLogged, is(false));
    }


}
