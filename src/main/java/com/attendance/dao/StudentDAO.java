
package com.attendance.dao;

import com.attendance.model.Student;
import com.attendance.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Register Student
    public boolean registerStudent(Student student) {

        String sql = "INSERT INTO students " +
                "(student_id, full_name, strand, section, photo, qr_code) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection()) {

            if (con == null) {
                System.out.println("ERROR: Database connection is NULL.");
                return false;
            }

            try (PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, student.getStudentId());
                ps.setString(2, student.getFullName());
                ps.setString(3, student.getStrand());
                ps.setString(4, student.getSection());
                ps.setString(5, student.getPhoto());
                ps.setString(6, student.getQrCode());

                int rows = ps.executeUpdate();

                System.out.println("Registration affected rows: " + rows);

                return rows > 0;
            }

        } catch (SQLException e) {

            System.out.println("========== DATABASE ERROR ==========");
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());
            e.printStackTrace();
            System.out.println("====================================");

            return false;
        }
    }

    // Get All Students
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students ORDER BY student_id";

        try (Connection con = DBConnection.getConnection()) {

            if (con == null) {
                System.out.println("Database connection is NULL.");
                return students;
            }

            try (PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Student student = new Student();

                    student.setStudentId(rs.getString("student_id"));
                    student.setFullName(rs.getString("full_name"));
                    student.setStrand(rs.getString("strand"));
                    student.setSection(rs.getString("section"));
                    student.setPhoto(rs.getString("photo"));
                    student.setQrCode(rs.getString("qr_code"));

                    students.add(student);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    // Get One Student by Student ID
    public Student getStudentById(String studentId) {

        Student student = null;

        String sql = "SELECT * FROM students WHERE student_id = ?";

        try (Connection con = DBConnection.getConnection()) {

            if (con == null) {
                System.out.println("Database connection is NULL.");
                return null;
            }

            try (PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, studentId);

                try (ResultSet rs = ps.executeQuery()) {

                    if (rs.next()) {

                        student = new Student();

                        student.setStudentId(rs.getString("student_id"));
                        student.setFullName(rs.getString("full_name"));
                        student.setStrand(rs.getString("strand"));
                        student.setSection(rs.getString("section"));
                        student.setPhoto(rs.getString("photo"));
                        student.setQrCode(rs.getString("qr_code"));
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }
}
