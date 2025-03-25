package com.example.but3_dev_avancee;

import com.example.but3_dev_avancee.model.User;
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
            User user = (User) session.getAttribute("user");
            if (user != null) {
                username = user.getUsername();
            }
            session.invalidate();
        }
        return "goodbye.jsp?username=" + (username != null ? username : "");
    }
}