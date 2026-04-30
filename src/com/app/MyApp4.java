package com.app;

import java.util.Calendar;
import java.util.Date;

public class MyApp4 {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		int day=-1;
		Calendar calendar = Calendar.getInstance(); 
		calendar.getTime();
		calendar.add(Calendar.DAY_OF_MONTH, day);
		Date date2=calendar.getTime();
		System.out.println(date2);

	}

}
