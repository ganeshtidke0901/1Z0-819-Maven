package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocalizingDateTimeExample17 {
	public static void main(String[] args) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy MM dd hh:mm");
		System.out.println(dateTimeFormatter.format(ZonedDateTime.now()));// 2021 09 18 06:18 here we can add
																			// withLocale() but it does not make any
																			// sense we have pattern configured

		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		System.out.println(dateTimeFormatter2.format(ZonedDateTime.now()));// Saturday, 18 September 2021
		System.out.println(dateTimeFormatter2.withLocale(new Locale("fr", "FR")).format(ZonedDateTime.now()));// samedi
																												// 18
																												// septembre

		DateTimeFormatter dateTimeFormatter21 = DateTimeFormatter.ofPattern("yyyy MM dd hh:mm",new Locale("fr", "FR"));//local does not matter  here
		System.out.println("--"+dateTimeFormatter21.format(ZonedDateTime.now()));// Saturday, 18 September 2021
		System.out.println("--"+dateTimeFormatter21.format(ZonedDateTime.now()));// samedi
																												// 18
																												// septembre

		DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL);
		System.out.println(dateTimeFormatter3.format(ZonedDateTime.now()));// 18:26:10 British Summer Time
		System.out.println(dateTimeFormatter3.withLocale(new Locale("fr", "FR")).format(ZonedDateTime.now()));// 18:26:10 heure d’été britannique

		
		
		DateTimeFormatter dateTimeFormatter4 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
		System.out.println(dateTimeFormatter4.format(ZonedDateTime.now()));// Saturday, 18 September 2021 at 18:32:39 British Summer Time
		System.out.println(dateTimeFormatter4.withLocale(new Locale("fr", "FR")).format(ZonedDateTime.now()));// samedi 18 septembre 2021 à 18:32:39 heure d’été britannique

		DateTimeFormatter dateTimeFormatter5 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT,FormatStyle.SHORT);
		System.out.println(dateTimeFormatter5.format(ZonedDateTime.now()));// 18/09/2021, 18:33
		System.out.println(dateTimeFormatter5.withLocale(new Locale("fr", "FR")).format(ZonedDateTime.now()));// 18/09/2021 18:33

	}
}
