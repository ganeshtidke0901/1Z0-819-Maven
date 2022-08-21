package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutorExample15 {

	public static void main(String[] args) {

		Runnable task1 = () -> {
			System.out.println("Printing Data");
		};
		
		ScheduledExecutorService executorService = null;
		try {
			executorService = Executors.newSingleThreadScheduledExecutor();
			executorService.scheduleAtFixedRate(task1, 5,1,TimeUnit.SECONDS);

		} finally {
			if (executorService != null)
				executorService.shutdown();
		}
		
		
		//after 5 seconds of initial delay for each second
		//Nothing is printed as we stutdown the service on line 22
	}
}