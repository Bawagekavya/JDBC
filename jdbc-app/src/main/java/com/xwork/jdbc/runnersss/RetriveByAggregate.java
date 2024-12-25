package com.xwork.jdbc.runnersss;

import java.sql.*;

public class RetriveByAggregate {

    public static void main(String[] args) throws ClassNotFoundException {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");

            String url = "jdbc:mysql://localhost:3306/library";
            String username = "root";
            String password = "7259958546";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Established conncetion successfully");

            statement = connection.createStatement();


            String findById = "Select * from library where library_id = 1";
            ResultSet resultSet = statement.executeQuery(findById);

            while (resultSet.next()) {
                int library_id = resultSet.getInt(1);
                String library_name = resultSet.getString(2);
                String Libraryaddress = resultSet.getString(3);
                int noOfBooks = resultSet.getInt(4);
                String LibraryType = resultSet.getString(5);
                System.out.println(library_id + " " + library_name + " " + Libraryaddress + " " + noOfBooks + " " + LibraryType);


                String count = "select count(*) from library where library_id = 1";
                ResultSet resultSet1 = statement.executeQuery(count);
                resultSet1.next();
                System.out.println("no of libraries located in rajajinagar: " + resultSet1.getInt(1));

                String select = "select count(*) from library where no_of_books > 10000";
                ResultSet resultSet2 = statement.executeQuery(select);
                resultSet2.next();
                System.out.println("libraries having more than 1000 books: " + resultSet2.getInt(1));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

