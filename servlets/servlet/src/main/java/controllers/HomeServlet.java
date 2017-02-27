package controllers;

import utils.SessionProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "Home", urlPatterns = "/home")
public class HomeServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        SessionProvider sessionProvider = new SessionProvider(request.getSession());
        if(sessionProvider.isUserLogged()){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
            requestDispatcher.forward(request, response);
        }


    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
