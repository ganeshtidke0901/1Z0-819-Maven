package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutorExample13 {

	public static void main(String[] args) {

		Callable<String> task2 = () -> {
			System.out.println("Printing Data");
			return "Ganesh";
		};
		
		ScheduledExecutorService executorService = null;
		try {
			executorService = Executors.newSingleThreadScheduledExecutor();
			ScheduledFuture<String>s= executorService.schedule(task2, 5,TimeUnit.SECONDS);

		} finally {
			if (executorService != null)
				executorService.shutdown();
		}

	
	}
}