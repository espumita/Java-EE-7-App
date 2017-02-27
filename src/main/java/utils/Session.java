package utils;

import javax.servlet.http.HttpSession;

public class Session {

    private final HttpSession httpSession;

    public Session(HttpSession httpSession) {

        this.httpSession = httpSession;
    }

    public void login(User user) {
        httpSession.setAttribute("name", user.name());
    }
}
