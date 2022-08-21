package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

public class DateTimeExample12 {
	public static void main(String[] args) {
		
		
		LocalDate date=LocalDate.now();
		System.out.println(date.getYear());//2021
		System.out.println(date.getMonth());//SEPTEMBER
		System.out.println(date.getMonthValue());//9
		System.out.println(date.getDayOfWeek());//SATURDAY
		System.out.println(date.getDayOfMonth());//18
		System.out.println(date.getDayOfYear());//261
	}
}
