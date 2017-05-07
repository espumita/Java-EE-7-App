package commands;

import beans.LogBeanInterface;
import infrastructure.repositories.postgres.UserPostgresRepository;
import utils.Session;
import utils.UserCredentials;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandCheckLogin implements  Command {

    @EJB
    LogBeanInterface logBean;

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public CommandCheckLogin(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void run() throws IOException, ServletException {
        Session session = new Session(request.getSession(), logBean, new UserPostgresRepository());
        if (session.isUserLogged()){
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login"));
            return;
        }

        try {
            String dni = request.getParameter("dni");
            session.login(new UserCredentials(dni));
        } catch (Exception e) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/error"));
            return;
        }

        if (session.isUserAPatient()){
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/patient"));
        }else{
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/list"));
        }
    }
}
