package com.bl.employee;

import java.sql.*;


public class EmployeeService {
    public static void main(String[] args) {
        try{
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
}
