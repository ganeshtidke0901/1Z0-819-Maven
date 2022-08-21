package uk.warley.ganesh.chapter18.concurrency;

public class ThreadExample1 {
	public static void main(String[] args) {
		Runnable task1 = new Task1();
		Thread thread1 = new Thread(task1);

		Thread thread2 = new Task2();
		Thread thread3 = new Task3();

		thread1.start();
		thread2.start();
		thread3.start();

		// Task3
		// Task1
		
		Runnable runnable=()-> System.out.println("Runnable1");
		Runnable runnable2=()-> {int i=0; i++;};
		Runnable runnable3=()-> {return;};
		Runnable runnable4=()->{};
		
		
		
		

	}
}

class Task1 implements Runnable {

	@Override
	public void run() {
		System.out.println("Task1");
	}

}

class Task2 extends Thread {

}

class Task3 extends Thread {
	@Override
	public void run() {

		System.out.println("Task3");
	}

}