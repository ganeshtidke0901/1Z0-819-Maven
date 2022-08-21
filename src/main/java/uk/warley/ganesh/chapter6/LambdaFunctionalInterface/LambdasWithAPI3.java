package uk.warley.ganesh.chapter6.LambdaFunctionalInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LambdasWithAPI3 {
	public static void main(String[] args) {
//		example1();
		example2();
	}

	private static void example1() {
		List<String> list = List.of("Ganesh", "Tidke");
		List<String> list2 = new ArrayList<String>(list);
		list2.removeIf(s -> s.startsWith("T"));
		System.out.println(list);

	}

	private static void example2() {
		List<String> list = List.of("Ganesh", "Tidke");
		List<String> list2 = new ArrayList<String>(list);
		list2.sort((s1, s2) -> s1.compareTo(s2));
		System.out.println(list);

		list2.forEach(s -> System.out.println(s));
		
		
		Collections.sort(list2);
		System.out.println(list2);//[Ganesh, Tidke]
		Collections.sort(list);//Exception in thread "main" java.lang.UnsupportedOperationException
		System.out.println(list);
		
	}

	private static void example3() {
		List list = List.of(1, 2, 3);
		Set set = Set.of(1, 2, 3);
		Map map = Map.of(1, 2, 3, 4);

		list.forEach(s -> System.out.println(s));
		set.forEach(s -> System.out.println(s));
		map.keySet().forEach(s -> System.out.println(s));

	}
}
