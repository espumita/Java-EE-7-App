package controllers;

import infrastructure.UserMemoryRepository;
import beans.LogBeanInterface;
import utils.Session;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Logout", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    @EJB
    LogBeanInterface logBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = new Session(request.getSession(), logBean, new UserMemoryRepository());
        if(session.isUserLogged()) session.logout();
        //redirect
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
