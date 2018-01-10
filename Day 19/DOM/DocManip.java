import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import java.io.File;
import java.util.Scanner;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DocManip  {

	static final String JAXP_SCHEMA_LANGUAGE =
		        "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	public Document createDocument(String xmlFile){
		Document doc = null;
		try {
			DocumentBuilderFactory   dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(true);
			dbf.setNamespaceAware(true);
			try {
				dbf.setAttribute(JAXP_SCHEMA_LANGUAGE,XMLConstants.W3C_XML_SCHEMA_NS_URI);
			}
			catch(IllegalArgumentException iae) {}
				   
			DocumentBuilder db = dbf.newDocumentBuilder();
			MyDefHandler dh = new MyDefHandler();
			db.setErrorHandler(dh);
			doc = db.parse(new File(xmlFile));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	public boolean saveDoc(Document doc, String filePath) {
		boolean ret = false;
		try {
			DOMImplementation impl = doc.getImplementation();		
			DOMImplementationLS implLS =(DOMImplementationLS) impl.getFeature("LS","3.0");
			MyDocErrHandler docErr =new MyDocErrHandler();
			LSSerializer writer =implLS.createLSSerializer(); 
			writer.getDomConfig().setParameter("error-handler",docErr);
			//writer.getDomConfig().setParameter("discard-default-content", true);
			writer.getDomConfig().setParameter("format-pretty-print",true);
			ret = writer.writeToURI(doc,filePath);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return ret;
	}	
	public void processChilds(Node currentChild){
		System.err.println(currentChild.getNodeName());	
		if(currentChild.hasChildNodes()){
			NodeList grandChild=currentChild.getChildNodes();
			for(int i=0;i<grandChild.getLength();i++){
				processChilds(grandChild.item(i));
			}
		}else{
			if(currentChild.getNodeType()==Node.TEXT_NODE){
				String value=currentChild.getNodeValue().trim();
				if(value.length()>0)System.out.println(value);
			}
		}
	}
	public static void main(String[] args)throws Exception {
		DocManip mainObj=new DocManip();
		Document doc=mainObj.createDocument("Players.xml");
		Element root=doc.getDocumentElement();
		String ns=doc.getNamespaceURI();
		
		NodeList playersList=root.getElementsByTagName("player");
		for(int i=0;i<playersList.getLength();i++){
			Node player=playersList.item(i);
			if(player.getNodeType()==Node.ELEMENT_NODE){
				Element playerEle=(Element)player;
				NodeList firstNamesList=playerEle.getElementsByTagName("firstName");
				Node firtName=null;
				for(int j=0;j<firstNamesList.getLength();j++){
					firtName=firstNamesList.item(j);
					System.out.println(firtName.getFirstChild().getNodeValue());
				}

			}
		}

		//Player Element
		Element newPlayer=doc.createElementNS(ns,"player");
		
				//Player's direct children
				Element newPlayerName=doc.createElementNS(ns,"playerName");
					//PlayerName's Children
					Element firstName=doc.createElementNS(ns,"firstName");
							Text firstNameTxt=doc.createTextNode("Ambi");
					firstName.appendChild(firstNameTxt);
					
					Element midName=doc.createElementNS(ns,"midName");
					midName.setTextContent("Remo");
					
					Element lastName=doc.createElementNS(ns,"lastName");
					lastName.setTextContent("Anni");
				
				newPlayerName.appendChild(firstName);
				newPlayerName.appendChild(midName);
				newPlayerName.appendChild(lastName);
				//Player's DOB
				Element dob=doc.createElementNS(ns,"dateOfBirth");
					dob.setTextContent("1993-07-17");
				
				//address
				Element address=doc.createElementNS(ns,"address");
					Element pin=doc.createElementNS(ns,"pin");
						Attr code=doc.createAttributeNS(ns,"code");
						code.setValue("143");					
					pin.setAttributeNode(code);
					
					Element street=doc.createElementNS(ns,"street");
					street.setTextContent("Chandramuki Street");
					street.setAttributeNS(ns,"no", "2");
				
					Element city=doc.createElementNS(ns,"city");
					city.setTextContent("Las Vegas");
			address.appendChild(pin);		
			address.appendChild(street);
			address.appendChild(city);
			
			newPlayer.appendChild(newPlayerName);
			newPlayer.appendChild(dob);
			newPlayer.appendChild(address);
			newPlayer.setAttributeNS(ns,"id", "P5");			
			root.appendChild(newPlayer);
			root.normalize();
			doc.normalizeDocument();
			mainObj.saveDoc(doc, "file:///D:/newPlayer.xml");
	}
}