package com.example.but3_dev_avancee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ActionUn", value = "/actionUn")
public class ActionUn extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            String attribute2 = request.getParameter("attribute2");
            String attribute3 = request.getParameter("attribute3");
            user.setAttribute2(attribute2);
            user.setAttribute3(attribute3);
            System.out.println(user.getAttribute2());
            System.out.println(user.getAttribute3());
            response.sendRedirect("Page1.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}