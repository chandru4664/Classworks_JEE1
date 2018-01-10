package com.htc.sax;
import org.xml.sax.SAXParseException;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.util.Scanner;

class MyErrHandler extends MyDefHandler {
  
 String elt = "";
 String atr = "";
 String atrVal  = "";
 boolean found = false;

 public MyErrHandler(String elt, String atr) {
  this.elt = elt;
  this.atr = atr;
 }
 

 public void startElement(String uri, String localname,
                         String qname,Attributes attrs)
  throws SAXException  {
   
   String atName = "";
   if(qname.equalsIgnoreCase(elt)) {
    found = true;
    int atLen = attrs.getLength();
     
    for(int i=0;i<atLen;i++) {         
     atName = attrs.getQName(i).trim();         
     if(atName.equalsIgnoreCase(atr))
     atrVal = attrs.getValue(i);
    }
   }
  }

  public void endElement(String uri, String localname, String qname)
    throws SAXException {

  if(found) {       
   System.out.println("attribute details name:"+
                      atr+"  value:"+atrVal);
   found = false;
  }
 }
}   

public class AttributeFinder {  
  
 public static void main(String[] args) 
   throws Exception {

  SAXParser parser = null;
  Scanner scanner = new Scanner(System.in);
 
  System.out.println("enter xml file");
  String xmlFile = scanner.nextLine();
  System.out.println("is It schemaBased say 'Y/N'");
  String isSchema = scanner.nextLine();
  if(isSchema.equalsIgnoreCase("y")) {
   System.out.println("enter xsd file");
   String xsdFile = scanner.nextLine();
   
   parser = new SaxParse().getParser(xsdFile);
  }
  else {
   parser = new SaxParse().getParser();          
  }
  System.out.println("enter element whose attribute "+
                    " is to be found");
  String element = scanner.nextLine();

  System.out.println("enter attribute-name whose value"+
                    " you seek");
     
  String attribute = scanner.nextLine();

  MyErrHandler mh = new MyErrHandler(element,attribute);
  parser.parse(new File(xmlFile),mh);     
 }
  
}  