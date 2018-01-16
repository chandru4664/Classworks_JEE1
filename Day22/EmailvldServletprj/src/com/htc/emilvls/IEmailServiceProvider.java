package com.htc.emilvls;

public interface IEmailServiceProvider {
     public boolean validateEmail(String email) throws InvalidEmailIdException;
}
