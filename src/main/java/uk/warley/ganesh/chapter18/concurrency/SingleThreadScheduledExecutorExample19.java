package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutorExample19 {

	public static void main(String[] args) {

		Runnable task1 = () -> {
			System.out.println("Printing Data1");
		};
		Runnable task2 = () -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Printing Data2");
		};

		Runnable task3 = () -> {
			System.out.println("Printing Data3");
		};

		Runnable task4 = () -> {
			System.out.println("Printing Data4");
		};
		ScheduledExecutorService executorService = null;
		executorService = Executors.newScheduledThreadPool(2);
		executorService.scheduleWithFixedDelay(task1, 5, 1, TimeUnit.SECONDS);
		executorService.scheduleWithFixedDelay(task2, 5, 1, TimeUnit.SECONDS);
		executorService.schedule(task3, 5, TimeUnit.SECONDS);
		executorService.submit(task4);

//		Printing Data4
//		Printing Data1
//		Printing Data3
//		Printing Data1
//		Printing Data1
//		Printing Data1
//		Printing Data1
//		Printing Data2
//		Printing Data1
//		Printing Data1
//		Printing Data1

	}
}