package com.htc.ioss;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Favourite {
    private String name;
    private double cost;

    public Favourite(String name, double cost) {
	this.name = name;
	this.cost = cost;
    }
  
    public Favourite(){}
  
    public String getName() {
	  return name;
    }
   
    public void setName(String name) {
        this.name = name;
    }
   
    public double getCost() {
       return this.cost;
    }
 
    public void setCost(double cost) {
       this.cost = cost;
    }
  
    public String toString() {
       String ret = "Favourite's details are:\n  name:"+
                name+" cost:"+cost;  
     return ret;
    }
   
}

class HumanBeing implements Serializable {

    private transient Favourite liking;
    private String name;
    private String occupation;

  public HumanBeing(String name, 
                    String occupation,
                    Favourite liking) {
    this.name = name;
    this.occupation = occupation;
    this.liking = liking;
  }

  public Favourite getLiking(){
     return this.liking;
  }

  public void setLiking(Favourite liking){
     this.liking = liking;
  }

  public String getName() {
     return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOccupation()	{
     return this.occupation;
  }

  public void setOccupation(String occupation) {
     this.occupation = occupation;
  }

  private void writeObject(ObjectOutputStream out) throws IOException {
     out.defaultWriteObject();// serailize non transient 
     String name = liking.getName();
     out.writeObject(name);      // manual serialization 
     out.writeDouble(liking.getCost()); // manual serialization 
  }
  
  private void readObject(ObjectInputStream in)throws Exception {
     in.defaultReadObject(); // deserilizing non transient 
     String name = (String)in.readObject();
     double costVal = in.readDouble(); // manual deserialization 
     liking = new Favourite(name,costVal); // manula deserialization 
  }

  public String toString() {
     return "Name:" + name + " occupation:" + occupation + "\n" + liking;
  }
	
 }

public class ManualSerializeDemo {

  public static void main(String[] args)throws Exception  {
    String sep = File.separator;
    String fileName = "manual.ser";
    Path path = Paths.get(fileName);
    try(ObjectOutputStream out =
           new ObjectOutputStream(new BufferedOutputStream(
                 Files.newOutputStream(path, CREATE, WRITE, APPEND)))){
     Favourite liking = 
           new Favourite("FATHER", 0.0);     
     HumanBeing hb = new HumanBeing("Jesus", "Kindness", liking);
     System.out.println("before:"+hb);
     out.writeObject(hb);
    }catch(IOException ioxe){
    	ioxe.printStackTrace();
        System.out.println("Error while writing");  
    } 
    try(ObjectInputStream in = 
            new ObjectInputStream(
             new BufferedInputStream(
                     Files.newInputStream(path)))) {
    HumanBeing hb2 = (HumanBeing)in.readObject();
    System.out.println("after:"+hb2);
    }catch(IOException ioxe){
        System.out.println("Error while reading");  
    }catch(ClassNotFoundException clne){
        clne.printStackTrace();
    }
  }

}