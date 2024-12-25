package com.xwork.jdbc.runners;

import java.sql.*;

public class RetrivessByName {

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
            String findByName = " select * from hospital_info where pat_name ='kavya' ";
            ResultSet resultSet = statement.executeQuery(findByName);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String HospitalName = resultSet.getString(2);
                String patientName = resultSet.getString(3);
                System.out.println(id +" " + HospitalName + " " + patientName);
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
