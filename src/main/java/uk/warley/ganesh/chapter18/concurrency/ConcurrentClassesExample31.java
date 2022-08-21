package uk.warley.ganesh.chapter18.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



public class ConcurrentClassesExample31 {

	static HashMap<Integer,String> s = new HashMap<Integer,String>();
	static ConcurrentHashMap<Integer,String> s1 = new ConcurrentHashMap<Integer,String>();
	public static void main(String[] args) {

		s.put(1, "Ganesh");
		s.put(2, "Ganesh");
		s.put(3, "Ganesh");
		s.put(4, "Ganesh");
		s.put(5, "Ganesh");
		
		s1.put(1, "Ganesh");
		s1.put(2, "Ganesh");
		s1.put(3, "Ganesh");
		s1.put(4, "Ganesh");
		s1.put(5, "Ganesh");
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 5; i++) {
			executorService.submit(() -> {
				for (int j = 0; j < 5; j++) {
					removeFromCollection(j+1);
					
				}
				
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
				for (int j = 0; j < 5; j++) {
					removeFromCollection1(j+1);
					
				}
				
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

	public static void addToCollection(int a) {
		s.put(a,"Ganesh");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void removeFromCollection(int a) {
		s.remove(a);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void addToCollection1(int a) {
		s1.put(a,"Ganesh");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void removeFromCollection1(int a) {
		s1.remove(a);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}