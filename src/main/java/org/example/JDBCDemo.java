package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class JDBCDemo{
    public static void main(String[] args)throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver"); //load the driver with Connector J driver
        String url = "jdbc:mysql://localhost:3306/mydb";
        String uname="root";
        String password ="Admin";
        Connection con =DriverManager.getConnection(url,uname,password); //get the connection with Driver manager
        Statement st =con.createStatement();
        ResultSet resultSet =st.executeQuery("select * from employee");
        while(resultSet.next()){
            System.out.println("Employee Id : "+ resultSet.getInt(1));
            System.out.println("Employee Name : "+ resultSet.getString(2));
            System.out.println("Employee Address : "+ resultSet.getString(3));

        }
    }
}
