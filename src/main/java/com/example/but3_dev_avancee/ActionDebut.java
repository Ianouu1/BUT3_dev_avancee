package com.example.but3_dev_avancee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ActionDebut implements Action {
    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("Login.jsp");
    }
}
