package com.htc.servlet.dao;

import java.sql.SQLException;
import java.util.List;

import com.htc.servlet.dto.UserDTO;

public interface UserDAO {

	public boolean registerUser(String username, String password, String email, String mobileno) throws SQLException;
	public UserDTO searchUser(String username) throws SQLException;
	public List<UserDTO> getAllUsers() throws SQLException;
}
