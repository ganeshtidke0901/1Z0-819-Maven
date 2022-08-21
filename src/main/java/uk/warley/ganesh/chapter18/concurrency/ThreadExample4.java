package uk.warley.ganesh.chapter18.concurrency;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class ThreadExample4 {

	public static void main(String[] args) // throws InterruptedException we cant add here because the exeception is
											// happening different class method
	{
		new Thread(() -> System.out.println("Hello")).start();
		new Thread(() -> {
			for (int i = 0; i < 3; i++) {
				try {
					Thread.sleep(1000);
					System.out.println("Printing data:" + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static void justexample1() {
		Consumer<String> consumer = s -> {
			try {
				Thread.sleep(1000);// this method is overriding method which cant throws any exception as void accept()
									// does not throw any exception
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		consumer.accept("Ganesh");

		Callable<String> callable = () -> "";
		try {
			System.out.println(callable.call());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}