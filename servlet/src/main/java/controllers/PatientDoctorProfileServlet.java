package controllers;

import actions.CommandLoadPatientDoctor;
import beans.LogBeanInterface;
import infrastructure.repositories.postgres.DoctorPostgresRepository;
import infrastructure.repositories.postgres.UserPostgresRepository;
import model.Doctor;
import utils.Session;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PatientDoctorProfileServlet", urlPatterns = "/doctor")
public class PatientDoctorProfileServlet extends HttpServlet {

    @EJB
    LogBeanInterface logBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = new Session(request.getSession(), logBean, new UserPostgresRepository());
        if(session.isUserLogged() && session.isUserAPatient()){
            String patientDni = request.getSession().getAttribute("dni").toString();
            DoctorPostgresRepository doctorRepository = new DoctorPostgresRepository();
            CommandLoadPatientDoctor command = new CommandLoadPatientDoctor(doctorRepository, patientDni);
            Doctor doctor = command.run();

            request.setAttribute("doctor", doctor);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("PatientDoctorProfile.jsp");
            requestDispatcher.forward(request, response);
        }else {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login"));
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
