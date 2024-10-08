package org.example;
//import java.sql.DriverManager;
import java.sql.*;
import java.util.*;

public class TransactionDemoWithCommitAndRollBack {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver"); //load the driver with Connector J driver
        String url = "jdbc:mysql://localhost:3306/mydb";
        String uname = "root";
        String password = "Admin";
        Connection con = DriverManager.getConnection(url,uname,password); //get the connection with Driver manager
        Statement st = con.createStatement();
        System.out.println("Data before Transaction");
        ResultSet rs =st.executeQuery("select * from accounts");
        while(rs.next()){
            System.out.println( rs.getString(2)+"..."+rs.getInt(3));
        }
        System.out.println("transaction Begins...");
        System.out.println(".....................");
        con.setAutoCommit(false);
        st.executeUpdate("update accounts set balance = balance-2000 where user ='Milan'" );
        st.executeUpdate("update accounts set balance = balance+2000 where user ='Anushka'" );
        System.out.println("can u please confirm this transaction of 2000...[yes|No]");
        Scanner sc= new Scanner(System.in);
        String option =sc.next();
        if(option.equalsIgnoreCase("yes")){
            con.commit();
            System.out.println("Transaction commited");
        }
        else{
            con.rollback();
            System.out.println("transaction Rolled Back");
        }
        System.out.println("Data After Transaction");
        System.out.println("....................");
        ResultSet rs1 =st.executeQuery("select * from accounts");
        while(rs1.next()){
            System.out.println( rs1.getString(2)+"..."+rs1.getInt(3));
        }
         con.close();
    }
}