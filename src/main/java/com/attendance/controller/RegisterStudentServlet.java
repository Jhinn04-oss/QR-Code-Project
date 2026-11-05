package com.attendance.controller;

import com.attendance.util.QRGenerator;
import com.attendance.dao.StudentDAO;
import com.attendance.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;

@WebServlet("/RegisterStudentServlet")
@MultipartConfig
public class RegisterStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String studentId = request.getParameter("studentID");
        String fullName = request.getParameter("fullName");
        String strand = request.getParameter("strand");
        String section = request.getParameter("section");

        Part filePart = request.getPart("photo");

        String fileName = filePart.getSubmittedFileName();

        String uploadPath =
                getServletContext().getRealPath("") +
                        File.separator +
                        "images";

        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        filePart.write(uploadPath + File.separator + fileName);

        Student student = new Student();

        student.setStudentId(studentId);
        student.setFullName(fullName);
        student.setStrand(strand);
        student.setSection(section);
        student.setPhoto("images/" + fileName);

        String qrFile = studentId + ".png";

        String qrPath =
                getServletContext().getRealPath("")
                        + File.separator
                        + "qrcodes"
                        + File.separator
                        + qrFile;

        String qrText =
                "https://premium-underfed-dingbat.ngrok-free.dev/AttendanceSystem/attendance?student_id="
                        + studentId;

        System.out.println("QR TEXT = " + qrText);

        File qrDir = new File(
                getServletContext().getRealPath("") +
                        File.separator + "qrcodes"
        );

        if (!qrDir.exists()) {
            qrDir.mkdirs();
        }

        QRGenerator.generateQRCode(qrText, qrPath);

        student.setQrCode("qrcodes/" + qrFile);

        StudentDAO dao = new StudentDAO();

        if (dao.registerStudent(student)) {
            response.sendRedirect("registration.jsp?success=1");
        } else {
            response.sendRedirect("registration.jsp?error=1");
        }

    }

}