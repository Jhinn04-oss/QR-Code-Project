package com.attendance.controller;

import com.attendance.dao.AttendanceDAO;
import com.attendance.model.Attendance;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/attendanceHistory")
public class AttendanceHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        AttendanceDAO dao = new AttendanceDAO();

        List<Attendance> attendanceList = dao.getAttendanceHistory();

        request.setAttribute("attendanceList", attendanceList);

        request.getRequestDispatcher("attendanceHistory.jsp")
                .forward(request, response);

    }
}