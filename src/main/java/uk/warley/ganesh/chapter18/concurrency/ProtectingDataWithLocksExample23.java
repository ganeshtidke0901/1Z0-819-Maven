package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProtectingDataWithLocksExample23 {
	private int sheepCount = 0;
	private Lock lock=new ReentrantLock();
	private  void incrementAndReport() {
		try {
			lock.lock();
			System.out.print((++sheepCount) + " ");
			
		} finally {
			lock.unlock();
		}

	}

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(20);
		var aa = new ProtectingDataWithLocksExample23();

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
		// 1 2 3 4 5 6 7 8 9 10
		// 1 2 3 4 10 9 8 7 6 5

	}

}