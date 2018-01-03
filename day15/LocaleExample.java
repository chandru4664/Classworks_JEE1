
 import java.util.*;  
public class LocaleExample {  
public static void main(String[] args) {  
//Locale locale=Locale.getDefault();  
Locale locale=new Locale("fr","fr");//for the specific locale  
  
 
System.out.println(locale.getLanguage());  
System.out.println(locale.getCountry());  
      
}  
}  