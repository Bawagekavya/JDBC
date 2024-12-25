package com.xwork.jdbcapp.runner;

import java.sql.*;

public class EmployeeRunner {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded succesfully");

            String url = "jdbc:mysql://localhost:3306/Employee";
            String username = "root";
            String password = "7259958546";
            DriverManager.getConnection(url, username, password);
            System.out.println("Connection established succesfully");
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            System.out.println("Jdbc driver not found :" + classNotFoundException.getMessage());
        }
    }
}
