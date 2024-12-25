package com.xwork.jdbc.runners;

import java.sql.*;


public class HospitalRunner {

    public static void main(String[] args) {

        Connection connection= null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded succesfully");

            String url = "jdbc:mysql://localhost:3306/Hospital";
            String username = "root";
            String password = "7259958546";
           connection= DriverManager.getConnection(url, username, password);
            System.out.println("Established conncetion succesfully");

            Statement statement = connection.createStatement();
            String insert1= " insert into hospital_info values (1,'Kamreddy hospital ','kavya')";
            String insert2= " insert into hospital_info values (2,'narayan hospital','vinayak')";
            String insert3= " insert into hospital_info values (3,'Basava hospital','vaishnavi')";
            String insert4= " insert into hospital_info values (4,'Manipal hospital','bhavya')";
            String insert5= " insert into hospital_info values (5,'Jaypee hospital','bhagya')";

            statement.addBatch(insert1);
            statement.addBatch(insert2);
            statement.addBatch(insert3);
            statement.addBatch(insert4);
            statement.addBatch(insert5);

            int[] row = statement.executeBatch();
            System.out.println("rows affected :"+ row.length);

        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            System.out.println("JDBc driver not found :" + classNotFoundException.getMessage());
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
