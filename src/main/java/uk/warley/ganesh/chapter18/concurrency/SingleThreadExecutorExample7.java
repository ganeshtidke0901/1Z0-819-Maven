package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadExecutorExample7 {

	public static void main(String[] args) {

		Callable<String> task1 = () -> {
			System.out.println("Printing Data");
			return "Ganesh";
		};
		
		Callable<String> task2 = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Printing inventory:" + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			return "Tidke";
		};
		ExecutorService executorService = null;
		Future<String> future1;
		Future<String> future2;
		Future<String> future3;
		try {
			executorService = Executors.newSingleThreadExecutor();
			future1 = executorService.submit(task1);
			future2 = executorService.submit(task2);
			future3 = executorService.submit(task1);

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