package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionNullExample24 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add(null);
		list.add(null);
		System.out.println(list);//[null, null]
		
		List<String> list2=new LinkedList<String>();
		list2.add(null);
		list2.add(null);
		System.out.println(list2);//[null, null]

		
		Set<String> set=new HashSet<String>();
		set.add(null);
		set.add(null);
		System.out.println(set);//[null]
		
		Set<String> set2=new TreeSet<String>();
//		set2.add(null);//java.lang.NullPointerException is not allowed in any sorted collection
		System.out.println(set);
		
		Map<String, String> map=new HashMap<String, String>();
		map.put(null, null);
		map.put(null, null);
		System.out.println(map);//{null=null}
		
		
		Map<String, String> map2=new TreeMap<String, String>();
//		map2.put(null, null);//java.lang.NullPointerException is not allowed in any sorted collection
		System.out.println(map);
		
		
		
		
	}
}
