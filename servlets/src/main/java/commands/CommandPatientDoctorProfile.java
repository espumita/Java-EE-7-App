package commands;

import actions.ActionLoadPatientDoctor;
import beans.DoctorProfileInterface;
import beans.LogBeanInterface;
import infrastructure.repositories.postgres.DoctorPostgresRepository;
import infrastructure.repositories.postgres.UserPostgresRepository;
import model.Doctor;
import utils.Session;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandPatientDoctorProfile implements Command {
    @EJB
    LogBeanInterface logBean;

    @EJB
    DoctorProfileInterface doctorProfile;

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public CommandPatientDoctorProfile(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void run() throws IOException, ServletException {
        Session session = new Session(request.getSession(), logBean, new UserPostgresRepository());
        if(session.isUserLogged() && session.isUserAPatient()){
            String patientDni = request.getSession().getAttribute("dni").toString();
            DoctorPostgresRepository doctorRepository = new DoctorPostgresRepository();
            ActionLoadPatientDoctor command = new ActionLoadPatientDoctor(doctorRepository, patientDni);
            Doctor doctor = command.run();

            doctorProfile.wrapper(doctor.toProfileWrapper());

            request.setAttribute("doctor", doctorProfile.wrapper());

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("PatientDoctorProfile.jsp");
            requestDispatcher.forward(request, response);
        }else {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login"));
        }
    }
}
