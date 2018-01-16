package com.htc.emilvls;

public class InvalidEmailIdException extends Exception{
	final String errorMessage="Invalid Email ";
	public String getErrorMessage() {
		return errorMessage;
	}

}
