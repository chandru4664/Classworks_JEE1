package com.htc.jdbc;


import java.sql.*;

public class UserDAO {
	
	Connection con;
	public UserDAO(Connection con) {
		super();
		this.con = con;
	}
	
	
	public boolean registerUser(User user) throws SQLException
	{
		boolean result1=false;
		String uname=user.getUserName();
		String upassword=user.getPassword();
		String uaddress=user.getUserAddress();
		String uemail=user.getEmail();
		
		CallableStatement statement=con.prepareCall("{call insertuser(?,?,?,?)}");
		statement.setString(1, uname);
		statement.setString(2, upassword);
		statement.setString(3, uaddress);
		statement.setString(4, uemail);
	
		int insertCount=statement.executeUpdate();// actual execution happens 
		System.out.println(insertCount);
		if(insertCount==0)		
			result1=true;
		
		return result1;
	}

}
