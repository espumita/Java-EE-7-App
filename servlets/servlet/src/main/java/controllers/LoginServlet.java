package controllers;

import Infrastructure.UserMemoryRepository;
import utils.Session;
import utils.UserCredentials;
import utils.exceptions.BadLoginException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Login", urlPatterns="/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = new Session(request.getSession(), new UserMemoryRepository());
        try {
            session.login(new UserCredentials("someUserName"));
        } catch (BadLoginException e) {
            //redirect
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
