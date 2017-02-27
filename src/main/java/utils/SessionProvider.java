package utils;

import javax.servlet.http.HttpSession;

public class SessionProvider {

    private final HttpSession httpSession;

    public SessionProvider(HttpSession httpSession) {

        this.httpSession = httpSession;
    }

    public void login(User user) {
        httpSession.setAttribute("name", user.name());
    }

    public void logout() {
        httpSession.invalidate();
    }

    public boolean isUserLogged() {
        return httpSession.getAttribute("name") != null;
    }
}
