package com.htc.sax;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

class MyContentHandler extends MyDefHandler {

 String elt = "";
 boolean found = false;
 
 public MyContentHandler(String elt) {
  this.elt = elt;
 }
  
 public void startElement(String uri, String localname,
                          String qname, Attributes attrs)
  throws SAXException {
   
   if(qname.equalsIgnoreCase(elt)){ 
    found = true;
   }
 }
 
 public void characters(char[] ch, int start, int length){
 
  if(found) {
   System.out.println(elt+"-->"+new String(ch,start,length));
   found = false;
  }
 }
}   

public class ContentFinder {

 public static void main(String[] args)throws Exception {

  if(args.length != 2) {
   System.err.println("usage 'java ContentFinder"+
      " <filename> <eltname>' ");
   System.exit(1);
  }
  SAXParser parser = new SaxParse().getParser();
/* for example of default value for element
   SAXParser parser = new SaxParse().getParser("DefaultTest.xsd");
*/
  MyContentHandler mh = new MyContentHandler(args[1]);
  parser.parse(new File(args[0]),mh);     
 }
  
}  

/*
  use AttrDept.xml 
*/