import org.xml.sax.SAXParseException;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.w3c.dom.DOMError;
import org.w3c.dom.DOMErrorHandler;

public class MyDocErrHandler implements DOMErrorHandler {

 public boolean handleError(DOMError error) {
 
  boolean ret = false;
  short sh = error.getSeverity();
  String err = "";
  switch (sh){ 
  
   case DOMError.SEVERITY_ERROR:
                                                  err = "Severe Error";
                                                  ret = false;
       	                                  break;
   case DOMError.SEVERITY_FATAL_ERROR :
                                                 err = "Severe Fatal Error";
                                                  ret = false;
                                                  break;
   case DOMError.SEVERITY_WARNING :
                                                err = "Severe warmning Error";
                                                ret = false;
                                                break;
  }
  
   System.out.println("Error is:"+
                   error.getMessage()+":"+err);
   System.out.println(error.getLocation().getLineNumber());
   return ret;
 }
  
}