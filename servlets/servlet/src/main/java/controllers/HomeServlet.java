package controllers;

import Infrastructure.UserMemoryRepository;
import beans.LogBeanInterface;
import model.Doctor;
import utils.Log;
import utils.Session;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Home", urlPatterns = "/home")
public class HomeServlet extends javax.servlet.http.HttpServlet {

    @EJB LogBeanInterface logBean;


    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Session session = new Session(request.getSession(), new Log(new PrintWriter("Log.txt", "UTF-8")), new UserMemoryRepository());
        if(session.isUserLogged()){
            //Load and setAttribute user(medic or patient)
            Doctor doctor = new Doctor("someName");
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
