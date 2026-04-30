package com.jobportal.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class DateFormat {

	public static Date subDays(int day) {

		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		calendar.add(Calendar.DATE, day);
		Date date2 = calendar.getTime();
		return date2;

	}

	public static String dateToString_DB_Format(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = formatter.format(date);
		// System.out.println("dateToString_DB_Format="+strDate);
		return strDate;
	}

	public static Date stringToDateFormat_dd_mm_yyyy(String date) { // System.out.println("date"+date+":");
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date.trim());
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return date1;
	}

	public static Date stringToDateFormat_dd_mm_yyyy1(String date) { // System.out.println("date"+date+":");
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date.trim());
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return date1;
	}

	public static Date convertStrDateTimeToLocalDateTime(String str) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
		Date date = (Date) formatter.parse(str);
		return date;

	}

	public static Date add30Days(Date date) {
		String oldDate = DateFormat.dateToString_DB_Format(date);
		System.out.println("Date before Addition: " + oldDate);
		// Specifying date format that matches the given date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			// Setting the date to the given date
			c.setTime(sdf.parse(oldDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Number of Days to add
		c.add(Calendar.DAY_OF_MONTH, 30);
		// Date after adding the days to the given date
		Date newDate = c.getTime();
		// String newDate = sdf.format(c.getTime());
		// Displaying the new Date after addition of Days
		System.out.println("Date after Addition: " + newDate);
		return newDate;
	}

	public static Date add365Days(Date date) {
		String oldDate = DateFormat.dateToString_DB_Format(date);
		System.out.println("Date before Addition: " + oldDate);
		// Specifying date format that matches the given date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			// Setting the date to the given date
			c.setTime(sdf.parse(oldDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Number of Days to add
		c.add(Calendar.DAY_OF_MONTH, 365);
		// Date after adding the days to the given date
		Date newDate = c.getTime();
		// String newDate = sdf.format(c.getTime());
		// Displaying the new Date after addition of Days
		System.out.println("Date after Addition: " + newDate);
		return newDate;
	}

	public static String calculateDuration(String date1,String date2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// convert String to LocalDate
		LocalDate startDate = LocalDate.parse(date1, formatter);
		LocalDate endDate = LocalDate.parse(date2, formatter);

		// LocalDate bday = LocalDate.of(1955, Month.MAY, 19);
		// LocalDate endDate = LocalDate.now();
		Period age = Period.between(startDate, endDate);
		int years = age.getYears();
		int months = age.getMonths();
		System.out.println("number of years: " + years);
		System.out.println("number of months: " + months);
		String exp;
		if (years == 0) {
			if (months == 1) {
				exp = months + " month";
				System.out.println("Experience " + exp);
				return exp;
			} else {
				exp = months + " months";
				System.out.println("Experience " + exp);
				return exp;
			}
		} else {
			if (months == 1 && years == 1) {
				exp = years + " year and " + months + " month";
				System.out.println("Experience " + exp);
				return exp;
			}

			else if (years > 1 && months == 0) {
				exp = years + " years";
				System.out.println("Experience " + exp);
				return exp;
			} else if (years > 1 && months == 1) {
				exp = years + " years and " + months + " month";
				System.out.println("Experience " + exp);
				return exp;
			} else if (years == 1 && months == 0) {
				exp = years + " year";
				System.out.println("Experience " + exp);
				return exp;
			} else if (years == 1 && months > 0) {
				exp = years + " year and " + months + " months";
				System.out.println("Experience " + exp);
				return exp;
			} else {
				exp = years + " years and " + months + "months";
				System.out.println("Experience " + exp);
				return exp;
			}

		}
	}
}
