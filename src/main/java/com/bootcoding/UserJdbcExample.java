package com.bootcoding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserJdbcExample {
    public static void main(String[] args) {
        try{
            //load jdbc driver
            Class.forName("org.postgresql.Driver");
           //jdbc connection
            Connection conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","user");
            //query database using statement
            Statement stmt =conn.createStatement();
   //Exexute Query & Get REsult set
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
            //Extract result
            while(rs.next()){
                int custId=rs.getInt("order_id");
               // second way int custId2= rs.getInt(1);

                int purchase= rs.getInt("purchase_amount");
                String date = rs.getString("order_date");
                int customer_id= rs.getInt("customer_id");
                //int salesman_id = rs.getInt("salesman_id");

                System.out.println("Id =" + custId);
                System.out.println(" date =" + date);

            }

           // System.out.println(rs);

            conn.close();




        } catch (Exception ex) {
            ex.printStackTrace();

        }
        }
    }
