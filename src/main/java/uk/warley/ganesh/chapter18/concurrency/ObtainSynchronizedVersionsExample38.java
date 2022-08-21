package uk.warley.ganesh.chapter18.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class ObtainSynchronizedVersionsExample38 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();

		list.add("Ganesh");
		list.add("Tidke");

		Collection<String> collection = Collections.synchronizedCollection(list);
		collection.add("Mr.");
		System.out.println(collection);// [Ganesh, Tidke, Mr.]
		System.out.println(list);// [Ganesh, Tidke, Mr.]

		List<String> synchList = Collections.synchronizedList(list);
		synchList.add("Ashwini");
		System.out.println(synchList);// [Ganesh, Tidke, Mr., Ashwini]
		System.out.println(list);// [Ganesh, Tidke, Mr., Ashwini]

		Map<String, String> map = new HashMap<String, String>();
		map.put("Ganesh", "Tidke");

		Map<String, String> synchMap = Collections.synchronizedMap(map);
		synchMap.put("Ganesh1", "Tidke1");

		System.out.println(synchMap);// {Ganesh=Tidke, Ganesh1=Tidke1}
		System.out.println(map);// {Ganesh=Tidke, Ganesh1=Tidke1}

		Set<String> set = new HashSet<String>();
		set.add("ABC");
		Set<String> syncySet = Collections.synchronizedSet(set);
		syncySet.add("XYZ");
		System.out.println(syncySet);// [ABC, XYZ]
		System.out.println(set);// [ABC, XYZ]

		SortedSet<String> sortedSet = Collections.synchronizedSortedSet(new TreeSet<String>());
		SortedMap<String, String> sortedMap = Collections.synchronizedSortedMap(new TreeMap<String, String>());

		NavigableSet<String> navigableSet = Collections.synchronizedNavigableSet(new TreeSet<String>());
		NavigableMap<String, String> navigableMap = Collections.synchronizedNavigableMap(new TreeMap<String, String>());

		
		
		
		
	}
}