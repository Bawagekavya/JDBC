package com.xwork.jdbc.runner;

import java.sql.*;

public class CollegeRunner {

    public static void main(String[] args) {

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded sucessfully");

            String url = "jdbc:mysql://localhost:3306/College";
            String username = "root";
            String password = "7259958546";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Established connection successfully");

            Statement statement = connection.createStatement();
            String insert = "insert into college_info values(5,'sharanabasava college of engineering','ME')";

            int row = statement.executeUpdate(insert);
            System.out.println("Rows affected: " + row);

        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            System.out.println("JDBC driver not found :" + classNotFoundException.getMessage());
        }finally {
            try {
                connection.close();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }

    }
}

