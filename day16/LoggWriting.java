package com.htc.logger;

import java.util.logging.Logger;
import java.util.logging.FileHandler; 
import java.util.logging.Level; 
import java.util.logging.ErrorManager;
import java.io.IOException;

public class LoggWriting {
 
  public void displayLogMessages(String[] args) {
      Logger logger = Logger.getLogger("com.htc.logger");
      ErrorManager er = new ErrorManager();
    try {
      FileHandler fh = 
           new FileHandler("mylog.xml", true);
      
      fh.setErrorManager(er);
      logger.setLevel(Level.ALL);

      logger.addHandler(fh);
      logger.entering("LoggWriting", "displayLogMessages", "No Parameter");
      System.out.println();
    
      int t1 = Integer.parseInt(args[0]);
      int t2 = Integer.parseInt(args[1]);
      logger.log(Level.INFO, 
         "received arguments are:" + t1 + "," + t2);
      System.out.println();
 
      int t3 = Math.max(t1, t2);
      logger.log(Level.INFO, 
              "maximum of given values:" + t3);
      System.out.println();
/*
      double t4 = Math.pow(t1, t2);   
      logger.log(Level.INFO,
           "power of " + t1 + " raised to " + 
            t2 + " is:" + t4);  
      System.out.println();

      logger.logp(Level.INFO, "LoggWriting",
           "displayLog", "This is log precision");    
      System.out.println();*/
      String array[]= {"DTRPrasad","Evening"};
      logger.logrb(Level.INFO, "LoggWriting", 
              "displayLog", "mybundle", "mymsg1",array);
      System.out.println();

      logger.exiting("LoggWriting", "displayLog", "success");
      System.out.println();
      fh.close();
    }catch(NumberFormatException nfe) {
      er.error("Wrong arguments", nfe,
              ErrorManager.FORMAT_FAILURE);
      logger.throwing("LogWriting", "main",
          new NumberFormatException("Wrong arguments"));
      System.out.println();
    }catch(IOException ioe){
      ioe.printStackTrace();
    }  
    
    logger.severe("Sever error ");
  }

  public static void main(String[] args) {
    LoggWriting logWriting = new LoggWriting();
    logWriting.displayLogMessages(args);
  }

}
    
  /*CLOSE_FAILURE
    FLUSH_FAILURE
    GENERIC_FAILURE
    OPEN_FAILURE
    WRITE_FAILURE  */
     