package controllers;

import actions.CommandLoadPatient;
import beans.LogBeanInterface;
import infrastructure.PatientMemoryRepository;
import infrastructure.UserMemoryRepository;
import model.Patient;
import model.exceptions.IncompletePatient;
import utils.Session;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "PatientProfileServlet", urlPatterns = "/PatientProfile")
public class PatientProfileServlet extends HttpServlet {

    @EJB
    LogBeanInterface logBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = new Session(request.getSession(), logBean, new UserMemoryRepository());
        if(session.isUserLogged()){
            CommandLoadPatient command = new CommandLoadPatient(request.getSession().getAttribute("dni").toString(), new PatientMemoryRepository());
            Patient patient = null;
            try {
                patient = command.run();
            } catch (IncompletePatient incompletePatient) { }
            request.setAttribute("user", patient);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("PatientProfile.jsp");
            requestDispatcher.forward(request, response);
        }else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("out.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
