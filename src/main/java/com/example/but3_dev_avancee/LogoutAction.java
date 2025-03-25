package com.example.but3_dev_avancee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "logoutAction", value = "/logout-action")
public class LogoutAction extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = null;
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                username = user.getUsername();
            }
            session.invalidate();
        }
        response.sendRedirect("goodbye.jsp?username=" + username);
    }
}