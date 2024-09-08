package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver"); //load the driver with Connector J driver
        String url = "jdbc:mysql://localhost:3306/mydb";
        String uname = "root";
        String password = "Admin";
        ResultSet resultSet = null;
        Connection con = null;

       // String query = "SELECT * FROM mydb.employee";
        String insertQurey = "insert into employee values('9','subham','Pune')";

        try {
            con = DriverManager.getConnection(url, uname, password); //get the connection with Driver manager
            Statement st = con.createStatement();
            boolean execute = st.execute(insertQurey);
            if(execute) {
                ResultSet rs = st.getResultSet();
                rs.next();
                System.out.println(rs.getString(2));

            }else{
                System.out.println("No of rows updated ==" +st.getUpdateCount());
            }

            /*if (execute) {
                ResultSet rs = st.executeQuery(insertQurey);
                rs.next();
                System.out.println(rs.getString(2));
            }*/
           } finally {
            if (resultSet != null)
                resultSet.close();
            if (con != null)
                con.close();
        }
    }
}

