
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
                    "Database configuration missing. Check DB_URL, DB_USER, DB_PASSWORD."
            );

            return null;
        }

        try {
            return DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {

            System.err.println("Database connection failed:");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();

            return null;
        }
    }
}
