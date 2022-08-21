package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProtectingDataCyclicBarrierExample27 {

	private void removeLions() {
		System.out.println("Removing the lions");
	}

	private void cleanCage() {
		System.out.println("Cleaning the cage");
	}

	private void addLions() {
		System.out.println("Adding lions");
	}

	public void performTask(CyclicBarrier b1, CyclicBarrier b2) {

		removeLions();
		try {
			b1.await();
		} catch (InterruptedException | BrokenBarrierException e) {
		}

		cleanCage();
		try {
			b2.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		addLions();
	}

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(20);
		var aa = new ProtectingDataCyclicBarrierExample27();
		CyclicBarrier b1 = new CyclicBarrier(5);
		CyclicBarrier b2 = new CyclicBarrier(5, () -> {
			System.out.println("the cage cleaned");
		});

		try {
			for (int i = 0; i < 4; i++) {
				executorService.submit(() -> {
					aa.performTask(b1, b2);
				});
			}
		} finally {
			if (executorService != null)
				executorService.shutdown();
		}
//		Removing the lions
//		Removing the lions
//		Removing the lions
//		Removing the lions
		//b1 hangs here for 5th thread to reach the barrier limit
	}
}