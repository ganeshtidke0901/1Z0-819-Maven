package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SingleThreadExecutorExample11 {

	public static void main(String[] args) {

		Runnable task1 = () -> {
			System.out.println("Printing Data");
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
		try {
			executorService = Executors.newSingleThreadExecutor();
			executorService.submit(task1);
			executorService.submit(task2);
			executorService.submit(task1);

		} finally {
			if (executorService != null)
				executorService.shutdown();
		}

		if (executorService != null) {
			try {
				executorService.awaitTermination(2, TimeUnit.SECONDS);// Blocks until all tasks have completed execution
																		// after a shutdown
																		// * request, or the timeout occurs, or the
																		// current thread is
																		// * interrupted, whichever happens first.

				
				System.out.println(executorService.isShutdown());
				if(executorService.isTerminated())//all tasks finished following shutdown
				{
					System.out.println("All tasks completed");
				}else
				{
					System.out.println("at least one task is running...");
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println("End of main");

		
//		Printing Data
//		Printing inventory:0
//		Printing inventory:1
//		at least one task is running...
//		End of main
//		Printing inventory:2
//		Printing inventory:3
//		Printing inventory:4
//		Printing Data
	}
}