package com.htc.sax;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXNotRecognizedException;
import java.io.File;

public class SaxParse { 

 static final String JAXP_SCHEMA_LANGUAGE =
      "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

 static final String JAXP_SCHEMA_SOURCE =
      "http://java.sun.com/xml/jaxp/properties/schemaSource";

 static final String W3C_XML_SCHEMA =
      "http://www.w3.org/2001/XMLSchema";

 static final String FEATURE = "http://xml.org/sax/features/";

 public boolean parseDTDFile(String xmlFile, 
                             MyDefHandler dh)
  throws Exception {
  boolean ret = false;  
  try {
   SAXParser parser = this.getParser();
   parser.parse(new File(xmlFile), dh);
   ret = true;     
  }catch(Exception e){
    ret = false;
    System.out.println(e);
  }
  return ret;
 } 

 public boolean parseSchemaFile(String xmlFile,
                                String xsdFile,
                                MyDefHandler dh)
  throws Exception {
   
  boolean ret = false;  
  try {
   SAXParser parser = this.getParser(xsdFile);
   parser.parse(new File(xmlFile), dh);
   ret = true;     
  }
  catch(Exception e){
   ret = false;
   System.out.println(e);
  }
  return ret;
 } 
 
 public  SAXParser  getParser(String xsdFile) {
  SAXParser parser = null;
  try {
   SAXParserFactory factory = 
           this.getConfiguredFactory();
   factory.setFeature("http://apache.org/xml/features/validation/schema", true);
   parser = factory.newSAXParser(); 
   parser.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
   parser.setProperty(JAXP_SCHEMA_SOURCE,xsdFile);  
  }catch(Exception e) {
     System.out.println(e);
  }
  return parser;
 } 
 
 public  SAXParser  getParser() {
  SAXParser parser = null;
  try {     
   parser = this.getConfiguredFactory().newSAXParser();   
  }catch(Exception e){
     System.out.println(e);
  }
  return parser;
 }
 
 public SAXParserFactory getConfiguredFactory() {
   SAXParserFactory factory = 
               SAXParserFactory.newInstance();  
   try{
    factory.setFeature(FEATURE+"namespaces", true);
    factory.setFeature(FEATURE+"namespace-prefixes", true);
    factory.setFeature(FEATURE+"validation", true);
    factory.setFeature(FEATURE+"external-general-entities", true);
    factory.setFeature(FEATURE+"external-parameter-entities", true);
    factory.setFeature(FEATURE+"lexical-handler/parameter-entities", true);
    factory.setFeature(FEATURE+"use-entity-resolver2", true);
    factory.setFeature(FEATURE+"resolve-dtd-uris", true);
   }catch(SAXNotSupportedException snse){
       
   }catch(ParserConfigurationException pe){
       pe.printStackTrace();
   }catch(SAXNotRecognizedException srge){
       srge.printStackTrace();
   }
   return factory;
 }
 
 
 public static void main(String[] args) {
  SaxParse saxParse = new SaxParse();   
  java.util.Scanner scan = new java.util.Scanner(System.in);
  System.out.println("enter xml file");
  String xmlF = scan.nextLine();
  
  System.out.println("is it Schema based say 'true/false'");
  boolean isSchema = Boolean.parseBoolean(scan.nextLine());

  String xsdF = "";
  if(isSchema) {
    System.out.println("enter xsd file");
    xsdF = scan.nextLine(); 
  }   

  MyDefHandler mh= new MyDefHandler();
  try {
   if(isSchema){ 
    System.out.println("File parsed is:"+
    saxParse.parseSchemaFile(xmlF,xsdF,mh));
   }
   else {
    System.out.println("File parsed is:"+
    saxParse.parseDTDFile(xmlF,mh));
   }
  }
  catch(Exception e){
   e.printStackTrace();
  }
 }

} 