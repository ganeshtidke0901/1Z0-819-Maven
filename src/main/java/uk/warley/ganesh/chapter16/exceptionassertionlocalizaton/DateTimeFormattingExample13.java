package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormattingExample13 {
	public static void main(String[] args) {

		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();

		System.out.println(localDate + "--" + localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));// 2021-09-18--2021-09-18
		System.out.println(localDate + "--" + DateTimeFormatter.ISO_LOCAL_DATE.format(localDate));// 2021-09-18--2021-09-18
		System.out.println(localTime + "--" + localTime.format(DateTimeFormatter.ISO_LOCAL_TIME));// 16:31:57.258836600--16:31:57.2588366
		System.out.println(localDateTime + "--" + localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));// 2021-09-18T16:31:57.258836600--2021-09-18T16:31:57.2588366
	
	
		System.out.println(localDateTime + "--" + localDateTime.format(DateTimeFormatter.ISO_DATE));// 2021-09-18T16:33:09.827177--2021-09-18
//		System.out.println(localDate + "--" + localDate.format(DateTimeFormatter.ISO_TIME));// Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: HourOfDay
		System.out.println(localDateTime + "--" + localDateTime.format(DateTimeFormatter.ISO_ORDINAL_DATE));// 2021-09-18T16:35:08.016745900--2021-261
		
	}
}
