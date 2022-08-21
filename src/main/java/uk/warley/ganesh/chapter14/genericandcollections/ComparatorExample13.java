package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample13 {
	public static void main(String[] args) {
		List<Squirrel1> list = new ArrayList<Squirrel1>();
		list.add(new Squirrel1(2, "ABC"));
		list.add(new Squirrel1(5, "PQR"));
		list.add(new Squirrel1(4, "PQR"));
		list.add(new Squirrel1(1, "XYZ"));
		list.add(new Squirrel1(1, "ABC"));
		System.out.println(list);// [2-ABC, 5-PQR, 4-PQR, 1-XYZ, 1-ABC]
//		Collections.<Squirrel1>sort(list, Comparator.comparing(Squirrel1::getSpecies));//also valid

		Collections.sort(list, Comparator.comparing(s -> s.getSpecies()));
		System.out.println(list);// [2-ABC, 1-ABC, 5-PQR, 4-PQR, 1-XYZ]
		Collections.sort(list, Comparator.comparing(s -> s.getWeight()));
		System.out.println(list);// [1-ABC, 1-XYZ, 2-ABC, 4-PQR, 5-PQR]

		Collections.sort(list, Comparator.comparing(Squirrel1::getSpecies).thenComparing(Squirrel1::getWeight));
		System.out.println(list);// [1-ABC, 2-ABC, 4-PQR, 5-PQR, 1-XYZ]

		Collections.sort(list, Comparator.comparing(Squirrel1::getSpecies).thenComparingLong(Squirrel1::getWeight));
		System.out.println(list);// [1-ABC, 2-ABC, 4-PQR, 5-PQR, 1-XYZ]

		Collections.sort(list,
				Comparator.comparing(Squirrel1::getSpecies).thenComparingLong(Squirrel1::getWeight).reversed());
		System.out.println(list);// [1-XYZ, 5-PQR, 4-PQR, 2-ABC, 1-ABC]

		Collections.sort(list, Comparator.comparingDouble(Squirrel1::getWeight));
		System.out.println(list);// [1-XYZ, 1-ABC, 2-ABC, 4-PQR, 5-PQR]

		Collections.sort(list,
				Comparator.comparing(Squirrel1::getSpecies).thenComparing(Comparator.comparing(Squirrel1::getWeight)));
		System.out.println(list);// [1-ABC, 2-ABC, 4-PQR, 5-PQR, 1-XYZ]

		Collections.sort(list, Comparator.comparing(Squirrel1::getSpecies)
				.thenComparing(Comparator.comparing(Squirrel1::getWeight).reversed()));
		System.out.println("--" + list);// [2-ABC, 1-ABC, 5-PQR, 4-PQR, 1-XYZ]

//		Collections.sort(list, Comparator.naturalOrder());//Squirrel needs to implement Comparable(order set by Comparable)
//		System.out.println("Natural order:"+list);//Natural order:[1-XYZ, 1-ABC, 2-ABC, 4-PQR, 5-PQR]
//		Collections.sort(list, Comparator.reverseOrder());// Squirrel needs to implement Comparable(reverse of order set by Comparable)
//		System.out.println("Reverese order:"+list);//Natural order:[1-XYZ, 1-ABC, 2-ABC, 4-PQR, 5-PQR]


	}
}

class Squirrel1
//implements Comparable<Squirrel1> 
{
	private int weight;
	private String species;

	@Override
	public String toString() {
		return weight + "-" + species;
	}

	public int getWeight() {
		return weight;
	}

	public String getSpecies() {
		return species;
	}

	public Squirrel1(int id, String name) {
		this.weight = id;
		this.species = name;
	}

//	@Override
//	public int compareTo(Squirrel1 o) {
//		return this.weight - o.weight;
//	}

}
