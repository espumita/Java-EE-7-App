package controllers;

import actions.CommandLoadDoctor;
import beans.LogBeanInterface;
import infrastructure.repositories.memory.DoctorMemoryRepository;
import infrastructure.repositories.memory.UserMemoryRepository;
import model.Doctor;
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

@WebServlet(name = "DoctorPatientListServlet", urlPatterns = "/list")
public class DoctorPatientListServlet extends HttpServlet {

    @EJB
    LogBeanInterface logBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = new Session(request.getSession(), logBean, new UserMemoryRepository());
        if(session.isUserLogged() && !session.isUserAPatient()){
            String dni = request.getSession().getAttribute("dni").toString();
            CommandLoadDoctor command = new CommandLoadDoctor(new DoctorMemoryRepository(), dni);
            Doctor doctor = null;
            try {
                doctor = command.run();
            } catch (IncompletePatient incompletePatient) { }
            request.setAttribute("doctor", doctor);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("DoctorPatientList.jsp");
            requestDispatcher.forward(request, response);
        }else {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login"));
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
