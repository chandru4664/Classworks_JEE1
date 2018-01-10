package com.htc.sax;
import java.io.File;
import org.xml.sax.SAXParseException;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

class MyConHandler extends MyDefHandler {

 public static int count = 0;

 public MyConHandler(){}

 public void startPrefixMapping(String prefix,String url)
  throws SAXException {
  System.out.println("Start-->"+url+"%%%"+prefix);
 }
    
 public void endPrefixMapping(String prefix)
  throws SAXException {
  System.out.println("end-->"+prefix+"\n");
 }

 public void startElement(String uri, String localname,
                          String qname, Attributes attrs)
  throws SAXException {
  System.out.println("QName:"+qname);
  System.out.println("LocalName:"+localname);
  System.out.println("uri:"+uri+"\n");
 }
   
}
 
public class PrintElts {

 public static void main(String[] args)
  throws Exception {
 
  if(args.length != 1) {
   System.err.println("usage 'java PrintElts <filename>  ");
   System.exit(1);
  }
  SAXParser parser = new SaxParse().getParser();
    
  MyConHandler mh = new MyConHandler();
  parser.parse(new File(args[0]),mh);     
 }  
  
}  