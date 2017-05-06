package controllers;

import beans.LogBeanInterface;
import infrastructure.repositories.memory.UserMemoryRepository;
import utils.Session;
import utils.UserCredentials;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="CheckLoginServlet", urlPatterns="/checkLogin")
public class CheckLoginServlet extends HttpServlet {

    @EJB
    LogBeanInterface logBean;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = new Session(request.getSession(), logBean, new UserMemoryRepository());
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
