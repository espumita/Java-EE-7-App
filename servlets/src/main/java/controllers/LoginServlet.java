package controllers;

import beans.LogBeanInterface;
import infrastructure.repositories.postgres.UserPostgresRepository;
import utils.Session;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Login", urlPatterns="/login")
public class LoginServlet extends HttpServlet {

    @EJB
    LogBeanInterface logBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}