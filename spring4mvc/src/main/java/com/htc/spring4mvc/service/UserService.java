package com.htc.spring4mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.spring4mvc.dao.UserDAO;
import com.htc.spring4mvc.model.User;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public boolean registerUser(User user) {
		return userDAO.registerUser(user);
	}
	public boolean validateUser(String email, String password) {
		return userDAO.validateUser(email, password);
	}
	
	//@PreAuthorize("hasRole('ROLE_EDITOR')")
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
	}

	public boolean updateUser(User user) {
		return userDAO.updateUser(user);
	}
	
	public boolean deleteUser(String email) {
		return userDAO.deleteUser(email);
	}
	
	public User findUser(String email) {
		return userDAO.findUser(email);
	}
}
