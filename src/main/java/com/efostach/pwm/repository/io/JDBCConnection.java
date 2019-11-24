package com.efostach.pwm.repository.io;

import com.efostach.pwm.repository.exceptions.ConnectionFailException;

import java.sql.*;

public class JDBCConnection {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/company_projects_structure?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Tktyf+7*%";

    private static Connection connection = null;

    private JDBCConnection() {

    }

    public static synchronized Connection getConnection() throws ConnectionFailException {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ConnectionFailException("Connection failed.");
            }
        }
        return connection;
    }
}