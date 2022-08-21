package uk.warley.ganesh.chapter18.concurrency;

import java.util.stream.Stream;

public class ParallelStreamsExample40 {

	public static int doWork(int a) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("doWork:"+a);
		return a;
	}

	public static void example1() {

		long startTime = System.currentTimeMillis();

		Stream<Integer> stream = Stream.iterate(1, i -> {
			System.out.println("iterating:" + (i + 1));
			return i + 1;
		});
		stream.limit(5).map(i -> doWork(i)).forEach(System.out::println);

		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000 + " seconds");
//		doWork:1
//		1
//		iterating:2
//		doWork:2
//		2
//		iterating:3
//		doWork:3
//		3
//		iterating:4
//		doWork:4
//		4
//		iterating:5
//		doWork:5
//		5
//		5 seconds


	}

	public static void example2() {

		long startTime = System.currentTimeMillis();

		Stream<Integer> stream = Stream.iterate(1, i -> {System.out.println("Iterating"+(i+1));;return i + 1;}).parallel();
		stream.limit(5).map(i -> doWork(i)).forEach(System.out::println);

		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000 + " seconds");

//		Iterating2
//		Iterating3
//		Iterating4
//		Iterating5
//		...
//		Iterating3458
//		doWork:4    
//		doWork:5
//		4
//		doWork:2
//		2
//		doWork:3
//		doWork:1
//		1
//		3
//		5
//		1 seconds

	}

	public static void example3() {

		long startTime = System.currentTimeMillis();

		Stream<Integer> stream = Stream.iterate(1, i -> {
			System.out.println("iterating:" + (i + 1));
			return i + 1;
		}).parallel();
		stream.limit(5).map(i -> doWork(i)).forEach(System.out::println);

		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000 + " seconds");

//		Iterating2
//		Iterating3
//		Iterating4
//		Iterating5
//		...
//		Iterating3458
//		doWork:4    
//		doWork:5
//		4
//		doWork:2
//		2
//		doWork:3
//		doWork:1
//		1
//		3
//		5
//		1 seconds
	}

	static void example4() {

		long startTime = System.currentTimeMillis();

		Stream<Integer> stream = Stream.iterate(1, i -> {
			System.out.println("iterating:" + (i + 1));
			return i + 1;
		});
		stream.limit(5).map(i -> doWork(i)).parallel().forEach(System.out::println);

		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000 + " seconds");
//		Iterating2
//		Iterating3
//		Iterating4
//		Iterating5
//		...
//		Iterating3458
//		doWork:4    
//		doWork:5
//		4
//		doWork:2
//		2
//		doWork:3
//		doWork:1
//		1
//		3
//		5
//		1 seconds
	}

	static void example5() {

		long startTime = System.currentTimeMillis();

		Stream<Integer> stream = Stream.iterate(1, i -> {
			System.out.println("iterating:" + (i + 1));
			return i + 1;
		});// iterate goes in parallel mode
		stream.limit(5).// limit is always run in sequential mode
				map(i -> doWork(i)).// map goes in parallel mode
				parallel().//in stream wherever you apply parallel whole stream is convrted into stream
				forEachOrdered(System.out::println);//this operation is always sequential the way stream elements are generated

		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000 + " seconds");
//		
//		iterating:1
//		iterating:2
//		iterating:3
//		...		.
//		...
//		iterating:3072
//		1
//		2
//		3
//		4
//		5
//		1 seconds

	}

	public static void example6() {

		long startTime = System.currentTimeMillis();

		Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
		stream.parallel().peek(s->{try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}System.out.println("peek:"+s);}).map(i -> doWork(i)).forEach(System.out::println);

		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000 + " seconds");

//		peek:4
//		peek:7
//		peek:5
//		peek:3
//		peek:8
//		peek:2
//		peek:1
//		peek:6
//		doWork:6
//		doWork:7
//		7
//		doWork:5
//		5
//		doWork:8
//		doWork:2
//		2
//		doWork:1
//		1
//		doWork:3
//		3
//		doWork:4
//		4
//		8
//		6
//		peek:9
//		doWork:9
//		9
//		4 seconds


		
	}
	public static void main(String[] args) {
//		example1();
//		example2();
//		example3();
//		example4();
//		example5();
		
		example6();
	}
}