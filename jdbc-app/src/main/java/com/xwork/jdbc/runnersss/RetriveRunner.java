package com.xwork.jdbc.runnersss;

import java.sql.*;

public class RetriveRunner {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded succesfully");

            String url = "jdbc:mysql://localhost:3306/Hospital";
            String username = "root";
            String password = "7259958546";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Established connection successfully");

            statement = connection.createStatement();
            String query = "select * from hospital_info";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int hos_id = resultSet.getInt(1);
                String hos_name = resultSet.getString(2);
                String pat_name = resultSet.getString(3);

                System.out.println("Hospital id : " + hos_id + " Hospital name :" + hos_name
                        + " Patient name :" + pat_name);
            }


        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());

            }
        }

    }
}

