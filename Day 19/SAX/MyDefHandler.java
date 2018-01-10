package com.htc.sax;
import org.xml.sax.SAXParseException;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;
import org.xml.sax.InputSource;

public class MyDefHandler extends DefaultHandler2 {
  
  @Override
  public void fatalError(SAXParseException exception)
    throws SAXException {

   System.out.println("very severe Error"+exception);
   System.out.println("At line Number:"+
                      exception.getLineNumber());
   System.out.println("At Column Number:"+
                         exception.getColumnNumber());
  }

  public void error(SAXParseException exception)
    throws SAXException {
 
   System.out.println("Error:"+exception);
   System.out.println("At line Number:"+
                  exception.getLineNumber());
   System.out.println("At Column Number:"+
                       exception.getColumnNumber());
  }
 
  public void warning(SAXParseException exception)
    throws SAXException {
  
   System.out.println("Warning:"+exception);
  }

}