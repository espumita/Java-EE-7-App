package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "someName", urlPatterns = "/example")
public class ServletExample extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("example.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
