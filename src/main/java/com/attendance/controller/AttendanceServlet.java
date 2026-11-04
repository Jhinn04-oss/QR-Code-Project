package com.attendance.controller;

import com.attendance.dao.AttendanceDAO;
import com.attendance.dao.StudentDAO;
import com.attendance.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/attendance")
public class AttendanceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String studentId = request.getParameter("student_id");

        AttendanceDAO attendanceDAO = new AttendanceDAO();
        StudentDAO studentDAO = new StudentDAO();

        Student student = studentDAO.getStudentById(studentId);

        request.setAttribute("student", student);

        if (attendanceDAO.hasAttendanceToday(studentId)) {

            request.setAttribute("message",
                    "Attendance Already Recorded Today!");

        } else {

            boolean success = attendanceDAO.saveAttendance(studentId);

            if (success) {

                request.setAttribute("message",
                        "Attendance Recorded Successfully!");

            } else {

                request.setAttribute("message",
                        "Failed to Record Attendance!");

            }
        }

        request.getRequestDispatcher("attendance.jsp")
                .forward(request, response);
    }
}