package com.htc.db;

import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class MyDataSource {
 
 String dbType; 
 public MyDataSource(String dType) {
  dbType = dType;
 }
 
 public Connection getConnection() 
  throws SQLException {
  String driv = "",url = "",user="",password="";
  String fileName = "";

 if(dbType.equalsIgnoreCase("oracle")){
   fileName = "orasource";
  }
  else if(dbType.equalsIgnoreCase("mysql")) {
    fileName = "mysqlsource";
  } 
  else if(dbType.equalsIgnoreCase("mongodb")) {
      fileName = "mongodb";
  } 
  else if(dbType.equalsIgnoreCase("postgres")) {
      fileName = "pssource";
  } 
  try{
    FileReader reader =
        new FileReader(fileName + ".properties");

    Properties props = new Properties();
    props.load(reader);
    driv = props.getProperty("jdbc.driver");
    url = props.getProperty("jdbc.url");
    user = props.getProperty("jdbc.username");
    password = props.getProperty("jdbc.password");
    Class.forName(driv);
  }catch(IOException | ClassNotFoundException e){
     e.printStackTrace();
  }      
 
  Connection conn = 
        DriverManager.getConnection(url, user, password);
  return conn;
 }

}

/* ensure orasource.properties,mysqlsource.properties
 * are there in same directory,
 * and in another command line run derbynt.bat & startderby.bat
 */ 