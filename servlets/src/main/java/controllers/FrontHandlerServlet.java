package controllers;

import beans.DoctorProfileInterface;
import beans.PatientBeanInterface;
import commands.Command;
import commands.CommandPatientDoctorProfile;
import commands.CommandPatientProfile;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "FrontHandlerServlet", urlPatterns="/handler")
public class FrontHandlerServlet extends HttpServlet {
    @EJB
    PatientBeanInterface patientBean;

    @EJB
    DoctorProfileInterface doctorProfile;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Class commandClass = commandClass(request);
        if (checkSessionBeansInjectionExceptions(request, response, commandClass)) return;
        Constructor commandConstructor = commandConstructor(commandClass);
        Command command = command(request, response, commandConstructor);
        command.run();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Class commandClass = commandClass(request);
        Constructor commandConstructor = commandConstructor(commandClass);
        Command command = command(request, response, commandConstructor);
        command.run();
    }

    private Class commandClass(HttpServletRequest request) {
        Class commandClass;
        final String command = "commands.Command" + request.getParameter("command");
        try{
            commandClass = Class.forName(command);
        }catch (ClassNotFoundException e){
            return null;
        }
        return commandClass;
    }

    private Constructor commandConstructor(Class commandClass) {
        Constructor commandConstructor;
        try {
            commandConstructor = commandClass.getConstructor(HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
        return commandConstructor;
    }

    private Command command(HttpServletRequest request, HttpServletResponse response, Constructor commandConstructor) {
        Command command;
        try {
            command = (Command) commandConstructor.newInstance(request, response);
        } catch (Exception e) {
            return  null;
        }
        return command;
    }

    private boolean checkSessionBeansInjectionExceptions(HttpServletRequest request, HttpServletResponse response, Class commandClass) {
        if(commandClass.isAssignableFrom(CommandPatientProfile.class)) {
            try {
                Command assignate = new CommandPatientProfile(request, response, patientBean);
                assignate.run();
            } catch (Exception e) { }
            return true;
        }
        if(commandClass.isAssignableFrom(CommandPatientDoctorProfile.class)) {
            try {
                Command assignate = new CommandPatientDoctorProfile(request, response, doctorProfile);
                assignate.run();
            } catch (Exception e) { }
            return true;
        }
        return false;
    }
}
