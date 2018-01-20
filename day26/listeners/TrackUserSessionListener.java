package com.htc.servlets.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class TrackUserSessionListener
 *
 */
@WebListener
public class TrackUserSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("session created");
    	HttpSession session = event.getSession();
    	ServletContext context = session.getServletContext();
    	int usercount = (Integer) context.getAttribute("usercount");
    	usercount++;
    	context.setAttribute("usercount", usercount);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("session created");
    	HttpSession session = event.getSession();
    	ServletContext context = session.getServletContext();
    	int usercount = (Integer) context.getAttribute("usercount");
    	usercount--;
    	context.setAttribute("usercount", usercount);
	}

 
	
}
