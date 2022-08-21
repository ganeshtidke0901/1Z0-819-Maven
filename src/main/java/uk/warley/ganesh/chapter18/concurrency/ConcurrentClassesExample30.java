package uk.warley.ganesh.chapter18.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



public class ConcurrentClassesExample30 {

	static ArrayList<String> s = new ArrayList<String>();
	static Collection<String> s1=Collections.synchronizedCollection(new ArrayList<String>());
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 5; i++) {
			executorService.submit(() -> {
				addToCollection();
				removeFromCollection();
			});
		}
		executorService.shutdown();

		try {
			executorService.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(s);
		
//		[Ganesh, Ganesh, Ganesh, Ganesh]
//     [Ganesh, Ganesh, Ganesh]
		//[null, null, null, null, null, null, null, null]
		
		

		ExecutorService executorService1 = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 5; i++) {
			executorService1.submit(() -> {
				addToCollection1();
				removeFromCollection1();
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
		//[]
		//[]
		//[]
		
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

	public static void removeFromCollection() {
		s1.remove("Ganesh");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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