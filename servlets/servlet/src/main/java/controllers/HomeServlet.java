package controllers;

import model.Doctor;
import utils.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "Home", urlPatterns = "/home")
public class HomeServlet extends javax.servlet.http.HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Session session = Session.in(request.getSession());
        if(session.isUserLogged()){
            Doctor doctor = new Doctor();
            request.setAttribute("doctor", doctor);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
            requestDispatcher.forward(request, response);
        }else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("out.jsp");
            requestDispatcher.forward(request, response);
        }

    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
