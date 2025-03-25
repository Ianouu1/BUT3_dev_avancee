package com.example.but3_dev_avancee;

import com.example.but3_dev_avancee.model.UserBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ActionUn implements Action {
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserBean userBean = (UserBean) session.getAttribute("user");
        if (userBean != null) {
            userBean.setAttribute2(request.getParameter("attribute2"));
            userBean.setAttribute3(request.getParameter("attribute3"));
            return "Page1.jsp";
        } else {
            return "error.jsp";
        }
    }
}