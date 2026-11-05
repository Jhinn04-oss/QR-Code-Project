package com.attendance.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        if (url == null || url.isBlank()
                || user == null || user.isBlank()
                || password == null || password.isBlank()) {
            System.err.println(
                "Database configuration is missing. Check DB_URL, DB_USER, and DB_PASSWORD."
            );
            return null;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Could not connect to the database:");
            e.printStackTrace();
            return null;
        }
    }
}
