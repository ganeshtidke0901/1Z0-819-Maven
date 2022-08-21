package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutorExample12 {

	public static void main(String[] args) {

		Runnable task1 = () -> {
			System.out.println("Printing Data");
		};
		ScheduledExecutorService executorService = null;
		try {
			executorService = Executors.newSingleThreadScheduledExecutor();
			executorService.submit(task1);// all ExecutorService methods will work as is

		} finally {
			if (executorService != null)
				executorService.shutdown();
		}
		
//		executorService.shutdownNow();//terminate right away
		// Printing Data

	
	}
}