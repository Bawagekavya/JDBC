package com.xwork.jdbc.runner;

import java.sql.*;

public class RetrivessById {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded succesfully");

            String url = "jdbc:mysql://localhost:3306/College";
            String username = "root";
            String password = "7259958546";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Established connection successfully");

            statement = connection.createStatement();
            String findById = " select * from college_info where col_id =4 ";
            ResultSet resultSet = statement.executeQuery(findById);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String collegeName = resultSet.getString(2);
                String collegeDept = resultSet.getString(3);
                System.out.println(id +" " + collegeName + " " + collegeDept);
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());

            }
        }

    }
}
