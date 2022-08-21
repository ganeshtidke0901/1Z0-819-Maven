package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample14 {
	public static void main(String[] args) {
		List<Platypus> list = Arrays.asList(new Platypus("Paula", 3), new Platypus("Peter", 7),
				new Platypus("Peter", 5),new Platypus("XYZ", 0));

		Collections.sort(list, Comparator.comparing(Platypus::getBeakLength).reversed());
		System.out.println(list);//[7, 5, 3, 0]
		
		Collections.sort(list, Comparator.comparing(Platypus::getName).thenComparingInt(Platypus::getBeakLength));
		System.out.println(list);//[3, 5, 7, 0]

		
		Collections.sort(list, Comparator.comparing(Platypus::getName).thenComparingInt(Platypus::getBeakLength).reversed());
		System.out.println(list);//[0, 7, 5, 3]
//		
//		
		Collections.sort(list, Comparator.comparing(Platypus::getName).thenComparing(Comparator.comparing(Platypus::getBeakLength).reversed()));
		System.out.println(list);//[3, 7, 5, 0]
		

	}
}

class Platypus {
	private String name;
	private int beakLength;

	public Platypus(String name, int beakLength) {
		super();
		this.name = name;
		this.beakLength = beakLength;
	}

	public int getBeakLength() {
		return beakLength;
	}

	public void setBeakLength(int beakLength) {
		this.beakLength = beakLength;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "" + beakLength;
	}
}
