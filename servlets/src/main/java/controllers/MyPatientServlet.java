package controllers;

import actions.ActionLoadPatient;
import actions.ActionLoadPatientDoctor;
import beans.LogBeanInterface;
import infrastructure.repositories.postgres.DoctorPostgresRepository;
import infrastructure.repositories.postgres.PatientPostgresRepository;
import infrastructure.repositories.postgres.UserPostgresRepository;
import model.Doctor;
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

@WebServlet(name = "MyPatientServlet", urlPatterns = "/MyPatient")
public class MyPatientServlet extends HttpServlet {

    @EJB
    LogBeanInterface logBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = new Session(request.getSession(), logBean, new UserPostgresRepository());
        if(session.isUserLogged() && !session.isUserAPatient()){
            String patientDni = request.getParameter("dni");
            PatientPostgresRepository patientRepository = new PatientPostgresRepository();
            ActionLoadPatient patientCommand = new ActionLoadPatient(patientDni, patientRepository);
            Patient patient = null;
            try {
                patient = patientCommand.run();
            } catch (IncompletePatient incompletePatient) { }
            request.setAttribute("patient", patient);

            DoctorPostgresRepository doctorRepository = new DoctorPostgresRepository();
            ActionLoadPatientDoctor actionLoadPatientDoctor = new ActionLoadPatientDoctor(doctorRepository, patientDni);
            Doctor doctor = actionLoadPatientDoctor.run();
            request.setAttribute("doctor", doctor);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("MyPatient.jsp");
            requestDispatcher.forward(request, response);
        }else {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login"));
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
