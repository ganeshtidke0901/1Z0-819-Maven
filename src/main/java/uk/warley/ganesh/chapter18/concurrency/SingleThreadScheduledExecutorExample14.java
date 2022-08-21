package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutorExample14 {

	public static void main(String[] args) {

		Runnable task1 = () -> {
			System.out.println("Printing Data");
		};
		
		ScheduledExecutorService executorService = null;
		try {
			executorService = Executors.newSingleThreadScheduledExecutor();
		 ScheduledFuture<?> ss=	executorService.schedule(task1, 5,TimeUnit.SECONDS);

		} finally {
			if (executorService != null)
				executorService.shutdown();
		}
		
		
		//after 5 seconds of initial delay
		//Printing Data
	}
}