package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SingleThreadExecutorExample10 {

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

		System.out.println(future1.isDone());//false
		System.out.println(future2.isDone());//false
		System.out.println(future3.isDone());//false

		System.out.println(future1.isCancelled());//false
		System.out.println(future2.isCancelled());//false
		System.out.println(future3.isCancelled());//false

		try {
			System.out.println(future1.get());// Waits if necessary for the computation to complete, and then retrieves
												// its result.
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(future2.get(2, TimeUnit.SECONDS));// Waits if necessary for at most the given time
																		// for
																		// the computation
																		// * to complete, and then retrieves its result,
																		// if
																		// available.
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();//java.util.concurrent.TimeoutException
		}

		future3.cancel(false);// cancels if not running
		future3.cancel(true);// cancels even if running by interrupting
		System.out.println("--"+future3.isCancelled());//--true
		System.out.println("--"+future3.isDone());//--true
		
		
		try {
			System.out.println(future3.get());// Waits if necessary for the computation to complete, and then retrieves
												// its result.
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();//java.util.concurrent.CancellationException //Runtime Exception as task was already cancelled before execution 
								//so there wont be any Interruption or Execution exception
		}
	
		
		System.out.println("End of main");

//		Printing Data
//		Ganesh
//		Printing inventory:0
//		Printing inventory:1
//		Printing inventory:2
//		java.util.concurrent.TimeoutException
//			at java.base/java.util.concurrent.FutureTask.get(FutureTask.java:204)
//			at uk.warley.ganesh/uk.warley.ganesh.chapter17.concurrency.SingleThreadExecutorExample10.main(SingleThreadExecutorExample10.java:63)
//		Exception in thread "main" java.util.concurrent.CancellationException
//			at java.base/java.util.concurrent.FutureTask.report(FutureTask.java:121)
//			at java.base/java.util.concurrent.FutureTask.get(FutureTask.java:191)
//			at uk.warley.ganesh/uk.warley.ganesh.chapter17.concurrency.SingleThreadExecutorExample10.main(SingleThreadExecutorExample10.java:78)
//		Printing inventory:3
//		Printing inventory:4


	}
}