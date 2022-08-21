package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProtectingDataWithAtomicClassesExample20 {
	private int sheepCount = 0;

	private void incrementAndReport() {
		System.out.print((++sheepCount) + " ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {

		// need to slowdown processor
		generateThreads();
		
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		var aa = new ProtectingDataWithAtomicClassesExample20();

		try {
			for (int i = 0; i < 10; i++) {
				executorService.submit(() -> {
					aa.incrementAndReport();
				});
			}
		} finally {
			if (executorService != null)
				executorService.shutdown();
		}
		
		//might print 
		//1 10 9 4 3 8 5 2 7 6 
		//1 2 4 3 8 5 2 7 6 - two times 2 digit

	}
	
	

	public static void generateThreads() {
		ExecutorService executorService = Executors.newFixedThreadPool(100000000);
		try {
		
		for (int i = 0; i <1000; i++) {
		executorService.submit(()->{try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
		}} finally {
			// TODO: handle finally clause
					if (executorService != null)
						executorService.shutdown();
	}
	
	
	}
}