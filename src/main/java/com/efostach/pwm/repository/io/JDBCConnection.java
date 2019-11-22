package com.efostach.pwm.repository.io;

import java.sql.*;

public class JDBCConnection {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/company_teams_structure";
    private static final String USER = "root";
    private static final String PASSWORD = "Tktyf+7*%";

    private static Connection connection = null;

    private JDBCConnection() {

    }

    public static synchronized Connection getConnection() throws Exception {
        if (connection == null) {
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            } catch (Exception e) {
                throw new Exception("Connection failed.");
            }
        }
        return connection;
    }
}