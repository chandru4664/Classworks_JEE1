package com.htc.db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

 

import java.sql.PreparedStatement;

public class MultiQuery {
  
  public void execute(PreparedStatement pstmt, int eno)
   throws SQLException   {
    pstmt.setInt(1,eno);
    ResultSet rs = pstmt.executeQuery();
    if(rs.next()) {
       System.out.println(rs.getString(1));
    }
  }
  
  public static void main(String[]  args)throws SQLException {
    PreparedStatement pstmt = null;
    MyDataSource mds = new MyDataSource("postgres");
    Connection conn = mds.getConnection();       
     
    pstmt = conn.prepareStatement("select ename from emp " +
                                " where empno=?");
    
    MultiQuery mq = new MultiQuery(); 
    mq.execute(pstmt,7654);
    mq.execute(pstmt,7698);
    mq.execute(pstmt,7788);
    conn.close();
  }

}  