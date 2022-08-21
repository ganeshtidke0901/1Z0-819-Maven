package uk.warley.ganesh.chapter15.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCommonTerminalOperations7 {
	public static void main(String[] args) {

		Stream<String> stream4 = Stream.iterate("Ganesh", s -> s.length() < 20, i -> i + i);
		stream4.forEach(System.out::println); // Ganesh
												// GaneshGanesh

//		long count = stream4.count();// java.lang.IllegalStateException: stream has already been operated upon or
//		System.out.println(count);

		Stream<String> stream5 = Stream.iterate("Ganesh", s -> s.length() < 20, i -> i + i);
		long count1 = stream5.count();// 2
		System.out.println(count1);// 2

		Stream<String> stream6 = Stream.of("Ganesh", "Ashwini", "a", "abc");
		Optional<String> optional = stream6.min((s1, s2) -> s1.compareTo(s2));// Comparator
		optional.ifPresent(s -> System.out.println("Min " + s));// Min Ashwini

		Stream<String> stream7 = Stream.of("Ganesh", "Ashwini", "Tidke", "a", "abc");
		Optional<String> optional1 = stream7.max((s1, s2) -> s1.compareTo(s2));// Comparator
		optional1.ifPresent(s -> System.out.println("Max " + s));// Max abc

		Stream<String> stream71 = Stream.of("Ganesh", "Ashwini", "Tidke", "a", "abc");
		Optional<String> optional11 = stream71.max(Comparator.comparingInt(String::length));// Comparator
		optional11.ifPresent(s -> System.out.println("Max " + s));// Max Ashwini

		Stream<String> stream8 = Stream.iterate("Ganesh", s -> s.length() < 20, i -> i + i);
		Optional<String> optional2 = stream8.max((s1, s2) -> s2.length() - s1.length());// Comparator
		optional2.ifPresent(System.out::println);// Ganesh

		Stream<Integer> stream9 = Stream.iterate(1, i -> i + i);// infinite stream
		Optional<Integer> optional3 = stream9.findAny();
		optional3.ifPresent(i -> System.out.println(i));// 1- any random element

		Stream<Integer> stream10 = Stream.iterate(1, i -> i + i);// infinite stream
		Optional<Integer> optional4 = stream10.findFirst();
		optional4.ifPresent(i -> System.out.println(i));// 1- very first element

		Stream<Integer> stream11 = Stream.iterate(1, i -> i + i);// infinite stream
		boolean b = stream11.anyMatch(i -> i < 10);// Predicate
		System.out.println(b);// true

		Stream<Integer> stream12 = Stream.iterate(1, i -> i + i);// infinite stream
		boolean b1 = stream12.noneMatch(i -> i < 10);// Predicate when i=1 ,predicate is true
		System.out.println(b1);// false

		Stream<Integer> stream13 = Stream.iterate(1, i -> i + i);// infinite stream
		boolean b2 = stream13.allMatch(i -> i < 10);// Predicate when i=10 ,predicate is false
		System.out.println(b2);// false

//		Stream<Integer> stream14 = Stream.iterate(1,  i -> i + i);//infinite stream
//		boolean b3= stream14.allMatch(i->true);//infinite operation
//		System.out.println(b3);//false
//		

		Stream<Float> stream15 = Stream.iterate(11f, f -> f < 50, i -> i + 2);
		stream15.forEach(System.out::print);// 11.013.015.017.019.021.023.025.027.029.031.033.035.037.039.041.043.045.047.049.0
		System.out.println();

		Stream<Integer> stream16 = Stream.iterate(1, f -> f < 5, i -> i + 2);// 1 3
		Optional<Integer> optional5 = stream16.reduce((i1, i2) -> i1 + i2);// Binary Operator
		optional5.ifPresent(System.out::println);// 4

		Stream<String> stream17 = Stream.of("Ganesh", "Tidke");
		String str = stream17.reduce("Mr", String::concat);// identity, Binary Operator
		System.out.println(str);// MrGaneshTidke

		Stream<String> stream18 = Stream.of("w", "o", "l", "f");
		Integer integer = stream18.reduce(100, (i, s) -> i + s.length(), (d, e) -> d + e + 1000);// identity,
																									// BiFunction-i=101,102,102,104,
																									// Binary Operator
		System.out.println(integer);// 104 //(d, e) -> d + e+1000 act as combiner when we run parallel stream

		List<String> list1 = List.of("w", "o", "l", "f");
		Integer integer1 = list1.parallelStream().reduce(100, (i, s) -> i + s.length(), (d, e) -> d + e + 1000);// identity,

		System.out.println(integer1);// 3404 //(d, e) -> d + e+1000 act as combiner when we run parallel stream

		Stream<String> stream19 = Stream.of("w", "o", "l", "f");
		StringBuilder builder = stream19.collect(StringBuilder::new,
				(stringBuilder, string) -> stringBuilder.append(string), StringBuilder::append);// last lambda act as
																								// combiner in parallel
																								// stream
		System.out.println(builder.toString());// wolf

		List<String> list = List.of("w", "o", "l", "f");
		StringBuilder builder1 = list.parallelStream().collect(StringBuilder::new,
				(stringBuilder, string) -> stringBuilder.append(string), StringBuilder::append);// last lambda act as
																								// combiner in parallel
																								// stream
		System.out.println(builder1.toString());// wolf

		List<String> list2 = List.of("w", "o", "l", "f");
		TreeSet<String> treeset = list2.parallelStream().collect(TreeSet::new, TreeSet::add, TreeSet::addAll);// last
																												// lambda
																												// act
																												// as
																												// combiner
																												// in
																												// parallel
																												// stream
		System.out.println(treeset.toString());// [f, l, o, w]

		List<String> list3 = List.of("w", "o", "l", "f");
		TreeSet<String> treeset1 = list3.parallelStream().collect(Collectors.toCollection(TreeSet::new));
		System.out.println(treeset1.toString());// [f, l, o, w]

		List<String> list4 = List.of("w", "o", "l", "f");
		Set<String> treeset2 = list4.parallelStream().collect(Collectors.toSet());
		System.out.println(treeset1.toString());// [f, l, o, w]
		System.out.println(treeset2.getClass());// class java.util.HashSet

		Integer[] aa = { 1, 2, 3, 4 };
		Set<Integer> dsfd = Arrays.stream(aa).collect(Collectors.toSet());

		int[] aa1 = { 1, 2, 3, 4 };
		Set<Integer> dsfd1 = Arrays.stream(aa1).mapToObj(s -> s).collect(Collectors.toSet());
		dsfd1.add(12);
		System.out.println(dsfd1);

		List<Integer> list22 = Arrays.asList(1, 2, 3, 4);
//		List<Integer> list22 = Arrays.asList(aa1); does not work as it expectes List<int[]>
		
		List<int[]> aa111;
		Object ss=aa1;
		Object ss0=aa;
		Object[] ss1=aa;
//		Object[] ss2=aa1;

		System.out.println(ss1.length);//4
		System.out.println(ss0);//[Ljava.lang.Integer;@13a57a3b
	}
}
