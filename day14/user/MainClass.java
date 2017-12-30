package com.htc.jdbc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
    
		DBConnector dbc=new DBConnector();
		Connection con=dbc.getConnection();
		UserDAO obj=new UserDAO(con);
		User user=new User("htcc","htc123","troy","htcinc.com");
		System.out.println(obj.registerUser(user));
		
		
	}

}