package uk.warley.ganesh.chapter15.streams;

import java.util.Optional;

public class OptionalExamples4 {
	public static void main(String[] args) {
		Optional<String> optional = Optional.empty();
		System.out.println(optional.isEmpty());// true
		System.out.println(optional.isPresent());// false

		Optional<String> optional2 = Optional.of("Ganesh");
		System.out.println(optional2.isEmpty());// false
		System.out.println(optional2.isPresent());// true

		optional2.ifPresent(s -> System.out.println("I got this from optional:" + s));// I got this from optional:Ganesh
		if (optional2.isPresent()) {
			String s1 = optional2.get();
			String s2 = optional2.orElse("Tidke");
			String s3 = optional2.orElseThrow();
			String s4 = optional2.orElseThrow(() -> new RuntimeException("it is empty"));
			String s5 = optional2.orElseGet(String::new);// Supplier

			System.out.println(s1);// Ganesh
			System.out.println(s2);// Ganesh
			System.out.println(s3);// Ganesh
			System.out.println(s4);// Ganesh
			System.out.println(s5);// Ganesh
		}

//		String s1 = optional.get();// java.util.NoSuchElementException: No value present
		String s2 = optional.orElse("Tidke");// Tidke
//		String s3 = optional.orElseThrow();// java.util.NoSuchElementException: No value present
//		String s4 = optional.orElseThrow(() -> new RuntimeException("it is empty"));// java.lang.RuntimeException: it is
																					// empty
		String s5 = optional.orElseGet(String::new);// Supplier- Empty String
		
		
//		Optional<String> optional3=Optional.of(null);//Exception in thread "main" java.lang.NullPointerException
		Optional<String> optional3=Optional.ofNullable(null);
		System.out.println(optional3.isPresent());
	}
}
