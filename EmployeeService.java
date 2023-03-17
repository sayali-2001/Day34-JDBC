package com.bl.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;


public class EmployeeService {
    public void updateQuery(){
        try{
            System.out.println("Update the salary ");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_services","root","root@11");
            Statement stmt = con.createStatement();
            String q = "update employee set salary=? where name=?";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter New Salary : ");
            double d = Double.parseDouble(br.readLine());

            System.out.println("Enter Name : ");
            String n = br.readLine();

            PreparedStatement psmt = con.prepareStatement(q);
            psmt.setDouble(1,d);
            psmt.setString(2,n);
            psmt.executeUpdate();
            System.out.println("Updated ");


        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void retriveData(){
        try{
            System.out.println("Retrieve the Employee Payroll from the Database");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_services","root","root@11");
            Statement stmt = con.createStatement();
            String query3 = "select * from employee ";
            ResultSet res = stmt.executeQuery(query3);
            while (res.next()){
                System.out.println("Id: "+res.getInt("id")+ " "+" Name: "
                        +res.getString("name")+" "
                        +" Salary: "+res.getDouble("salary")+" "
                        +" StartDate : " +res.getDate("startdate")+" "
                        +" Department : "+res.getString("dept")+" "
                        +" PhoneNumber : "+res.getBigDecimal("phoneNumber"));
            }

//id, name, salary, startdate, dept, phoneNumber
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void retriveDataByName(){
        try{
            System.out.println("Retrieve the Employee Payroll from the Database");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_services","root","root@11");

            String query = "select * from employee where name = ? ";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setString(1, "Terisa");

            ResultSet res = psmt.executeQuery(query);
            while (res.next()){
                System.out.println("Id: "+res.getInt("id")+ " "+" Name: "
                        +res.getString("name")+" "
                        +" Salary: "+res.getDouble("salary")+" "
                        +" StartDate : " +res.getDate("startdate")+" "
                        +" Department : "+res.getString("dept")+" "
                        +" PhoneNumber : "+res.getBigDecimal("phoneNumber"));
            }

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void particularDateRange(){
        try {
            System.out.println("Retrieve the Employee Payroll from the Database");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_services","root","root@11");
            String query = "select * from employee where startdate between ? and ? ";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,"2018-01-03" );
            preparedStatement.setString(2, "2020-11-06");
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                System.out.println("Id: "+res.getInt("id")+ " "+" Name: "
                        +res.getString("name")+" "
                        +" Salary: "+res.getDouble("salary")+" "
                        +" StartDate : " +res.getDate("startdate")+" "
                        +" Department : "+res.getString("dept")+" "
                        +" PhoneNumber : "+res.getBigDecimal("phoneNumber"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {
        EmployeeService obj = new EmployeeService();
        obj.retriveData();
//        obj.updateQuery();
        obj.retriveDataByName();
//        obj.particularDateRange();
    }
}
