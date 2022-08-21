package uk.warley.ganesh.chapter18.concurrency;

public class ConcurrentClassesExample33 {
	private final static int noOfThreads = 999999    ; 

	public static void main(String[] args) throws InterruptedException {
		VolatileData volatileData = new VolatileData(); // object of VolatileData class
		Thread[] threads = new Thread[noOfThreads]; // creating Thread array
		for (int i = 0; i < noOfThreads; ++i)
			threads[i] = new VolatileThread(volatileData);
		for (int i = 0; i < noOfThreads; ++i)
			threads[i].start(); // starts all reader threads
		for (int i = 0; i < noOfThreads; ++i)
			threads[i].join(); // wait for all threads
System.out.println("volatile:"+volatileData.counter+" Non Volatile:"+volatileData.anotherCounter);
		
//				[Thread 13]: Volatile Old value = 0   Non volatile:0
//				[Thread 14]: Volatile Old value = 0   Non volatile:0
//				[Thread 14]: New value = 2   Non volatile:2
//				[Thread 13]: New value = 1   Non volatile:1

		// volatile does not help making read-write operation atomic.
		// it is just it makes sure that any change in value after reading from main memory should be
		// written back to main memory instead caching in CPU cache
	}
}

class VolatileData {
	public volatile int counter = 0;
	public int anotherCounter = 0;

	public int getCounter() {
		return counter;
	}

	public int getAnotherCounter() {
		return anotherCounter;
	}

	public void increaseCounter() {
		++counter; // increases the value of counter by 1
		++anotherCounter;
	}
}

class VolatileThread extends Thread {
	private final VolatileData data;

	public VolatileThread(VolatileData data) {
		this.data = data;
	}

	@Override
	public void run() {
//		int oldValue = data.getCounter();
//		System.out.println("[Thread " + Thread.currentThread().getId() + "]: Volatile Old value = " + oldValue
//				+ "   Non volatile:" + data.getAnotherCounter());
		data.increaseCounter();
		System.out.println("[Thread " + Thread.currentThread().getId() + "]: New value = " + data.getCounter()
				+ "   Non volatile:" + data.getAnotherCounter());
	}
}