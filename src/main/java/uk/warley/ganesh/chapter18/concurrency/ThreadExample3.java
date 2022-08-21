package uk.warley.ganesh.chapter18.concurrency;

public class ThreadExample3 {
	
	static void example1() {

		ServingThread servingData=new ServingThread();
		servingData.setDaemon(true);
		servingData.start();
		//Main Thread

	}
	static void example2() {
		

		ServingThread servingData=new ServingThread();
		servingData.setDaemon(true);
		servingData.start();


		ReadData data = new ReadData();
		data.start();

//		Main Thread
//		Reading zoo inventory:0
//		serving other threads:0
//		serving other threads:1
//		Reading zoo inventory:1

	}
	static void example3() {
		ServingThread servingData2 = new ServingThread();
		servingData2.start();

		ReadData data2 = new ReadData();
		data2.start();
		
//		Main Thread
//		Reading zoo inventory:0
//		serving other threads:0
//		Reading zoo inventory:1
//		serving other threads:1
//		serving other threads:2
//		serving other threads:3
//		serving other threads:4


	}
	public static void main(String[] args) {
	
//		example1();
//		example2();
		example3();
		
		System.out.println("Main Thread");


		// Daemon thread(serving user threads) life is depends on user threads. as soon as all threads
		// complete then daemon threads shutdown right then irrespective which state it is in
		// it means user thread is running then it stops JVM to exit but if it is Daemon thread then it does
		// not stop JVM exiting(because if no user threads are there then it shutdowns hence JVM can exit)

	}
}

class ReadData extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Reading zoo inventory:" + i);
		}
	}

}

class ServingThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("serving other threads:" + i);
		}
	}

}
