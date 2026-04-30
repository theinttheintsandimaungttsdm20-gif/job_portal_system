package com.app;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
public class ScheduleTest {
	@Scheduled(cron="3 35-37 21-22 1 2 TUE")
	public static void scheduleTaskUsingCronExpression() {
	 
	    long now = System.currentTimeMillis() / 1000;
	    System.out.println(
	      "schedule tasks using cron jobs - " + now);
	}
	public static void main(String[] args){
		scheduleTaskUsingCronExpression();
	}
}

