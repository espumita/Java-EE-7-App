package utils;

import javax.servlet.http.HttpSession;

public class Session {

    private final HttpSession httpSession;

    private Session(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public static Session in(HttpSession httpSession) {
        return new Session(httpSession);
    }

    public void login(User user) {
        httpSession.setAttribute("name", user.name());
    }

    public void logout() {
        httpSession.invalidate();
    }

    public boolean isUserLogged() {
        return  httpSession != null && httpSession.getAttribute("name") != null && httpSession.getAttribute("name") != "";
    }
}
