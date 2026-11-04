package com.attendance.controller;

import com.attendance.dao.StudentDAO;
import com.attendance.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        StudentDAO dao = new StudentDAO();

        List<Student> students = dao.getAllStudents();

        request.setAttribute("students", students);

        request.getRequestDispatcher("students.jsp")
                .forward(request, response);
    }
}