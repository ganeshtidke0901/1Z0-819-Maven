package uk.warley.ganesh.chapter15.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdvancedStreamPipelinesCollectingResult15 {

	static void example1() {
		Stream<String> stream = Stream.of("Ganesh", "Tidke");

		BiConsumer<TreeSet<String>, String> biFunction = TreeSet::add;
		BiConsumer<TreeSet<String>, String> biFunction1 = (t, s) -> t.add(s);
		TreeSet<String> set = stream.collect(TreeSet::new, (s, str) -> s.add(str), TreeSet::addAll);// [Ganesh, Tidke]
		System.out.println(set);
	}

	private static void example2() {
		BiConsumer<TreeSet<String>, String> biFunction1 = (t, s) -> t.add(s);// here accpet does not return- t.add(s)
																				// return is not cosidered
		BiFunction<TreeSet<String>, String, Boolean> biFunction2 = (t, s) -> t.add(s);// here apply return- t.add(s) is
																						// considered
		BiFunction<TreeSet<String>, String, Boolean> biFunction3 = TreeSet::add;
	}

	private static void example3() {

		Stream<String> stream = Stream.of("G", "T", "I");
		String str = stream.collect(Collectors.joining("-"));
		System.out.println(str);// G-T-I

		// averagingDouble() or averagingLong return Double
		Stream<String> stream1 = Stream.of("G", "T", "I");
		Double double1 = stream1.collect(Collectors.averagingInt(s -> s.length()));
		System.out.println(double1);// 1.0
//		OptionalDouble s=	stream1.mapToInt(s->s.length()).average();
		

		Stream<String> stream2 = Stream.of("G", "T", "I");
		long count = stream2.collect(Collectors.counting());
		System.out.println(count);// 3

//		----------------
		Stream<String> stream3 = Stream.of("G", "T", "I");
		Optional<String> optional = stream3.collect(Collectors.maxBy((a, b) -> a.compareTo(b)));
		optional.ifPresent(System.out::println);// "T"
		
		Stream<String> stream31 = Stream.of("G", "T", "I");
		Optional<String> optional31 = stream31.max(Comparator.naturalOrder());
		optional31.ifPresent(System.out::println);// "T"
//		----------------

		Stream<String> stream4 = Stream.of("G", "T", "I");
		Optional<String> optional1 = stream4.collect(Collectors.minBy((a, b) -> a.compareTo(b)));
		optional1.ifPresent(System.out::println);// "G"

		Stream<String> stream5 = Stream.of("G", "T", "I");
		List<String> list = stream5.collect(ArrayList::new, (l, s) -> l.add(s), ArrayList::addAll);
		System.out.println(list);// [G, T, I]

		Stream<String> stream6 = Stream.of("G", "T", "I");
		list = stream6.collect(Collectors.toList());
		System.out.println(list);// [G, T, I]

		Stream<String> stream7 = Stream.of("G", "T", "I");
		Set<String> set1 = stream7.collect(Collectors.toSet());
		System.out.println(set1);// [T, G, I]

		Stream<String> stream8 = Stream.of("G", "T", "I");
		TreeSet<String> set2 = stream8.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(set2);// [T, G, I]

		Stream<String> stream9 = Stream.of("G", "T", "I");
		Map<String, Integer> map = stream9.collect(Collectors.toMap(s -> s, s -> s.length()));
		System.out.println(map);// {T=1, G=1, I=1}

//		Stream<String> stream10 = Stream.of("G", "T", "I");
//		Map<Integer,String> map1= stream10.collect(Collectors.toMap(s->s.length(), s->s));
//		System.out.println(map1);//java.lang.IllegalStateException: Duplicate key 1 (attempted merging values G and T)

		// to Avoid above duplication or what to do if we find multiple values for same key

		Stream<String> stream10 = Stream.of("G", "T", "Ganesh");
		Map<Integer, String> map1 = stream10
				.collect(Collectors.toMap(s -> s.length(), s -> s, (s1, s2) -> s1 + "--" + s2));
		System.out.println(map1);// {1=G--T, 6=Ganesh}

		Stream<String> stream11 = Stream.of("G", "T", "Ganesh");
		HashMap<Integer, String> map11 = stream11
				.collect(Collectors.toMap(s -> s.length(), s -> s, (s1, s2) -> s1 + "--" + s2, HashMap::new));
		System.out.println(map11);// {1=G--T, 6=Ganesh}

		Stream<String> stream121 = Stream.of("G", "T", "Ganesh");
		HashMap<String,Integer> map121 = stream121
				.collect(Collectors.toMap(s -> s, s -> s.length(), (s1, s2) -> s1 +s2, HashMap::new));
		System.out.println("---"+map121);// ---{Ganesh=6, T=1, G=1}
		
		Stream<String> stream12 = Stream.of("Tidke", "ABCDE", "Ganesh");
		Map<Integer, List<String>> map12 = stream12.collect(Collectors.groupingBy(s -> s.length()));
		System.out.println(map12);// {5=[Tidke, ABCDE], 6=[Ganesh]}

		Stream<String> stream13 = Stream.of("Tidke", "ABCDE", "Ganesh");
		Map<Integer, Set<String>> map13 = stream13.collect(Collectors.groupingBy(s -> s.length(), Collectors.toSet()));
		System.out.println(map12);// {5=[Tidke, ABCDE], 6=[Ganesh]}

		Stream<String> stream14 = Stream.of("Tidke", "ABCDE", "Ganesh");
		HashMap<Integer, Set<String>> map14 = stream14
				.collect(Collectors.groupingBy(s -> s.length(), HashMap::new, Collectors.toSet()));
		System.out.println(map12);// {5=[Tidke, ABCDE], 6=[Ganesh]}

		Stream<String> stream15 = Stream.of("Tidke", "ABCDE", "Ganesh");
		Map<Boolean, List<String>> map15 = stream15.collect(Collectors.partitioningBy(s -> s.length() > 5));
		System.out.println(map15);// {false=[Tidke, ABCDE], true=[Ganesh]}

		Stream<String> stream16 = Stream.of("Tidke", "ABCDE", "Ganesh");
		Map<Boolean, Set<String>> map16 = stream16
				.collect(Collectors.partitioningBy(s -> s.length() > 5, Collectors.toSet()));
		System.out.println(map16);// {false=[ABCDE, Tidke], true=[Ganesh]}

		Stream<String> stream17 = Stream.of("Tidke", "ABCDE", "Ganesh");
		HashMap<Integer, Long> map17 = stream17
				.collect(Collectors.groupingBy(s -> s.length(), HashMap::new, Collectors.counting()));
		System.out.println(map17);// {5=2, 6=1}

		Stream<String> stream18 = Stream.of("Tidke", "ABCDE", "Ganesh");
		HashMap<Integer,Optional<Character>> map18=stream18.collect(Collectors.groupingBy(s -> s.length(),HashMap::new,Collectors.mapping(s1->s1.charAt(0),Collectors.minBy((a,b)->a-b))));
		System.out.println(map18);// {5=Optional[A], 6=Optional[G]}

	}

	private static void example4() {

	}

	public static void main(String[] args) {
		example1();
		example2();
		example3();
//		example4();

	}

}
