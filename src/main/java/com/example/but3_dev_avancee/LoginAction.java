package com.example.but3_dev_avancee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "loginAction", value = "/login-action")
public class LoginAction extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        if (user.isValid()) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("Page1.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}