package com.htc.pakage3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate);
		
		sdf = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		System.out.println(sdf.format(date));
		
		/*String inputDate = "12-04-2016";
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date parsedDate = sdf1.parse(inputDate);
			System.out.println(parsedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}