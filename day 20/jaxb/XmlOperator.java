package jax;

import java.io.File;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import play.AddressType;
import play.NameType;
import play.ObjectFactory;
import play.PinType;
import play.PlayerType;
import play.StreetAttrType;
import play.TeamType;

public class XmlOperator {
	public static void main(String[] args) {
		try {
			// unmarshal 
			JAXBContext jaxPlayer=JAXBContext.newInstance("play");
			Unmarshaller umPlay=jaxPlayer.createUnmarshaller();
			JAXBElement<TeamType> jaxTeam=(JAXBElement<TeamType>)umPlay.unmarshal(new File("Players.xml"));
			TeamType team=jaxTeam.getValue();
			
			List<PlayerType> players=team.getPlayer();
			for(PlayerType player:players){
				if(player.getPlayerName().getFirstName().equals("SachineRamesh")){
					player.getPlayerName().setFirstName("Sachine");
				}
			}
			
			ObjectFactory obj=new ObjectFactory();
			
			NameType playerName=obj.createNameType();
			playerName.setFirstName("Suresh");
			playerName.setMidName("kumar");
			playerName.setLastName("uttarala");
			
			NameType fatherName=obj.createNameType();
			fatherName.setFirstName("Mr.");
			fatherName.setMidName("F/O");
			fatherName.setLastName("Satyanarayana");
			
			StreetAttrType street=obj.createStreetAttrType();
			street.setNo(new BigInteger("542"));
			street.setValue("ABCRoad");
			
			PinType pin=obj.createPinType();
			pin.setCode(67890);
			
			AddressType address=obj.createAddressType();
			address.setCity("Kerala");
			address.setPin(pin);
			address.setStreet(street);
			
			PlayerType player=obj.createPlayerType();
			player.setPlayerName(playerName);
			player.setFatherName(fatherName);
			
		
			
			//Create date as GregorianCalendar  
			GregorianCalendar dateOfBirthAsGC=new GregorianCalendar(1975,10,8);
			
			//Create an instance of DataTypeFactory by calling newInstance method
			DatatypeFactory dataTypeFactory=DatatypeFactory.newInstance();
			
			//Call an instance method newXMLGregorianCalendar which takes GregorianCalendar object as parameter
			XMLGregorianCalendar xmlGCDob=dataTypeFactory.newXMLGregorianCalendar(dateOfBirthAsGC);
			
			player.setDateOfBirth(xmlGCDob);
			player.setAddress(address);

			team.getPlayer().add(player);
			JAXBElement<TeamType> jaxNewTeam=obj.createPlayers(team);
			
			
			Marshaller marshal=jaxPlayer.createMarshaller();
			marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			marshal.marshal(jaxNewTeam, new File("Players.xml"));
			System.out.println("Done");
			
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		} 
	}
}
