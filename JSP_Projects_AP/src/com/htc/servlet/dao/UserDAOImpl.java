package com.htc.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.htc.servlet.dto.UserDTO;

public class UserDAOImpl implements UserDAO{


	@Override
	public boolean registerUser(String username, String password, String email, String mobileno) throws SQLException {
		
		Connection con = null;
		boolean status = false;
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/db");
			con = ds.getConnection();

			PreparedStatement pst = con.prepareStatement("insert into users values(?,?,?,?)");
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, email);
			pst.setString(4, mobileno);
			int result = pst.executeUpdate();
			

			if(result>0) 
				status = true;
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			con.close();
		}
		return status;
		
	}

	@Override
	public UserDTO searchUser(String username) throws SQLException {
		Connection con = null;
		UserDTO userDTO = null;
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/db");
			con = ds.getConnection();
			PreparedStatement pst = con.prepareStatement("select username, password, email, mobileno from users where username=?");
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				userDTO = new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
		return userDTO;	
	}

	@Override
	public List<UserDTO> getAllUsers() throws SQLException{
		Connection con = null;
		List<UserDTO> userList = new ArrayList<UserDTO>();
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/db");
			con = ds.getConnection();
			PreparedStatement pst = con.prepareStatement("select username, password, email, mobileno from users");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				userList.add(new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
		return userList;	
	}
	
}
