package com.example.but3_dev_avancee.action;

import com.example.but3_dev_avancee.model.UserBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginAction implements Action {
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserBean userBean = new UserBean(username, password);
        if (userBean.isValid()) {
            session.setAttribute("user", userBean);
            return "Page1.jsp";
        } else {
            return "error.jsp";
        }
    }
}