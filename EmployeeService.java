package com.bl.employee;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class EmployeeService {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/emp_services?user=root";
        String userName = "root";
        String password = "root@11";
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        listDrivers();
        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            System.out.println("Connection is Successful" + connection);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" " + driverClass.getClass().getName());
        }
    }
}
