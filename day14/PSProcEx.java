package com.htc.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class PSProcEx {

    public static void main(String[] args) {
      Connection conn = null;
      try {                  
        MyDataSource ds = new MyDataSource("postgres");  
        conn = ds.getConnection();
     CallableStatement cstmt = 
             conn.prepareCall("{? = call show_name(?)}");
        cstmt.setInt(2,  7782);
        cstmt.registerOutParameter(1,  java.sql.Types.VARCHAR);
        cstmt.executeUpdate();
        System.out.println("Employee name is:"+cstmt.getString(1));
        
        cstmt = conn.prepareCall("{call dept_info(?,?,?,?,?)}");
        cstmt.setInt(1,  20);
        cstmt.registerOutParameter(2,  java.sql.Types.NUMERIC);
        cstmt.registerOutParameter(3,  java.sql.Types.NUMERIC);
        cstmt.registerOutParameter(4,  java.sql.Types.NUMERIC);
        cstmt.registerOutParameter(5,  java.sql.Types.NUMERIC);
        cstmt.executeUpdate();
        System.out.println("Tot Salary:"+cstmt.getBigDecimal(2));
        System.out.println("Max Salary:"+cstmt.getBigDecimal(3));
        System.out.println("Min Salary:"+cstmt.getBigDecimal(4));
        System.out.println("Avg Salary:"+cstmt.getBigDecimal(5));   
        
        
      }catch(Exception ex){
        ex.printStackTrace();  
      }
      finally {
          try{
            conn.close();    
          }catch(SQLException ex){
            ex.printStackTrace();  
          }
      }
    }

}
