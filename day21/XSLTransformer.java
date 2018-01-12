/* the class that is by default used by the java engine is 
  transformer class-->com.sun.org.apache.xalan.internal.xsltc.trax.TransformerImpl  
transformer factory-->  com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl
    */
package com.htc.applytemplate;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.Document;
import java.io.File;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;

public class XSLTransformer
{

 public static void main(String args[])throws Exception
 {
  DocumentBuilderFactory factory = 
   DocumentBuilderFactory.newInstance();
  
  DocumentBuilder builder = 
       factory.newDocumentBuilder();
  
  Document document = builder.parse(args[0]);

  DOMSource source = 
       new DOMSource(document);
  TransformerFactory tFactory = 
          TransformerFactory.newInstance();
  String xslFile = args[1];

  Transformer transformer = 
          tFactory.newTransformer(new StreamSource(xslFile));
     
  File newOne = new File(args[2]);

  StreamResult result = new StreamResult(newOne);
  transformer.transform(source,result);
 }

}