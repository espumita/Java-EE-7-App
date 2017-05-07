package commands;

import actions.ActionLoadDoctor;
import beans.LogBeanInterface;
import infrastructure.repositories.postgres.DoctorPostgresRepository;
import infrastructure.repositories.postgres.UserPostgresRepository;
import model.Doctor;
import model.exceptions.IncompletePatient;
import utils.Session;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandDoctorPatientList implements Command{

    @EJB
    LogBeanInterface logBean;

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public CommandDoctorPatientList(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public void run() throws IOException, ServletException {
        Session session = new Session(request.getSession(), logBean, new UserPostgresRepository());
        if(session.isUserLogged() && !session.isUserAPatient()){
            String dni = request.getSession().getAttribute("dni").toString();
            DoctorPostgresRepository doctorRepository = new DoctorPostgresRepository();
            ActionLoadDoctor command = new ActionLoadDoctor(doctorRepository, dni);
            Doctor doctor = null;
            try {
                doctor = command.run();
            } catch (IncompletePatient incompletePatient) { }
            request.setAttribute("doctor", doctor);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("DoctorPatientList.jsp");
            requestDispatcher.forward(request, response);
        }else {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/handler?command=Login"));
        }
    }
}
