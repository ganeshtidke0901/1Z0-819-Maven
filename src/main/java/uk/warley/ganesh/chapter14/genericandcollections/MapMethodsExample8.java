package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiFunction;

public class MapMethodsExample8 {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(null, null);
		map.put(1, 100);
		map.put(2, 200);
		System.out.println(map.containsKey(null));// true
		System.out.println(map);// {null=null, 1=100, 2=200}
		System.out.println(map.containsValue(null));// true

		System.out.println(map.get(2));// 200
		map.put(2, 2000);
		System.out.println(map);// {null=null, 1=100, 2=2000}

		System.out.println(map.remove(null));// null
		System.out.println(map);// {1=100, 2=2000}

		map.putIfAbsent(2, 4000);
		System.out.println(map);// {1=100, 2=2000}

		System.out.println(map.getOrDefault(3, 5000));// 5000

		System.out.println(map.isEmpty());// false

		map.replace(3, 3000);// if key set already in map
		System.out.println(map);

		Set<Entry<Integer, Integer>> entryset = map.entrySet();

		map.forEach((p, q) -> System.out.println("key-" + p + " Value:" + q));// key-1 Value:100
																				// key-2 Value:2000

		map.keySet().forEach(System.out::println);// 1 2
		map.values().forEach(s -> System.out.println(s));
		map.values().forEach(System.out::println);
		map.replaceAll((p, q) -> p + q);
		System.out.println(map);// {1=101, 2=2002}

		map.entrySet().forEach(s -> System.out.println(s.getKey() + ":" + s.getValue()));
		System.out.println(map);// {1=101, 2=2002}

		BiFunction<Integer, Integer, Integer> biFunction = (v1, v2) -> v1 + v2;
		map.merge(1, 50, biFunction);
		map.merge(3, 50, biFunction);
		System.out.println(map);// {1=151, 2=2002, 3=50}

		BiFunction<Integer, Integer, Integer> biFunction1 =(v1, v2) -> null;
		map.merge(3, 50, biFunction1);// key-value is removed
		System.out.println(map);// {1=151, 2=2002}

		map.put(4, null);
		System.out.println(map);//{1=151, 2=2002, 4=null}
		map.merge(4, 50, biFunction);//funcrtion is not called and neew value is inserted
		System.out.println(map);//{1=151, 2=2002, 4=50}

		
//		map.merge(4, null, biFunction);//java.lang.NullPointerException
		
		
		map.merge(5, 500, biFunction);//new key-value added as 5 not in map
		System.out.println(map);//{1=151, 2=2002, 4=50, 5=500}
	
		
		
		
	}
}
