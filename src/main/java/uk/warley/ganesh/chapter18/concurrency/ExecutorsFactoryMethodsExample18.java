package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ExecutorsFactoryMethodsExample18 {

	public static void main(String[] args) {

		Runnable task1 = () -> {
			System.out.println("Printing Data");
		};


		ExecutorService executorService=Executors.newSingleThreadExecutor();
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		ExecutorService cachedThreadPoolService=Executors.newCachedThreadPool();
		ExecutorService fixedThreadPoolService=Executors.newFixedThreadPool(10);
		ExecutorService scheduledThreadPoolService=Executors.newScheduledThreadPool(10);
		
		
		System.out.println(Runtime.getRuntime().availableProcessors());//8 processors/CPUs
		
		

	}
}