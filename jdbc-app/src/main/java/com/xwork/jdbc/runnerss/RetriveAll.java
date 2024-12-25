package com.xwork.jdbc.runnerss;

import java.sql.*;

public class RetriveAll {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded succesfully");

            String url = "jdbc:mysql://localhost:3306/Institute";
            String username = "root";
            String password = "7259958546";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Established connection successfully");

            statement = connection.createStatement();
            String query = "select * from institute_info";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int ins_id = resultSet.getInt(1);
                String ins_name = resultSet.getString(2);
                String ins_address = resultSet.getString(3);

                System.out.println("Institute id : " + ins_id + " Institute name :" + ins_name
                        + " Institute address :" + ins_address);
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
