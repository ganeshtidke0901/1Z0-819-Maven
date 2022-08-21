package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProtectingDataWithLocksExample25 {
	private int sheepCount = 0;
	private Lock lock=new ReentrantLock();
	private  void incrementAndReport() {

		try {
			if(lock.tryLock(1500, TimeUnit.MILLISECONDS)) {
				System.out.println("able to obtain the lock");
				try {
					System.out.print((++sheepCount) + " ");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} finally {
					lock.unlock();
				}
			}else
				System.out.println("unable to aquire lock");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(20);
		var aa = new ProtectingDataWithLocksExample25();

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

		// for tryLock wait = 100 nano seconds
		
//		able to obtain the lock
//		unable to aquire lock
//		unable to aquire lock
//		unable to aquire lock
//		unable to aquire lock
//		unable to aquire lock
//		unable to aquire lock
//		unable to aquire lock
//		unable to aquire lock
//		1 unable to aquire lock
		
		
		//for 100 miliseconds
		
//		able to obtain the lock
//		1 able to obtain the lock
//		2 able to obtain the lock
//		3 able to obtain the lock
//		4 able to obtain the lock
//		5 able to obtain the lock
//		6 able to obtain the lock
//		7 able to obtain the lock
//		8 able to obtain the lock
//		9 able to obtain the lock
//		10 

	}

}