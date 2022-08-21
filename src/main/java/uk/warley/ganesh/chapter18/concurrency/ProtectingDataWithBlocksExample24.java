package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProtectingDataWithBlocksExample24 {
	private int sheepCount = 0;
	private Lock lock=new ReentrantLock();
	private  void incrementAndReport() {

		if(lock.tryLock()) {
			System.out.println("able to obtain the lock");
			try {
				System.out.print((++sheepCount) + " ");
			} finally {
				lock.unlock();
			}
		}else
			System.out.println("unable to aquire lock");
		

	}

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(20);
		var aa = new ProtectingDataWithBlocksExample24();

		try {
			for (int i = 0; i < 10; i++) {
				executorService.submit(() -> {
					aa.incrementAndReport();
				});
			}
		} finally {
			if (executorService != null)
				executorService.shutdown();
		}

		// might print
		
//		able to obtain the lock
//		unable to aquire lock
//		unable to aquire lock
//		1 unable to aquire lock
//		unable to aquire lock
//		unable to aquire lock
//		unable to aquire lock
//		unable to aquire lock
//		unable to aquire lock
//		unable to aquire lock

	}

}