package com.htc.db;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.Scanner;

 


public class JdbcDemo {

 public static void main(String[] args) 
  throws SQLException,ClassNotFoundException {

  Scanner scan = new Scanner(System.in);
  String dbSrc = "",tbl = "";
  MyDataSource ds = null;
  try {

   System.err.println("Enter your DataBase");

   dbSrc = scan.nextLine();
  
   ds = new MyDataSource(dbSrc.toLowerCase());  

   Connection conn = ds.getConnection();
   
   Statement stmt = conn.createStatement();

   System.err.println("Enter your tablename for querying");

   tbl = scan.nextLine();
   
   String sqlStr = "select  *  from " + tbl;

   
   boolean ret = stmt.execute(sqlStr);   

   ResultSet  rs = stmt.getResultSet();

     while(rs.next()) {
       
       System.out.println(rs.getString(1) + 
                       " " + rs.getString(2)); 
                   
     }
   /* $ */
   sqlStr = "update emp set sal = sal+11";
   ret = stmt.execute(sqlStr);   
   System.out.println("No of Rows updated: " + stmt.getUpdateCount());
   /* # won't work here only at $ marked location */  
   while(rs.next()) {
       
       System.out.println(rs.getString(1) + 
                       " " + rs.getString(2)); 
                  
     }
   conn.close();
  }
  catch(Exception e) {
      e.printStackTrace();
  }
 }

}