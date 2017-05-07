package controllers;

import commands.Command;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Class commandClass = commandClass(request);
        Constructor commandConstructor = commandConstructor(commandClass);
        Command command = command(request, response, commandConstructor);
        command.run();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
}
