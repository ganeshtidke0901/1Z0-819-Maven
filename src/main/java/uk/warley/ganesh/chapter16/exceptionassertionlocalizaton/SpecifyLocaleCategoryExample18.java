package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Locale.Category;

public class SpecifyLocaleCategoryExample18 {

	public static void main(String[] args) {
//		example1();
//		example2();
//		example3();
//		example4();

	}

	private static void example1() {
		double money = 1.28;
		Locale locale = new Locale("fr", "FR");
		System.out.println(NumberFormat.getCurrencyInstance().format(money) + "--"
				+ new Locale("fr", "FR").getDisplayLanguage() + "--" + new Locale("en", "US").getDisplayLanguage());// £1.28--French--English

		Locale.setDefault(Category.DISPLAY, locale);
		System.out.println(NumberFormat.getCurrencyInstance().format(money) + "--"
				+ new Locale("fr", "FR").getDisplayLanguage() + "--" + new Locale("en", "US").getDisplayLanguage());// £1.28--français--anglais

		Locale.setDefault(Category.FORMAT, locale);
		System.out.println(NumberFormat.getCurrencyInstance().format(money) + "--"
				+ new Locale("fr", "FR").getDisplayLanguage() + "--" + new Locale("en", "US").getDisplayLanguage());// 1,28 €--français--anglais-
																													// here
																													// display
																													// is
																													// already
																													// set
																													// at
																													// line
																													// 15

	}

	private static void example2() {

		double money = 1.28;
		Locale locale = new Locale("fr", "FR");
		System.out.println(NumberFormat.getCurrencyInstance().format(money) + "--"
				+ new Locale("fr", "FR").getDisplayLanguage() + "--" + new Locale("en", "US").getDisplayLanguage());// £1.28--French--English

	}

	private static void example3() {
		double money = 1.28;
		Locale locale = new Locale("fr", "FR");
		Locale.setDefault(Category.DISPLAY, locale);
		System.out.println(NumberFormat.getCurrencyInstance().format(money) + "--"
				+ new Locale("fr", "FR").getDisplayLanguage() + "--" + new Locale("en", "US").getDisplayLanguage());// £1.28--français--anglais

	}

	private static void example4() {
		double money = 1.28;
		Locale locale = new Locale("fr", "FR");

		Locale.setDefault(Category.FORMAT, locale);
		System.out.println(NumberFormat.getCurrencyInstance().format(money) + "--"
				+ new Locale("fr", "FR").getDisplayLanguage() + "--" + new Locale("en", "US").getDisplayLanguage());// 1,28 €--French--English

	}
}
