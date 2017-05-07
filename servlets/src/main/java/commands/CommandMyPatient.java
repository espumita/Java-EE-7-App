package commands;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandMyPatient implements Command{

    @EJB
    LogBeanInterface logBean;

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public CommandMyPatient(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }
    @Override
    public void run() throws IOException, ServletException {
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
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/handler?command=Login"));
        }
    }
}
