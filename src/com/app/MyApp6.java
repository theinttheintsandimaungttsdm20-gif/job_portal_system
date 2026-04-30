package com.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.jobportal.util.DateFormat;

public class MyApp6 {
	 public static void main(String args[]){
			//Given Date in String format
		 
			String oldDate = DateFormat.dateToString_DB_Format(new Date());  
			System.out.println("Date before Addition: "+oldDate);
			//Specifying date format that matches the given date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			System.out.println("Testing for calender "+c.getTime());
			try{
			   //Setting the date to the given date
			   c.setTime(sdf.parse(oldDate));
			}catch(ParseException e){
				e.printStackTrace();
			 }
			   
			//Number of Days to add
			c.add(Calendar.DAY_OF_MONTH, 365);  
			//Date after adding the days to the given date
			String newDate = sdf.format(c.getTime());  
			//Displaying the new Date after addition of Days
			System.out.println("Date after Addition: "+newDate);
		   }
}
