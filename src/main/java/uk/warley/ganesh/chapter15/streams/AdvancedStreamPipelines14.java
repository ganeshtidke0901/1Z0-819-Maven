package uk.warley.ganesh.chapter15.streams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class AdvancedStreamPipelines14 {

	static void example1() {
		var cats = new ArrayList<String>();
		cats.add("Annie");
		cats.add("Ripley");
		Stream<String> stream = cats.stream();
		cats.add("Hello");
		cats.forEach(System.out::println);// Annie
										 // Ripley
										// Hello

	}

	private static void example2() {
		Optional<Integer> optional = Optional.of(1);// just one value
		optional.map(n -> n + "Ganesh").filter(s -> s.contains("Gan")).ifPresent(System.out::println);// 1Ganesh

	}

	private static void example3() {
		Optional<String> optional = Optional.of("Ganesh");// just one value
		Optional<Integer> optional2 = optional.map(s -> s.length());

		Optional<String> optional3 = Optional.of("Ganesh");// just one value
		Optional<Integer> optional4 = optional.flatMap(s -> Optional.of(s.length()));// it converts s(String) into
																						// Optional(Integer) and pass it
																						// Optional(Integer)
	}

	private static void example4() {

//		create().stream().count(); //ask for unhandled exception
	
//		Supplier<List<String>> s2 = AdvancedStreamPipelines::create;// compiler error as supplier get method not having
																	// any checked exception so this method reference is
																	// addiing extra checked exception which is supposed
																	// to be handled in create method and remove throws statement

		
		Supplier<List<String>> s = () -> {
			try {
				return create();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		};

	}

	public static void main(String[] args) {
//		example1();
		example2();
		example3();
		example4();

	}

	private static List<String> create() throws IOException {
		throw new IOException();
	}

}
