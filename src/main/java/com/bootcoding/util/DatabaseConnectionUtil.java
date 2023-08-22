package com.bootcoding.util;


import java.sql.Connection;
        import java.sql.DriverManager;

public class DatabaseConnectionUtil {

    public static Connection getConnection(){
        try{
            // 1. Load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // 2. Get Database Connection Object
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "postgres");
            return conn;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}