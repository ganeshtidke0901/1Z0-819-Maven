package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample10 implements Comparable<ComparableExample10> {// Type parameter does not have to be same
																				// class name , it could be String
	private int id;
	private String name;

	@Override
	public String toString() {
		return id + "-" + name;
	}

	public ComparableExample10(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public int compareTo(ComparableExample10 o) {
		return this.id - o.id;
	}

	public static void main(String[] args) {
		List<ComparableExample10> list = new ArrayList<ComparableExample10>();
		list.add(new ComparableExample10(2, "Ganesh"));
		list.add(new ComparableExample10(1, "Ashwini"));

		Collections.sort(list);
		System.out.println(list);

		list.add(null);
		System.out.println(list);// [1-Ashwini, 2-Ganesh, null]
		Collections.sort(list);// java.lang.NullPointerException , list got null value

		List<AGG> aggs = new ArrayList<AGG>();
		aggs.add(new AGG());
		aggs.add(new AGG());

//		Collections.sort(aggs);//AGG does not implement Comparable hence compile error

	}

}

class AGG {

}