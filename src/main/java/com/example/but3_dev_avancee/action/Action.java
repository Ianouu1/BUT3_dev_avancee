package com.example.but3_dev_avancee.action;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Action {
    String perform(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
