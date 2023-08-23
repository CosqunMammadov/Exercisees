package org.example.Exercise_SmallRegistrationApp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static String url = "jdbc:postgresql://localhost:5432/exercise";
    private static String user = "postgres";
    private static String password = "cosu2362";

    private Database(){

    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
//        Class.forName("org.postgresql.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection(url,user,password);
        return connection;
    }
}
