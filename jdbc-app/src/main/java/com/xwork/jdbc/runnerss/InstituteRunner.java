package com.xwork.jdbc.runnerss;

import java.sql.*;

public class InstituteRunner {

    public static void main(String[] args) {

        Connection connection = null;;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded succesfully");

            String url = "jdbc:mysql://localhost:3306/Institute";
            String username = "root";
            String password = "7259958546";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Established connection successfully");

            Statement statement = connection.createStatement();
            String insert = " insert into institute_info values (0,'Educadd','Kengeri')";

            int row = statement.executeUpdate(insert);
            System.out.println("rows affected :"+ row);

        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            System.out.println("JDBC driver not found :" + classNotFoundException.getMessage());
        }finally {
            try {
                connection.close();
            }catch (SQLException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}

