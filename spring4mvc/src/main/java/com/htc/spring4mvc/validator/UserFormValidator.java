package com.htc.spring4mvc.validator;

import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.htc.spring4mvc.model.User;

public class UserFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> cl) {
		// TODO Auto-generated method stub
		return User.class.equals(cl);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "errors.firstName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "errors.lastName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "errors.password.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "detail", "errors.detail.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthdate", "errors.birthdate.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "errors.gender.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "errors.country.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneno", "errors.phoneno.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "errors.email.empty");
		
		if(user.getPassword()!=null && !(Pattern.matches("[0-9a-zA-Z]{8,15}", user.getPassword())))
			errors.rejectValue("password", "errors.password", new Object[] {new Integer(8), new Integer(15)}, "Default Message");
		
		if(user.getPhoneno()!=null && !(Pattern.matches("[0-9]{10}", user.getPhoneno())))
			errors.rejectValue("phoneno", "errors.phoneno");
			
		if(user.getBirthdate()!=null && user.getBirthdate().compareTo(new Date()) >0) {
			errors.rejectValue("birthdate", "errors.birthdate");
		}
	}
	
}
