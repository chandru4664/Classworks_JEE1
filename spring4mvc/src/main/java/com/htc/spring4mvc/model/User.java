package com.htc.spring4mvc.model;

import java.util.Date;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	@NotEmpty(message="{errors.firstName.empty}")
	private String firstName;
	
	@NotEmpty(message="LastName cannot be blank")
	private String lastName;
	
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})", message = "Password must contain 6-20 characters. One uppercase/lowercase/digit/special character")
	private String password;
	
	@Size(min=5, max=100, message="Details should between 5 to 100 characters")
	private String detail;
	
	@Past(message="Birthdate must be a past date")
	private Date birthdate;
	
	private String gender;
	private String country;
	private String hobbies;
	
	@NotEmpty(message="{errors.email.empty}")
	@Email(message="Should be a valid email id")
	private String email;
	
	@Pattern(regexp="^[789]\\d{9}$", message="Should be a valid mobile no.")
	private String phoneno;
	
	public User(){}

	public User(String firstName, String lastName, String password, String detail, Date birthdate, String gender,
			String country, String hobbies, String phoneno, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.detail = detail;
		this.birthdate = birthdate;
		this.gender = gender;
		this.country = country;
		this.hobbies = hobbies;
		this.email = email;
		this.phoneno = phoneno;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", detail="
				+ detail + ", birthdate=" + birthdate + ", gender=" + gender + ", country=" + country + ", hobbies="
				+ hobbies + ", email=" + email + ", phoneno=" + phoneno + "]";
	}

	
}
