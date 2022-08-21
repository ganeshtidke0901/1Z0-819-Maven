package uk.warley.ganesh.chapter18.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentClassesExample29 {
	static ArrayList<String> s = new ArrayList<String>();
	static Collection<String> s1 = Collections.synchronizedCollection(new ArrayList<String>());

	static void example1() {
		var map = new HashMap<String, Integer>();
		map.put("Penguin", 1);
		map.put("flamingo", 2);

		for (String string : map.keySet()) {
//			map.remove(string);//java.util.ConcurrentModificationException
		}

		var map2 = new ConcurrentHashMap<String, Integer>();
		map2.put("Penguin", 1);
		map2.put("flamingo", 2);

		for (String string : map2.keySet()) {
			map2.remove(string);
		}

		System.out.println(map2);// {}

	}

	static void example2() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 5; i++) {
			executorService.submit(() -> {
				addToCollection();
			});
		}
		executorService.shutdown();
		try {
			executorService.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(s);

//		[Ganesh, Ganesh, Ganesh]
//      [Ganesh, Ganesh, Ganesh, Ganesh, Ganesh]

	}

	public static void addToCollection() {
		s.add("Ganesh");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void example3() {
		ExecutorService executorService1 = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 5; i++) {
			executorService1.submit(() -> {
				addToCollection1();
			});
		}
		executorService1.shutdown();

		try {
			executorService1.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(s1);
		// [Ganesh, Ganesh, Ganesh, Ganesh, Ganesh]
		// [Ganesh, Ganesh, Ganesh, Ganesh, Ganesh]
		// [Ganesh, Ganesh, Ganesh, Ganesh, Ganesh]
		// always consistent with one method and both as well
	}
	public static void addToCollection1() {
		s1.add("Ganesh");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void example4() {
	}

	static void example5() {
	}

	static void example6() {
	}

	static void example7() {
	}

	public static void main(String[] args) {

//		example2();
		example3();

	}

	public static void removeFromCollection() {
		s.remove("Ganesh");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void removeFromCollection1() {
		s1.remove("Ganesh");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}