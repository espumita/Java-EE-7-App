package commands;

import beans.LogBeanInterface;
import infrastructure.repositories.postgres.UserPostgresRepository;
import utils.Session;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandLogout implements Command{

    @EJB
    LogBeanInterface logBean;

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public CommandLogout(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void run() throws IOException, ServletException {
        Session session = new Session(request.getSession(), logBean, new UserPostgresRepository());
        if(session.isUserLogged()) session.logout();
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login"));
    }
}
