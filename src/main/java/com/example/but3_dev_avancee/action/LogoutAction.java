package com.example.but3_dev_avancee.action;

import com.example.but3_dev_avancee.model.UserBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutAction implements Action {
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        String username = null;
        if (session != null) {
            UserBean userBean = (UserBean) session.getAttribute("user");
            if (userBean != null) {
                username = userBean.getUsername();
            }
            session.invalidate();
        }
        return "goodbye.jsp?username=" + (username != null ? username : "");
    }
}