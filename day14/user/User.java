package com.htc.jdbc;

public class User {
private String userName;
private String password;
private String userAddress;
private String email;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUserAddress() {
	return userAddress;
}
public void setUserAddress(String userAddress) {
	this.userAddress = userAddress;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public User(String userName, String password, String userAddress, String email) {
	super();
	this.userName = userName;
	this.password = password;
	this.userAddress = userAddress;
	this.email = email;
}
@Override
public String toString() {
	return "User [userName=" + userName + ", password=" + password + ", userAddress=" + userAddress + ", email=" + email
			+ "]";
}



}
