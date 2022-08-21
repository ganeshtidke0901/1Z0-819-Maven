package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConcurrentClassesExample37 {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>();
		blockingQueue.offer("Ganesh1");
		try {
			blockingQueue.offer("Ganesh2", 10, TimeUnit.SECONDS);// wait for space is available otherwise add it right
																	// away
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(blockingQueue);// [Ganesh1, Ganesh2] -without anywait

		blockingQueue.poll();
		blockingQueue.poll();

		try {
			blockingQueue.poll(10, TimeUnit.SECONDS);// wait for 10 secs to see if any element is available in queue
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(blockingQueue);// [] after 10 seconds it is printed

		
	}
}