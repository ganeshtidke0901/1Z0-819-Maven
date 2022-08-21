package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateTimeFormattingExample14 {
	public static void main(String[] args) {

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM dd yy 'at' hh:mm");
		String str = dateTimeFormatter.format(LocalDateTime.now());// it willalways take primitive or object and convert
																	// into String
		System.out.println(str);// September 18 21 at 04:37

		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("MMMM dd yy 'at''' hh:mm");
		String str2 = dateTimeFormatter2.format(LocalDateTime.now());
		System.out.println(str2);// September 18 21 at' 04:39

		DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("yyyy MMM dd hh:mm:ss");
		String str3 = dateTimeFormatter3.format(LocalDateTime.now());
		System.out.println(str3);// 2021 Sep 18 04:43:00

		DateTimeFormatter dateTimeFormatter4 = DateTimeFormatter.ofPattern("yyyy MMM dd hh:mm:ss a Z z");
		String str4 = dateTimeFormatter4.format(ZonedDateTime.now());
		System.out.println(str4);// 2021 Sep 18 04:47:37 pm +0100 BST

		DateTimeFormatter dateTimeFormatter5 = DateTimeFormatter.ISO_DATE;
		String str5 = dateTimeFormatter5.format(ZonedDateTime.now());
		System.out.println(str5);// 2021-09-18+01:00

		// here formatter is working on only Date and in format method we are passing LocaTime
//		DateTimeFormatter dateTimeFormatter6=DateTimeFormatter.ISO_DATE;
//		String str6 = dateTimeFormatter6.format(LocalTime.now());//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: Year
//		System.out.println(str6);// 2

		DateTimeFormatter dateTimeFormatter6 = DateTimeFormatter.ofPattern("'New ' yyyy 'yay!'");
		String str6 = dateTimeFormatter6.format(LocalDateTime.now());
		System.out.println(str6);// New 2021 yay!

		TemporalAccessor accessor = dateTimeFormatter6.parse("New  2021 yay!");
		System.out.println("--"+accessor);//--{Year=2021},ISO

		LocalDate date=LocalDate.parse("2020-04-30", DateTimeFormatter.ISO_DATE);// 2020-04-30
		System.out.println(date);//
		System.out.println(LocalDate.parse("New 2020-04-30 yay!", DateTimeFormatter.ofPattern("'New 'yyyy-MM-dd 'yay!'")));// 2020-04-30
		//we cant parse 'New ' yyyy 'yay!' as it does not have month and date to construct LocalDate

	}
}
