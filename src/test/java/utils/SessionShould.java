package utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpSession;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SessionShould {


    @Test
    public void login_an_user_adding_some_credentials_to_session() {
        HttpSession httpSession = mock(HttpSession.class);
        Session session = new Session(httpSession);
        User user = new User("someUserName");

        session.login(user);

        verify(httpSession).setAttribute(any(String.class), eq(user.name()));
    }
}
