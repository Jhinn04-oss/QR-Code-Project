package com.attendance.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // Replace the placeholders below with the credentials from your Aiven dashboard
    private static final String URL = "jdbc:mysql://YOUR_AIVEN_HOST:YOUR_AIVEN_PORT/defaultdb?sslmode=require";
    private static final String USER = "YOUR_AIVEN_USER"; // Usually "avnadmin"
    private static final String PASSWORD = "YOUR_AIVEN_PASSWORD";

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
