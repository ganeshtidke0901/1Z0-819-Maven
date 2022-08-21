package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ProtectingDataWithAtomicClassesExample21 {
	private AtomicInteger sheepCount = new AtomicInteger(1);
	AtomicBoolean atomicBoolean;
	AtomicLong atomicLong;

	private void incrementAndReport() {
		System.out.print((sheepCount.getAndIncrement()) + " ");
//		Methods
//		sheepCount.get();
//		sheepCount.incrementAndGet();
//		sheepCount.getAndDecrement();
//		sheepCount.decrementAndGet();
//		sheepCount.getAndDecrement();
//		sheepCount.getAndSet(2);
//		
	}

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(20);
		var aa = new ProtectingDataWithAtomicClassesExample21();

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
		// 1 10 9 4 3 8 5 2 7 6
		// 5 10 9 8 1 3 4 7 6 2
		// 1 8 7 2 6 5 4 3 10 9

	}

}