package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample11 implements Comparable<ComparatorExample11> {
	private int id;
	private String name;

	@Override
	public String toString() {
		return id + "-" + name;
	}

	public ComparatorExample11(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public int compareTo(ComparatorExample11 o) {
		if (o == null)
			throw new IllegalArgumentException("poorely formed object");
		return this.id - o.id;
	}

	public static void main(String[] args) {
		List<ComparatorExample11> list = new ArrayList<ComparatorExample11>();
		list.add(new ComparatorExample11(2, "Ganesh"));
		list.add(new ComparatorExample11(1, "Ashwini"));

		Collections.sort(list);
		System.out.println(list);//[1-Ashwini, 2-Ganesh]

		Comparator<ComparatorExample11> comparator = (o1, o2) -> o2.id - o1.id;

		Collections.sort(list,comparator);
		System.out.println(list);//[2-Ganesh, 1-Ashwini]
	}

}
