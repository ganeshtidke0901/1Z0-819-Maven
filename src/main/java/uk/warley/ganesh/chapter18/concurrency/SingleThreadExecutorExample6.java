package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadExecutorExample6 {

	public static void main(String[] args) {

		Runnable task1 = () -> System.out.println("Printing Data");
		Runnable task2 = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Printing inventory:" + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		};
		ExecutorService executorService = null;
		try {
			executorService = Executors.newSingleThreadExecutor();
			Future<?> future1 = executorService.submit(task1);
			Future<?> future2 = executorService.submit(task2);
			Future<?> future3 = executorService.submit(task1);

		} finally {
			if (executorService != null)
				executorService.shutdown();
		}
		
		
		System.out.println("End of main");

		
//		End of main
//		Printing Data
//		Printing inventory:0
//		Printing inventory:1
//		Printing inventory:2
//		Printing inventory:3
//		Printing inventory:4
//		Printing Data
	}
}