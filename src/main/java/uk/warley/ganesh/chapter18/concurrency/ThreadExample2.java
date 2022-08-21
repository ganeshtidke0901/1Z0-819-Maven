package uk.warley.ganesh.chapter18.concurrency;

public class ThreadExample2 {
	public static void main(String[] args) {
		PrintData.test();
		ReadInventoryThread.test();
	}
}

class PrintData implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("Printing Data");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void test() {

		new Thread(new PrintData()).start();
	}

}

class ReadInventoryThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Reading zoo inventory");
		}
	}

	public static void test() {
		new ReadInventoryThread().start();
	}

}
