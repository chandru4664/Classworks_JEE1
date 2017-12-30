package com.htc.db;

import java.util.Scanner;

import java.io.IOException;
import  java.sql.SQLException;
import  java.sql.Connection;
import  java.sql.CallableStatement;

import  java.sql.Statement;

public class CallableBatch {

  public static void main(String[] args)
   throws SQLException,IOException,ClassNotFoundException {
   Connection con;
   CallableStatement cstmt;
   
   Scanner in = 
       new Scanner(System.in);
   
   MyDataSource ds = new MyDataSource("postgres");
   con = ds.getConnection();
 
   cstmt = con.prepareCall("{ call add_jdbc_samp(?,?,?,?)}");
   //DEMONSTRATION OF BATCH EXECUTIONS
   String en = "";
   double sa = 0.0;
   int eno,dno = 0;

   for(int i=0;i<2;i++) {        
    System.out.println("Enter employee number to insert");  
    en = in.nextLine();        
    eno = Integer.parseInt(en);
    cstmt.setInt(1,eno);
       
    System.out.println("Enter employee name to insert");  
    en = in.nextLine();        
    cstmt.setString(2,en);
      
    System.out.println("Enter employee salary to insert");  
    String saStr = in.nextLine();  
    sa = Double.parseDouble(saStr);
    cstmt.setDouble(3,sa);
      
    System.out.println("Enter dept number to insert");  
    String dnoStr = in.nextLine();        
    dno = Integer.parseInt(dnoStr);
    cstmt.setInt(4,dno);      
    cstmt.addBatch();
  }
  int[] results = cstmt.executeBatch();
  for(int i=0;i<2;i++){
   System.out.println("affected rows "+results[i]);
  }
  con.close();
 }

}