package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProtectingDataCyclicBarrierExample26 {

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
		var aa = new ProtectingDataCyclicBarrierExample26();
		CyclicBarrier b1 = new CyclicBarrier(4);
		CyclicBarrier b2 = new CyclicBarrier(4, () -> {
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
//		Cleaning the cage
//		Cleaning the cage
//		Cleaning the cage
//		Cleaning the cage
//		the cage cleaned
//		Adding lions
//		Adding lions
//		Adding lions
//		Adding lions
	}

}