package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class JDBCPreparedStatementDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver"); //load the driver with Connector J driver
        String url = "jdbc:mysql://localhost:3306/mydb";
        String uname = "root";
        String password = "Admin";
        ResultSet resultSet = null;
        Connection con = null;

        String query = "SELECT * FROM mydb.employee";
        String insertQurey = "insert into employee values('8', 'Mohan' ,'USA')";

        try {
            con = DriverManager.getConnection(url,uname,password); //get the connection with Driver manager
            Statement st = con.createStatement();
            int count = st.executeUpdate(insertQurey);
            System.out.println("No of rows affected == " + count);
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (con != null)
                con.close();
        }
    }
}