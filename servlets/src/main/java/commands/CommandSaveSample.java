package commands;

import actions.ActionAddSample;
import beans.LogBeanInterface;
import infrastructure.repositories.postgres.PatientPostgresRepository;
import infrastructure.repositories.postgres.UserPostgresRepository;
import model.Sample;
import utils.Session;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class CommandSaveSample implements Command {

    @EJB
    LogBeanInterface logBean;

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public CommandSaveSample(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void run() throws IOException, ServletException {
        Session session = new Session(request.getSession(), logBean, new UserPostgresRepository());
        if(session.isUserLogged() && session.isUserAPatient()){
            String sampleValue = ((String) request.getParameter("sampleValue"));
            String dni = request.getSession().getAttribute("dni").toString();
            PatientPostgresRepository patientRepository = new PatientPostgresRepository();
            Sample sample = new Sample(sampleValue, new Date().toString());
            ActionAddSample command = new ActionAddSample(sample, patientRepository, dni);
            try {
                command.run();
            } catch (Exception e) { }
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/handler?command=PatientProfile"));
        }else {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/handler?command=Login"));
        }
    }
}
