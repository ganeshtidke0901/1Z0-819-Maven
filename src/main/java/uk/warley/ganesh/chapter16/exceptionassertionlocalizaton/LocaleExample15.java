package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

import java.util.Locale;

public class LocaleExample15 {
	public static void main(String[] args) {

		Locale locale = Locale.getDefault();
		System.out.println(locale);// en_GB

		System.out.println(Locale.US);// en_US
		System.out.println(Locale.ENGLISH);// en
		System.out.println(Locale.GERMAN);// de
		System.out.println(Locale.GERMANY);// de_DE

		System.out.println(new Locale("en"));// en
		System.out.println(new Locale("en", "GB"));// en_GB

		Locale locale2 = new Locale.Builder().setLanguage("fr").setRegion("FR").build();
		System.out.println(locale2);// fr_FR

		System.out.println(Locale.getDefault());// en_GB
		Locale.setDefault(Locale.FRANCE);//OR Locale.setDefault(new Locale("fr","FR"));
		System.out.println(Locale.getDefault());//fr_FR
		
		
		
		
		

	}
}
