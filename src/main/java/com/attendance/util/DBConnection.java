package com.attendance.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {


    private static final String URL = "jdbc:mysql://localhost:3306/attendance_db";
    private static final String USER = "root"; // Usually "avnadmin"
    private static final String PASSWORD = "09919230107_Redy";

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }

    }

}
