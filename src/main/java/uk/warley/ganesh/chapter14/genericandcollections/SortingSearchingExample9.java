package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingSearchingExample9 {
	public static void main(String[] args) {

		List<SortRabbits> list = new ArrayList<SortRabbits>();
		list.add(new SortRabbits());
		list.add(new SortRabbits());

//		Collections.sort(list); //compiler error as SortRabbits has to implement Comparable
		// OR
		Collections.sort(list, (s1, s2) -> s1.toString().compareTo(s2.toString()));

		List<SortMonkeys> monkeys = new ArrayList<SortMonkeys>();
		monkeys.add(new SortMonkeys());
		monkeys.add(new SortMonkeys());

		Collections.sort(monkeys);
		Collections.sort(monkeys, (s1, s2) -> s1.id - s2.id);

		var s = Arrays.asList(12, 10, 23, 100);

		System.out.println(Collections.binarySearch(s, 12));

		Collections.sort(s);// Integer implements Comparable
		System.out.println(Collections.binarySearch(s, 12));// 1
		System.out.println(Collections.binarySearch(s, 1));// -0-1=-1

		int[] arr = { 12, -1, 25, -8 };
		Arrays.sort(arr);

		System.out.println();
		Arrays.stream(arr).forEach(System.out::println);
		System.out.println();

		SortMonkeys[] arr2 = { new SortMonkeys(), new SortMonkeys() };
		Arrays.sort(arr2);
		Arrays.sort(arr2, (s1, s2) -> s1.id - s2.id);

	}
}

class SortRabbits {

}

class SortMonkeys implements Comparable<SortMonkeys> {
	int id;

	@Override
	public int compareTo(SortMonkeys o) {
		return 0;
	}

}