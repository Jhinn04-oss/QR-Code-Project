package com.attendance.dao;

import com.attendance.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DashboardDAO {

    public int getTotalStudents() {

        return getCount("SELECT COUNT(*) FROM students");

    }

    public int getPresentToday() {

        return getCount("SELECT COUNT(DISTINCT student_id) FROM attendance WHERE attendance_date = CURDATE()");

    }

    public int getAbsentToday() {

        return getTotalStudents() - getPresentToday();

    }

    private int getCount(String sql) {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getInt(1);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return 0;
    }
}