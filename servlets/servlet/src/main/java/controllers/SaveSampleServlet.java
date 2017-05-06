package controllers;

import actions.CommandAddSample;
import beans.LogBeanInterface;
import infrastructure.repositories.memory.PatientMemoryRepository;
import infrastructure.repositories.postgres.UserPostgresRepository;
import model.Sample;
import utils.Session;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet(name = "SaveSampleServlet", urlPatterns = "/saveSample")
public class SaveSampleServlet extends HttpServlet {

    @EJB
    LogBeanInterface logBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = new Session(request.getSession(), logBean, new UserPostgresRepository());
        if(session.isUserLogged() && session.isUserAPatient()){
            String sampleValue = ((String) request.getParameter("sampleValue"));
            String dni = request.getSession().getAttribute("dni").toString();
            PatientMemoryRepository patientRepository = PatientMemoryRepository.getInstance();
            Sample sample = new Sample(sampleValue, new Date());
            CommandAddSample command = new CommandAddSample(sample, patientRepository, dni);
            command.run();
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/patient"));
        }else {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
