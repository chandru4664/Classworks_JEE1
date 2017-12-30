package com.htc.db;
/* the query should not use select * from ... instead should mention the column names specifically else read only OracleResultSet will be resulted */

import  java.sql.SQLException;
import  java.sql.Connection;
import  java.sql.Statement;
import  java.sql.ResultSet;
import  java.sql.DriverManager;

class Jdbc2Cl {
   Connection conn;
   Statement stmt;
   ResultSet rs;  

 public Jdbc2Cl() {
  try {   
   conn = new MyDataSource("postgres").getConnection();
  }
  catch(Exception e) {
   System.out.println("Error:"+e);
   System.exit(1);
  }
 }

 public void printRec(ResultSet rs)throws SQLException {
   System.out.printf("%6s%12s%15s%20s%8s%n",
            "EmpNo","EmpName","Salary","Hiredate","DeptNo",null);
   while(rs.next()) {
    int eno = rs.getInt("empno");
    int dno = rs.getInt("deptno");
    double sa = rs.getDouble("sal");
    String dt = rs.getString("hiredate");
    String na = rs.getString("ename");
    System.out.printf("%6d%12s%14.1f%20s%8d%n",
          eno,na,sa,dt,dno,null);
   }
  } 
 
 public void execute()throws SQLException {  
  
  stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);

  rs = stmt.executeQuery("select empno, ename, sal," +
                          "hiredate, deptno from emp");

  rs.last();
  int rowscnt = rs.getRow();
  System.out.println("No of rows:" + rowscnt + "\n");

  rs.beforeFirst();
  System.out.println("printing Retrieved records\n");
  printRec(rs);

  rs.absolute(2);
  System.out.println("\nHiredate at rec 2 is:"+
               rs.getDate("hiredate") + "\n");
   
  java.sql.Date d1 = 
           java.sql.Date.valueOf("2008-02-11");

  rs.moveToInsertRow();
  rs.updateInt("empno",8000);
  rs.updateString("ename","sunder"); 
  rs.updateDouble("sal",2850.0);
  rs.updateDate("hiredate",d1);    
  rs.updateInt("deptno",20);
  rs.insertRow();
  
  System.out.println("row inserted\n");

  rs.absolute(3);
  System.out.println("Ename at row is:"+rs.getString("ename"));

  rs.updateString("ename","Venkat");
  rs.updateRow();
  System.out.println("\nrow updated\n");
  rs.absolute(9);
  rs.deleteRow();
  System.out.println("\nrow deleted\n"); 
  System.out.println("\nPrinting records now\n"); 
  rs.beforeFirst();
  
  printRec(rs);

  conn.close();
 }

}

public class Jdbc2Trial {
 
 public static void main(String[] args)throws SQLException {
  Jdbc2Cl j2 = new Jdbc2Cl();     
  j2.execute();
 }

}