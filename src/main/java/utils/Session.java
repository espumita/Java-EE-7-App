package utils;

import Infrastructure.UserRepository;
import utils.exceptions.BadLoginException;

import javax.servlet.http.HttpSession;

public class Session {

    private final HttpSession httpSession;
    private UserRepository userRepository;

    public Session(HttpSession httpSession, UserRepository userRepository) {
        this.httpSession = httpSession;
        this.userRepository = userRepository;
    }

    public void login(UserCredentials userCredentials) throws BadLoginException {
        if(!userRepository.exist(userCredentials)){
            throw new BadLoginException();
        }
        httpSession.setAttribute("name", userCredentials.name());
    }

    public void logout() {
        httpSession.invalidate();
    }

    public boolean isUserLogged() {
        return  httpSession != null && httpSession.getAttribute("name") != null && httpSession.getAttribute("name") != "";
    }
}
