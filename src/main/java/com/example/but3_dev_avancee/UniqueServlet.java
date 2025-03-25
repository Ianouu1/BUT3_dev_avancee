package com.example.but3_dev_avancee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UniqueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String actionName = request.getServletPath().substring(1);
        Action action = ActionFactory.getAction(actionName);

        String redirect = null;
        if (action != null) {
            redirect = action.perform(request, response);
        } else {
            redirect = "error.jsp";
        }
        response.sendRedirect(redirect);
    }
}