package com.attendance.dao;

import com.attendance.model.Attendance;
import com.attendance.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    // Check if attendance already exists today
    public boolean hasAttendanceToday(String studentId) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM attendance WHERE student_id=? AND attendance_date=CURDATE()";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, studentId);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Save attendance
    public boolean saveAttendance(String studentId) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO attendance(student_id, attendance_date, attendance_time, status) VALUES (?, CURDATE(), CURTIME(), 'Present')";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, studentId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Attendance History
    public List<Attendance> getAttendanceHistory() {

        List<Attendance> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "SELECT a.*, s.full_name, s.strand, s.section " +
                            "FROM attendance a " +
                            "JOIN students s ON a.student_id = s.student_id " +
                            "ORDER BY a.attendance_date DESC, a.attendance_time DESC";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Attendance attendance = new Attendance();

                attendance.setId(rs.getInt("id"));
                attendance.setStudentId(rs.getString("student_id"));
                attendance.setFullName(rs.getString("full_name"));
                attendance.setStrand(rs.getString("strand"));
                attendance.setSection(rs.getString("section"));
                attendance.setAttendanceDate(rs.getString("attendance_date"));
                attendance.setAttendanceTime(rs.getString("attendance_time"));
                attendance.setStatus(rs.getString("status"));

                list.add(attendance);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}