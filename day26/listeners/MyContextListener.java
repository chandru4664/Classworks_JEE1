package com.htc.servlets.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * Application Lifecycle Listener implementation class MyContextListener
 *
 */
@WebListener
public class MyContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0)  { 
         System.out.println("Application Shutdown");
         
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  {
    	System.out.println("Application Starting....");
         int userCount = 0;
         ServletContext context = event.getServletContext();
         context.setAttribute("usercount", userCount);
    }
	
}
