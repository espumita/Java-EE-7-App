package utils;

import javafx.beans.binding.When;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpSession;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SessionProviderShould {


    @Test
    public void login_an_user() {
        HttpSession httpSession = mock(HttpSession.class);
        SessionProvider sessionProvider = new SessionProvider(httpSession);
        User user = new User("someUserName");

        sessionProvider.login(user);

        verify(httpSession).setAttribute(any(String.class), eq(user.name()));
    }


    @Test
    public void logout_an_user() throws Exception {
        HttpSession httpSession = mock(HttpSession.class);
        SessionProvider sessionProvider = new SessionProvider(httpSession);

        sessionProvider.logout();

        verify(httpSession).invalidate();
    }


    @Test
    public void tell_us_if_user_is_not_logged() throws Exception {
        HttpSession httpSession = mock(HttpSession.class);
        SessionProvider sessionProvider = new SessionProvider(httpSession);
        when(httpSession.getAttribute(any(String.class))).thenReturn(null);

        boolean userLogged = sessionProvider.isUserLogged();

        assertThat(userLogged, is(false));
    }


    @Test
    public void tell_us_if_user_is_logged() throws Exception {
        HttpSession httpSession = mock(HttpSession.class);
        SessionProvider sessionProvider = new SessionProvider(httpSession);
        when(httpSession.getAttribute(any(String.class))).thenReturn("SomeSessionContent");

        boolean userLogged = sessionProvider.isUserLogged();

        assertThat(userLogged, is(true));
    }


}
