package uk.warley.ganesh.chapter18.concurrency;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentClassesExample32 {

	static LinkedList<String> linkedList = new LinkedList<String>();
	static ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<String>();

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

		System.out.println(linkedList.size());
		//-1
		//2
		//0
		
		

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
			e.printStackTrace();
		}

		System.out.println(concurrentLinkedQueue);
		//[]
		//[]
		//[]
	}

	public static void addToCollection() {
		linkedList.add("Ganesh");
	}

	public static void removeFromCollection() {
		linkedList.remove();
	}

	public static void addToCollection1() {
		concurrentLinkedQueue.add("Ganesh");
	}

	public static void removeFromCollection1() {
		concurrentLinkedQueue.remove();
	}

}