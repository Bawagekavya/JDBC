package com.xwork.jdbc.runner;

import java.sql.*;

public class RetriveRunner {
    
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
            String query ="select * from college_info";
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            System.out.println("College Id :" + resultSet.getInt(1)+
                               "College name :"+ resultSet.getString(1) +
                               "College dept :" +resultSet.getString(1));


            resultSet.next();
            System.out.println("College Id:" + resultSet.getInt(1));

            resultSet.next();
            System.out.println("College Id:" + resultSet.getInt(1));


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
