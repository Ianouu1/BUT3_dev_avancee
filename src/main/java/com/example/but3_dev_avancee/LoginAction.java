package com.example.but3_dev_avancee;

import com.example.but3_dev_avancee.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class LoginAction implements Action {
    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        if (user.isValid()) {
            session.setAttribute("user", user);
            response.sendRedirect("Page1.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}