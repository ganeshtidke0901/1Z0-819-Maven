package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample5 {

	public static void main(String[] args) {

		Runnable task1 = () -> System.out.println("Printing Data");
		Runnable task2 = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Printing inventory:" + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		};
		
	
		ExecutorService executorService=Executors.newSingleThreadExecutor();
		executorService.execute(task1);
		executorService.execute(task2);
		executorService.execute(task1);
		executorService.shutdown();//any cost we need to shutdown otherwise it is alive and program wont terminate. hence put it in finallyblock
		System.out.println("End of Main");
//		End of Main
//		Printing Data
//		Printing inventory:0
//		Printing inventory:1
//		Printing inventory:2
//		Printing inventory:3
//		Printing inventory:4
//		Printing Data
		

	}
}