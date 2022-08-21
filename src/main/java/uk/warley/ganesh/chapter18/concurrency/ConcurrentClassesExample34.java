package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentClassesExample34 {
	private final static int noOfThreads = 100;

	public static void main(String[] args) throws InterruptedException {
		VolatileData1 volatileData = new VolatileData1(); // object of VolatileData class
		Thread[] threads = new Thread[noOfThreads]; // creating Thread array
		for (int i = 0; i < noOfThreads; ++i)
			threads[i] = new VolatileThread1(volatileData);
		for (int i = 0; i < noOfThreads; ++i)
			threads[i].start(); // starts all reader threads
		for (int i = 0; i < noOfThreads; ++i)
			threads[i].join(); // wait for all threads

//		
//				[Thread 13]: Volatile Old value = 0   Non volatile:0
//				[Thread 14]: Volatile Old value = 0   Non volatile:0
//				[Thread 14]: New value = 2   Non volatile:2
//				[Thread 13]: New value = 1   Non volatile:1
	}
}

class VolatileData1 {
	private AtomicInteger counter = new AtomicInteger(0);
	int anotherCounter = 0;

	public int getCounter() {
		return counter.get();// read operation is atomic(means one thread is reading then other thread is blocked
								// reading same variable)
	}

	public void increaseCounter() {
		counter.incrementAndGet(); // increment(write)+read operations are atomic(means one thread is
									// reading-incremetign-writing back to memory then other thread is blocked doing any
									// of these operations)
	}
}

class VolatileThread1 extends Thread {
	private final VolatileData1 data;

	public VolatileThread1(VolatileData1 data) {
		this.data = data;
	}

	@Override
	public void run() {
//		int oldValue = data.getCounter();
//		System.out.println("[Thread " + Thread.currentThread().getId() + "]: Volatile Old value = " + oldValue);
		data.increaseCounter();
		int newValue = data.getCounter();
		System.out.println("[Thread " + Thread.currentThread().getId() + "]: New value = " + newValue);
	}
}