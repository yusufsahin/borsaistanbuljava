package com.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection connection;

    public static Connection getConnection()
    {
        if(connection==null)
        {
            try {
                connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/crmData", "postgres", "Pass@12345");
            }catch (SQLException e)
            {
                throw  new RuntimeException(e);
            }
        }
        return connection;
    }
}
