package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleExample19 {

	public static void main(String[] args) {

		Locale localeFr = Locale.FRANCE;
		ResourceBundle bundle = ResourceBundle.getBundle("Zoo");// current locale:en_GB- Bundle search-->
																// Zoo_en_GB->Zoo_en-> Zoo
		ResourceBundle bundleFR = ResourceBundle.getBundle("Zoo", localeFr);// locale:fr_FR- Bundle search-> Zoo_fr_FR->
																			// Zoo_fr->Zoo_en_GB->Zoo_en->Zoo
																			// specific-> default -> Zoo

		System.out.println(bundle.getString("hello"));// Hello_en_GB// key search - Found Zoo_en_GB-> Zoo_en->Zoo
		System.out.println(bundleFR.getString("hello"));// Bonjour_fr_FR//key search - Found Zoo_fr_FR-> Zoo_fr->Zoo

		bundle.keySet().stream().map(s -> s + ":" + bundle.getString(s)).forEach(System.out::println);

//		hello:Hello
//		open:The Zoo is open

		System.out.println(bundle.getString("en_key"));// en_value// key search - Found Zoo_en_GB-> Zoo_en->Zoo
		System.out.println(bundleFR.getString("zoo_key"));// zoo_value_Zoo//key search - Found Zoo_fr_FR-> Zoo_fr->Zoo

		System.out.println(MessageFormat.format(bundleFR.getString("formatting_messsage_key"), "Ganesh"));// Hello_Ganesh
																											// , how are
																											// you?//key
																											// search -
																											// Found
																											// Zoo_fr_FR->
																											// Zoo_fr->Zoo

	}

}
