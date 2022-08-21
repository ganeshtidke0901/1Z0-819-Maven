package uk.warley.ganesh.chapter18.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class SingleThreadExecutorExample8 {

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
		
		
		List<Callable<String>> callables=new ArrayList<Callable<String>>();
		callables.add(task1);
		callables.add(task2);
		callables.add(task1);
		
		
		ExecutorService executorService = null;
		List<Future<String>> futures;
		try {
			executorService = Executors.newSingleThreadExecutor();
			futures=executorService.invokeAll(callables);//invokeAll waits for all tasks to be completed

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (executorService != null)
				executorService.shutdown();
		}
		System.out.println("End of main");

		
//		Printing Data
//		Printing inventory:0
//		Printing inventory:1
//		Printing inventory:2
//		Printing inventory:3
//		Printing inventory:4
//		Printing Data
//		End of main
	}
}