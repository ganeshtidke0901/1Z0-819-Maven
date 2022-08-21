package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesExample20 {

	public static void main(String[] args) {

		Properties properties=new Properties();
		properties.setProperty("key", "value");
		System.out.println(properties.getProperty("key"));//value
		System.out.println(properties.getProperty("key2","Another Value"));//Another Value
		System.out.println(properties.get("key"));//return object
	
		properties.put("key3", "value3");
		
	}

}
