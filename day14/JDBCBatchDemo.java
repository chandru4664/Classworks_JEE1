package com.htc.db;
import  java.sql.SQLException;
import  java.sql.Connection;
import  java.sql.Statement;
import  java.sql.ResultSet;
import  java.sql.DriverManager;
import  java.sql.BatchUpdateException;

public class JDBCBatchDemo  {

 public static void main(String args[])throws Exception {
  
  if(args.length<2) {
    System.out.println("This program requires two" +
              " arguments one location ," + " other sal increment");
    System.exit(1);
  }
  MyDataSource mds = new MyDataSource("oracle");
  Connection conn = mds.getConnection();     
  Statement stmt = conn.createStatement();
  conn.setAutoCommit(false);
  try {
   stmt.addBatch("insert into dept values(60,'SALES','DENVER')");
   stmt.addBatch("update dept  set LOC='"+args[0]+
                 "'   where deptno=20 ");
   int salIncr = Integer.parseInt(args[1]);
   stmt.addBatch("update emp set sal=sal+"+salIncr+
                "  where deptno=20"); 
   stmt.addBatch("delete from emp where deptno=30");
   int[] it = stmt.executeBatch();
     
  for(int i=0;i<it.length;i++){
    System.out.println("no of rows executed for statement" + i +
                         ": is " + it[i]);
   }
   conn.commit();
  }
  catch(BatchUpdateException bue){
   stmt.clearBatch();
   conn.rollback();
  }
  finally {
   conn.close();
  }

 }

}  