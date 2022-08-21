package uk.warley.ganesh.chapter18.concurrency;

import java.util.stream.Stream;

public class ParallelStreamsExample41 {

	public static int doWork(int a) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return a;
	}

	public static void example1() {

		long startTime = System.currentTimeMillis();

		Stream<Integer> stream = Stream.iterate(1,i->{System.out.println("iterating:"+(i+1));return i+1;});
		stream.limit(5).map(i -> doWork(i)).forEach(System.out::println);

		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000 + " seconds");

	}

	public static void example2() {
	}

	
	
	public static void example3() {

	}

	
	static void example4()
	{
	}
	
	public static void main(String[] args) {
		example1();
//		example2();
//		example3();
//		example4();
	}
}