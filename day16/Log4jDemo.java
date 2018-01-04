package com.htc.logger;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Level;


public class Log4jDemo {

  public static void main(String[]  args) {

    Logger logger = LogManager.getLogger("com.htc.logger");

    logger.trace("welcome to log4j ");
     
    ForLog4j forLog4j = new ForLog4j();
    int maxVal = forLog4j.computeMax(5, 8, 65, 32, 21, 12, 54);
    System.out.println(maxVal);


    logger.warn("configuration is very important");
  }

}
