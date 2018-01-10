package com.htc.sax;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;
import org.xml.sax.SAXException;
 
public class AvgPrice extends MyDefHandler {  
 
 static int count = 0;
 static String filename = "";
 static SAXParser p = null;
 public boolean isFiction = false;
 public double totprice = 0.0;
 public StringBuffer sb = new StringBuffer(1000);

 public static void main(String args[])throws Exception {        
  filename = "books.xml";
  p = new SaxParse().getParser();
  p.parse(filename,new AvgPrice());

 }
 @Override
 public void startElement(String uri, String localname,
                          String qname, Attributes attrs)
  throws SAXException {

  System.out.println("Start element is fired.........");
  if(qname.equalsIgnoreCase("book")) {
   String category = attrs.getValue("category");
   isFiction = 
    (category != null && category.equalsIgnoreCase("fiction"));
   if(isFiction) count += 1;
  }
  sb.setLength(0);
 }
 
 @Override
 public void characters(char[] chars, int start, int len)
  throws SAXException {
  sb.append(chars,start,len);      
 }
@Override
 public void endElement(String uri, String localname, String qname)
  throws SAXException {
 
  if(qname.equalsIgnoreCase("price") && isFiction) {
   double price = new Double(sb.toString().trim()).doubleValue();
   totprice += price;
   isFiction = false; 
  }
        
  sb.setLength(0);
 }
 @Override  
 public void endDocument()throws SAXException {
  
  System.out.println("Number of Books with "+
             " category as 'fiction' is:"+count);
  System.out.println("Their average price is:"+(totprice/count));
 } 

}  