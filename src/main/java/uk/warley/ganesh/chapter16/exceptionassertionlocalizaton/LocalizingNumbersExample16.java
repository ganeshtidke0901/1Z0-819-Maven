package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class LocalizingNumbersExample16 {
	public static void main(String[] args) {
		long n = 12345;// or long
		Locale frLocale = new Locale("fr", "FR");

		NumberFormat instance1 = NumberFormat.getInstance();
		NumberFormat instance2 = NumberFormat.getInstance(frLocale);

		NumberFormat numberInstance1 = NumberFormat.getNumberInstance();
		NumberFormat numberInstance2 = NumberFormat.getNumberInstance(frLocale);

		NumberFormat currencyInstance1 = NumberFormat.getCurrencyInstance();
		NumberFormat currencyInstance2 = NumberFormat.getCurrencyInstance(frLocale);

		NumberFormat percentageInstance1 = NumberFormat.getPercentInstance();
		NumberFormat percentageInstance2 = NumberFormat.getPercentInstance(frLocale);

		NumberFormat integerInstace1 = NumberFormat.getIntegerInstance();
		NumberFormat integerInstace2 = NumberFormat.getIntegerInstance(frLocale);

		System.out.println(instance1.format(n));// 12,345
		System.out.println(instance2.format(n));// 12 345
		System.out.println(numberInstance1.format(n));// 12,345
		System.out.println(numberInstance2.format(n));// 12 345
		System.out.println(currencyInstance1.format(n));// £12,345.00
		System.out.println(currencyInstance2.format(n));// 12 345,00 €
		System.out.println(percentageInstance1.format(n));// 1,234,500%
		System.out.println(percentageInstance2.format(n));// 1 234 500 %
		System.out.println(integerInstace1.format(12345.22225));// 12,345
		System.out.println(integerInstace2.format(12345.52225));// 12 346

		try {
			Number d = instance1.parse("12,345");
			System.out.println(d);// 12345

			Number d1 = instance1.parse("12 345");
			System.out.println(d1);// 12

			System.out.println(instance2.parse("12,345"));// 12.345-in french , is decimal seprarator LOL
			System.out.println(numberInstance1.parse("12345,11"));// 1234511
			System.out.println(numberInstance2.parse("12345,11"));// 12345.11

			System.out.println(currencyInstance1.parse("£12,345.00"));// 12345
//			System.out.println(format6.parse("£12,345.00"));//Unparseable number: "£12,345.00"

			System.out.println(currencyInstance2.parse("12 345,00 €"));// 12345

			System.out.println(percentageInstance1.parse("1,234,500%"));// 12345
//			System.out.println(format7.parse("1 234 500 %"));//Unparseable number: "1 234 500 %"
			System.out.println((Double)percentageInstance2.parse("1 234 500,99 %"));// 12345.0099

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		NumberFormat format11=new DecimalFormat("###,###,###.0");
		System.out.println(format11.format(12345.78));//12,345.8
		
		NumberFormat format12=new DecimalFormat("###,###,###.00");
		System.out.println(format12.format(12345));//12,345.00
		
		
		NumberFormat format13=new DecimalFormat("000,000,000.00");
		System.out.println(format13.format(12345));//000,012,345.00
		
		

	}
}
