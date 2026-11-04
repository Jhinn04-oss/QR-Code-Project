package com.attendance.controller;

import com.attendance.dao.DashboardDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        DashboardDAO dao = new DashboardDAO();

        request.setAttribute("totalStudents", dao.getTotalStudents());
        request.setAttribute("presentToday", dao.getPresentToday());
        request.setAttribute("absentToday", dao.getAbsentToday());

        request.getRequestDispatcher("dashboard.jsp")
                .forward(request, response);
    }
}