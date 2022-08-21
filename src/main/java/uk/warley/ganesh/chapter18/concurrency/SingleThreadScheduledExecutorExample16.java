package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutorExample16 {

	public static void main(String[] args) {

		Runnable task1 = () -> {
			System.out.println("Printing Data");
		};

		ScheduledExecutorService executorService = null;
		executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.scheduleAtFixedRate(task1, 5, 1, TimeUnit.SECONDS);

		// after 5 seconds of initial delay for each second and it does not shutdown until it is shutdown explicitly
//			Printing Data
//			Printing Data
//			Printing Data
//			Printing Data
//			Printing Data
//			Printing Data
//			.....

	}
}