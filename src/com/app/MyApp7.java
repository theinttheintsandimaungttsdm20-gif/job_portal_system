package com.app;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MyApp7 {
	@SuppressWarnings("empty-statement")
	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = "2016-08-08";
		String date2 = "2018-09-08";
		// convert String to LocalDate
		LocalDate startDate = LocalDate.parse(date, formatter);
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
			} else {
				exp = months + " months";
				System.out.println("Experience " + exp);
			}
		} else {
			if (months == 1 && years==1) {
				exp = years + " year and " + months + " month";
				System.out.println("Experience " + exp);
			}

			else if (years>1 && months == 0) {
				exp = years + " years";
				System.out.println("Experience " + exp);
			}
			else if (years>1 && months ==1 ) {
				exp = years + " years and " + months + " month";
				System.out.println("Experience " + exp);
			}
			else if(years==1 && months==0){
				exp = years + " year";
				System.out.println("Experience " + exp);
			}
			else if(years==1 && months>0){
				exp = years + " year and " + months + " months";
				System.out.println("Experience " + exp);
			}
			else {
				exp = years + " years and " + months + "months";
				System.out.println("Experience " + exp);
			}

		}

	}
}