package com.xwork.jdbc.runnersss;

import java.sql.*;

public class LibraryRunner {

    public static void main(String[] args) {
        Connection connection = null;;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");

            String url = "jdbc:mysql://localhost:3306/library";
            String username = "root";
            String password = "7259958546";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Established conncetion successfully");

            Statement statement = connection.createStatement();
            String query = "insert into library_info values(1,'kavya','Rajajinagar',5000,'public')";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String LibraryName = resultSet.getString(2);
                String Libraryaddress = resultSet.getString(3);
                int noOfBooks = resultSet.getInt(4);
                String LibraryType = resultSet.getString(5);
                System.out.println(id + " " + LibraryName + " " + Libraryaddress + " " + noOfBooks + " " + LibraryType);
            }


        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            System.out.println( classNotFoundException.getMessage());
        } finally {

            try {
               connection.close();
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}