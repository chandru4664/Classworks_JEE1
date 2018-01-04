package com.htc.logger;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ForLog4j {

   Logger logger = LogManager.getLogger("com.htc.logger");
 
   public int computeMax(int defMax, int ... nos) {
      logger.trace("given defMax is"+defMax); 
      int ret = 0;
      if(nos.length == 0){
        logger.debug("Method result is:"+defMax); 
        return defMax;
      } 
      for(int no : nos) {
        ret = Math.max(ret,no);
      }
     logger.debug("Method result is:"+ret);

     return ret;
   }
}   
   
 
