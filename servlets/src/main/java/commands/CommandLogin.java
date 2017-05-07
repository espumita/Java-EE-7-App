package commands;

import beans.LogBeanInterface;
import infrastructure.repositories.postgres.UserPostgresRepository;
import utils.Session;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandLogin implements  Command{
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public CommandLogin(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @EJB
    LogBeanInterface logBean;

    @Override
    public void run() throws IOException, ServletException {
        UserPostgresRepository userRepository = new UserPostgresRepository();
        Session session = new Session(request.getSession(), logBean, userRepository);
        if(session.isUserLogged()){
            if (session.isUserAPatient()){
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/patient"));
            }else{
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/list"));
            }
        }else{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
