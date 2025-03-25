package com.example.but3_dev_avancee;

import com.example.but3_dev_avancee.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class ActionUn implements Action {
    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            user.setAttribute2(request.getParameter("attribute2"));
            user.setAttribute3(request.getParameter("attribute3"));
            response.sendRedirect("Page1.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}