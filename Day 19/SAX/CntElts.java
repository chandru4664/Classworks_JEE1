package com.htc.sax;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

class MyContHandler extends MyDefHandler {
 
 String elt = "";
 public static int count = 0;

 public MyContHandler(String elt) {
  this.elt = elt;
 }

 public void startElement(String uri, String localname,
                          String qname, Attributes attrs)
  throws SAXException {      
   if(qname.equalsIgnoreCase(elt)) {
     count +=1;
   }
  } 
  
  public void endDocument()throws SAXException {
   System.out.println("Number of elements of '"+elt+" ' is: "+count);
  }
 
 }   
public class CntElts {
  
 public static void main(String[] args)throws Exception {
  SAXParser parser = null;    
  java.util.Scanner scan = new java.util.Scanner(System.in);
  System.out.println("enter xml file");
  String xmlF = scan.nextLine();
   
  System.out.println("is it Schema based say 'true/false'");
  boolean isSchema = Boolean.parseBoolean(scan.nextLine());

  String xsdF = "";
  if(isSchema) {
   System.out.println("enter xsd file");
   xsdF = scan.nextLine(); 
   parser = new SaxParse().getParser(xsdF);
  }
  else {    
   parser = new SaxParse().getParser(); 
  } 
  System.out.println("enter element name");
  String elt = scan.nextLine();

  MyContHandler mh = new MyContHandler(elt);
  parser.parse(new File(xmlF),mh);     
 }  
  
}  