package utils;

import Infrastructure.UserRepository;
import beans.LogBeanInterface;
import utils.exceptions.BadLoginException;

import javax.servlet.http.HttpSession;

public class Session {

    private final HttpSession httpSession;
    private LogBeanInterface log;
    private UserRepository userRepository;

    public Session(HttpSession httpSession, LogBeanInterface log, UserRepository userRepository) {
        this.httpSession = httpSession;
        this.log = log;
        this.userRepository = userRepository;
    }

    public void login(UserCredentials userCredentials) throws Exception {
        if(!userRepository.exist(userCredentials)){
            log.log(userCredentials.name());
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
