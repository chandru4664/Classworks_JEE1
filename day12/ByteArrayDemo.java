package com.htc.ioss;
// how to proces bytes 
import java.io.ByteArrayInputStream;
import java.io.IOException;
public class ByteArrayDemo {

 public static void main(String[] args)throws IOException {

  String samp = "1.Java is a progressive programming language.\n"+
                "2.It is simple but vast giving the user,\n"+
                "3.The capability to do internet programming.\n"+
                "4.Easy to migrate from Mainframes to Java. \n ";
    
  byte[] bts = samp.getBytes();
  
  ByteArrayInputStream bin =
        new ByteArrayInputStream(bts);
     
  int uCharCnt = 0,
      lCharCnt = 0,
      digitCnt = 0,
      lineCnt = 0,
      spCnt = 0,
      wordCnt = 0;
  int i;
  char ch;
  while((i = bin.read())!= -1) {
   ch = (char)i;
   if(ch == '\n') {
     lineCnt++;
   }
   else if(Character.isLetter(ch)) {
    if(Character.isUpperCase(ch)) {
        uCharCnt += 1;
    }
    else if(Character.isLowerCase(ch)) {
     lCharCnt += 1;
    }
   }
   else if(Character.isDigit(ch)) {
    digitCnt += 1;
   }
   else if(Character.isSpaceChar(ch)) {
    spCnt += 1;
    wordCnt += 1;
   }
  }
  bin.close();
   
  System.out.println(samp);
  System.out.println("\r\nString-Audit-Report");
  System.out.println("uppercase letters:"+uCharCnt);
  System.out.println("Lowercase letters:"+lCharCnt);
  System.out.println("Digit letters:"+digitCnt);
  System.out.println("Num of lines:"+lineCnt);
  System.out.println("Space letters:"+spCnt);
  System.out.println("total words :"+wordCnt);   
 }

}      