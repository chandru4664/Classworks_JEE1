package com.htc.emilvls;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailServiceProviderImpl implements IEmailServiceProvider{

	@Override
	public boolean validateEmail(String email) throws InvalidEmailIdException {
		boolean valid =false;
		System.out.println("Inside Email");
		if(! Pattern.matches("[a-zA-Z0-9]{6,10}", email))
			throw new InvalidEmailIdException();
		else
			valid = true;
		
		return valid;
	}

}
