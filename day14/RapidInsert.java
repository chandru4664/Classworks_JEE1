package com.htc.db;
import java.util.Scanner;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

class ItemInsert {
 
  Connection con;
  Statement stmt;
  PreparedStatement pstmt;
  ResultSet rs;
  int result;
  
  
 public ItemInsert() {
   
  try  {
   
   con = new MyDataSource("postgres").getConnection();
    
   String sql = 
    "create table myItem(id integer,name varchar(15),price decimal(10,2))";
   pstmt = con.prepareStatement(sql);

   result = pstmt.executeUpdate();     
   System.out.println("table created");
   pstmt = con.prepareStatement("insert into myItem values(?,?,?)");
  }catch(Exception e) {        
   System.out.println(e.toString());
   System.exit(1);
  }
 }

 public boolean validateId(int num)throws SQLException {
  stmt = con.createStatement();
  rs = stmt.executeQuery("select count(1) from myItem where id="+num);
  if(rs.next()) {
      result = rs.getInt(1);
  }
   if(result == 0){
     return true;
   }
   else {
    return false;
   }
  }
  
  public void insertRecord(int id, String name, double cost)
   throws SQLException {
   
   pstmt.clearParameters();  
   pstmt.setInt(1, id);
   pstmt.setString(2, name);
   pstmt.setDouble(3, cost);
   result = pstmt.executeUpdate();
  }

  public void closeCon() {
    try {
      this.con.close();
    }catch(SQLException sqe) {
    }
  }
 
 }
 public class RapidInsert {

 public static void main(String[] args)
   throws IOException,SQLException,ClassNotFoundException {
  int no;
  double cost;
  String numStr,costStr,nameStr;
  ItemInsert it = new ItemInsert();
  Scanner in = new Scanner(System.in);
  while(true) {
   System.out.println("Enter item's id or '0' for exit");  
   numStr = in.nextLine();
   no = Integer.parseInt(numStr);
  
   if(no == 0) {
    it.closeCon(); 
    break;
   }
   if(it.validateId(no)) {
    System.out.println("Enter item's name");
    nameStr = in.nextLine();

    System.out.println("Enter item's price");
    costStr = in.nextLine();
    cost= Double.parseDouble(costStr);

    it.insertRecord(no,nameStr,cost);
   } 
   else {
    System.out.println("This id already exists");
   }
  }  
 }

}   
     
  