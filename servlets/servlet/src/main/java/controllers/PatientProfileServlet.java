package controllers;

import actions.CommandLoadPatient;
import actions.CommandLoadPatientDoctor;
import beans.LogBeanInterface;
import beans.PatientBeanInterface;
import infrastructure.repositories.memory.DoctorMemoryRepository;
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


@WebServlet(name = "PatientProfileServlet", urlPatterns = "/patient")
public class PatientProfileServlet extends HttpServlet {

    @EJB
    LogBeanInterface logBean;


    @EJB
    PatientBeanInterface patientBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = new Session(request.getSession(), logBean, new UserPostgresRepository());
        if(session.isUserLogged() && session.isUserAPatient()){
            String dni = request.getSession().getAttribute("dni").toString();
            PatientPostgresRepository patientRepository = new PatientPostgresRepository();
            CommandLoadPatient patientCommand = new CommandLoadPatient(dni, patientRepository);
            try {
                Patient patient = patientCommand.run();
                patientBean.patient(patient.toProxy());
            } catch (IncompletePatient incompletePatient) { }
            request.setAttribute("user", patientBean.patient());

            DoctorMemoryRepository doctorRepository = new DoctorMemoryRepository();
            CommandLoadPatientDoctor doctorCommand = new CommandLoadPatientDoctor(doctorRepository, dni);
            Doctor doctor = doctorCommand.run();
            request.setAttribute("doctor", doctor);


            RequestDispatcher requestDispatcher = request.getRequestDispatcher("PatientProfile.jsp");
            requestDispatcher.forward(request, response);
        }else {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login"));
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
