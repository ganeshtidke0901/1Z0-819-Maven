package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionExtras23 {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>(12);
		List<String> list3 = new ArrayList<String>(list2);

		Queue<String> queue1 = new LinkedList<String>();
		List<String> queue3 = new LinkedList<String>(queue1);

		Set<Boolean> set1 = new HashSet<>();
		Set<Boolean> set2 = new HashSet<>(12);
		Set<Boolean> set3 = new HashSet<>(set1);

		Set<Float> set4 = new TreeSet<>();
		Set<Float> set6 = new TreeSet<Float>(set4);
		Set<Float> set7 = new TreeSet<Float>((p, q) -> p.compareTo(q));

		
		
		Map<String, String> map1=new HashMap<String, String>();
		Map<String, String> map2=new HashMap<String, String>(12);
		Map<String, String> map3=new HashMap<String, String>(map1);
		
		Map<String, String> map4=new TreeMap<String, String>();
		Map<String, String> map6=new TreeMap<String, String>(map1);
		Map<String, String> map7=new TreeMap<String, String>((p, q) -> p.compareTo(q));
		
		
		
	}

}
