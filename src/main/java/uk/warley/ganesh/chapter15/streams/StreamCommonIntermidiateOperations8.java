package uk.warley.ganesh.chapter15.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCommonIntermidiateOperations8 {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("monkey", "gorilla", "bonobo");
		stream.filter(s -> s.startsWith("g")).forEach(System.out::println);// gorilla - Predicate is used

		Stream<String> stream1 = Stream.of("monkey", "bonobo", "bonobo");
		stream1 = stream1.distinct();
		stream1.forEach(System.out::println);// gorilla,bonobo
		
		

		Stream<Integer> stream2 = Stream.iterate(1, i -> i + 1); // Infinite stream 1,2,3,4,5........
		stream2.skip(5).limit(2).forEach(System.out::println);// 6
																// 7

		Stream<String> stream3 = Stream.of("monkey", "gorilla", "bonobo");
		Stream<Integer> stream4 = stream3.map(s -> s.length());
		stream4.forEach(System.out::println);// 6
												// 7
												// 6
		Stream<String> stream5 = Stream.of("monkey", "gorilla", "bonobo");
		stream5.map(String::length).forEach(System.out::println);// 6
		// 7
		// 6

		List<String> list1 = List.of("Ganesh", "Tidke");
		List<String> list2 = List.of();
		List<String> list3 = List.of("Ashwini");

		Stream<List<String>> stream6 = Stream.of(list1, list2, list3);
		stream6.flatMap(s -> s.stream()).forEach(System.out::println);// or List::stream
																		// Ganesh
																		// Tidke
																		// Ashwini

		Stream<String> stream7 = Stream.of("monkey", "gorilla", "bonobo");
		stream7.sorted().forEach(System.out::println);// bonobo
														// gorilla
														// monkey

		Stream<String> stream8 = Stream.of("monkey", "gorilla", "bonobo");
		stream8.sorted((s1, s2) -> s2.compareTo(s1)).forEach(System.out::println);// monkey
																					// gorilla
																					// bonobo

		Stream<String> stream9 = Stream.of("monkey", "gorilla", "bonobo");
		stream9.sorted(Comparator.reverseOrder()).forEach(System.out::println);// monkey
																				// gorilla
																				// bonobo

		Stream<Integer> stream10 = Stream.of(1_1, 2_2);// 11,22
		stream10.peek(System.out::println).forEach(System.out::println);// 11
																		// 11
																		// 22
																		// 22

		List<String> list11 = new ArrayList<String>();
		List<String> list33 = new ArrayList<String>();
		list11.add("Ganesh");
		list33.add("Tidke");

		// bad code -executed
		Stream<List<String>> stream11 = Stream.of(list11, list33);
		stream11.peek(l -> l.remove(0)).forEach(System.out::println);// []
																		// []

		Stream<String> stream12= Stream.of("Ganesh", "Tidke", "Mr");
		Stream<Integer> stream13 = stream12.map(s -> s.length());
//		stream12.map(s -> s.length()).forEach(System.out::println);//Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed

		Stream<String> stream14= Stream.of("Ganesh", "Tidke", "Mr");
		stream14.peek(s->System.out.println("--"+s));
//		stream14.forEach(System.out::println);//Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed

		
		Stream<String> stream15= Stream.of("Ganesh", "Tidke", "Mr");
		Stream stream16=stream15.peek(System.out::println);
		stream16.forEach(System.out::println);

	}
	
}
