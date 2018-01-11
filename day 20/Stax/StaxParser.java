package stax;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.xml.XMLConstants;
import javax.xml.validation.Validator;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class StaxParser {
	public void validate(String xmlFile,String xsdFile) throws  SAXException,IOException{
		
	    SchemaFactory scf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	    StreamSource xsdSource = new StreamSource(new File(xsdFile));
	    Schema schema = scf.newSchema(xsdSource);
	    Validator validator = schema.newValidator();
	    MyDefHandler eh = new MyDefHandler();
	    validator.setErrorHandler(eh);
	    StreamSource xmlSource = new StreamSource(new File(xmlFile)); 
	    validator.validate(xmlSource);
	}
	
	
	public static void main(String[] args) {
		try{
			//Accessing reader
			XMLInputFactory iFactory =XMLInputFactory.newInstance();
			iFactory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE,true);
			StreamSource xmlSource = new StreamSource(new File("Players.xml")); 
			XMLStreamReader reader =iFactory.createXMLStreamReader(xmlSource);
			
			//Accessing writer
			XMLOutputFactory oFactory = XMLOutputFactory.newInstance();
			Writer out = new FileWriter("D:/newStaxPlayer.xml");
			XMLStreamWriter writer =oFactory.createXMLStreamWriter(out);
			
			int counter=0;
		
			int event=reader.getEventType();
			boolean isIntended=false;
			int attrs=0;
			while(event!=XMLStreamConstants.END_DOCUMENT){
				
				if(XMLStreamConstants.START_DOCUMENT==event){
					writer.writeStartDocument();
				}else if(XMLStreamConstants.START_ELEMENT==event){
					writer.writeStartElement(reader.getLocalName());
				}else if(XMLStreamConstants.CHARACTERS==event){
					if(reader.getText().equals("SachineRamesh")){
						writer.writeCharacters("Sachin");
					}else{
						writer.writeCharacters(reader.getText());
					}
				}else if( XMLStreamConstants.END_ELEMENT==event){
					writer.writeEndElement();
				}
				// move forward
				reader.next();
				event=reader.getEventType();
			}
			writer.writeEndDocument();
			reader.close();
			writer.close();
			System.out.println(counter);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
