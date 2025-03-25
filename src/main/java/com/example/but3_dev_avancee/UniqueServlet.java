package com.example.but3_dev_avancee;

import com.example.but3_dev_avancee.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("*.do")
public class UniqueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath().substring(1);
        System.out.println("current action : " + action);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        switch (action) {
            case "action-debut.do":
                response.sendRedirect("Login.jsp");
                break;
            case "logout-action.do":
                handleLogout(response, session, user);
                break;
            default:
                response.sendRedirect("error.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getServletPath().substring(1);
        System.out.println("current action : " + action);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        switch (action) {
            case "login-action.do":
                handleLogin(request, response, session);
                break;
            case "actionUn.do":
                handleActionUn(request, response, user);
                break;
            default:
                response.sendRedirect("error.jsp");
                break;
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("BBBBB " + username + " " + password);
        User user = new User(username, password);
        if (user.isValid()) {
            session.setAttribute("user", user);
            response.sendRedirect("Page1.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void handleLogout(HttpServletResponse response, HttpSession session, User user) throws IOException {
        String username = null;
        System.out.println("ici chef");
        if (user != null) {
            username = user.getUsername();
        }
        session.invalidate();
        response.sendRedirect("goodbye.jsp?username=" + (username != null ? username : ""));
    }

    private void handleActionUn(HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
        if (user != null) {
            user.setAttribute2(request.getParameter("attribute2"));
            user.setAttribute3(request.getParameter("attribute3"));
            response.sendRedirect("Page1.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}