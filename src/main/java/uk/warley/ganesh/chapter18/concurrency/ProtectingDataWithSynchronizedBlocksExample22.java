package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProtectingDataWithSynchronizedBlocksExample22 {
	private int sheepCount = 0;

	private synchronized void incrementAndReport() {
		System.out.print((++sheepCount) + " ");

		// or
//		synchronized (this) {
//			System.out.print((++sheepCount) + " ");
//		}

		// or
//		synchronized (ProtectingDataWithSynchronizedBlocksExample22.class) {
//			System.out.print((++sheepCount) + " ");
//		}
	}

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(20);
		var aa = new ProtectingDataWithSynchronizedBlocksExample22();

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