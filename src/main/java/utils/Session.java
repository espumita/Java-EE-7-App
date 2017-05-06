package utils;

import infrastructure.repositories.UserRepository;
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
            log.log(userCredentials.dni());
            throw new BadLoginException();
        }
        httpSession.setAttribute("dni", userCredentials.dni());
        String role = userRepository.role(userCredentials);
        httpSession.setAttribute("role", role);
    }

    public void logout() {
        httpSession.invalidate();
    }

    public boolean isUserLogged() {
        return  httpSession != null && httpSession.getAttribute("dni") != null && httpSession.getAttribute("dni") != "";
    }

    public boolean isUserAPatient() {
        String role = (String) httpSession.getAttribute("role");
        return role.equals("PATIENT");
    }
}
