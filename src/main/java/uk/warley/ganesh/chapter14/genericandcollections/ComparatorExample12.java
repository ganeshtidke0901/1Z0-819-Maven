package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample12 {
	public static void main(String[] args) {
		List<Squirrel> list = new ArrayList<Squirrel>();
		list.add(new Squirrel(2, "ABC"));
		list.add(new Squirrel(1, "ABC"));
		list.add(new Squirrel(5, "PQR"));
		list.add(new Squirrel(4, "PQR"));
		list.add(new Squirrel(1, "XYZ"));
		Collections.sort(list, new MultiFieldComparator());
		System.out.println(list);//[1-ABC, 2-ABC, 4-PQR, 5-PQR, 1-XYZ]
		
	}
}

class Squirrel {
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

	public Squirrel(int id, String name) {
		this.weight = id;
		this.species = name;
	}

}

class MultiFieldComparator implements Comparator<Squirrel> {

	@Override
	public int compare(Squirrel o1, Squirrel o2) {
		int result = o1.getSpecies().compareTo(o2.getSpecies());
		if (result != 0) {
			return result;
		}

		return o1.getWeight() - o2.getWeight();
	}
}
