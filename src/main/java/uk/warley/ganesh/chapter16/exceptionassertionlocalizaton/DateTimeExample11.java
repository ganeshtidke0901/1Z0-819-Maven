package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

public class DateTimeExample11 {
	public static void main(String[] args) {
		
		
		LocalDate date=LocalDate.now();
		System.out.println(date);//2021-09-18
		LocalDate date1=LocalDate.of(2020,11,1);
		System.out.println(date1);//2020-11-01
		
		Locale.setDefault(new Locale("fr","FR"));
		LocalDate date2=LocalDate.now();
		System.out.println(date2);//2021-09-18
		LocalDate date3=LocalDate.of(2020,11,1);
		System.out.println(date3);//2020-11-01

		LocalTime localTime=LocalTime.now();
		LocalTime localTime1=LocalTime.of(11, 12,20,12);
		System.out.println(localTime);//13:16:21.595926
		System.out.println(localTime1);//11:12:20.000000012
		
		
		LocalDateTime localDateTime=LocalDateTime.now();
		LocalDateTime localDateTime2=LocalDateTime.of(2020,9,18,16,19,10);
		LocalDateTime localDateTime3=LocalDateTime.of(date1,localTime);
		System.out.println(localDateTime);//2021-09-18T16:20:39.523635900
		System.out.println(localDateTime2);//2020-09-18T16:19:10
		System.out.println(localDateTime3);//2020-11-01T16:23:16.563792500
			
		ZonedDateTime zonedDateTime=ZonedDateTime.now();
		ZonedDateTime zonedDateTime1=ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
		System.out.println(zonedDateTime);//2021-09-18T16:24:37.064212300+01:00[Europe/London]
		System.out.println(zonedDateTime1);//2021-09-18T16:24:37.063215+01:00[Europe/London]
		
		
//		
		
		
	}
}
