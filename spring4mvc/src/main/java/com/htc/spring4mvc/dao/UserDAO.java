package com.htc.spring4mvc.dao;

import java.util.List;

import com.htc.spring4mvc.model.User;
 
public interface UserDAO {

	public boolean registerUser(User user);
	public boolean validateUser(String email, String password);
	public List<User> getAllUsers();
	
	public User findUser(String email);
	public boolean deleteUser(String email);
	public boolean updateUser(User user);
}
