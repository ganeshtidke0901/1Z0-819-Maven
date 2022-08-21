package uk.warley.ganesh.chapter18.concurrency;

import java.util.List;
import java.util.Optional;

public class ParllelStreamWithOrderBasedTasksExample42 {

	public static int doWork(int a) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return a;
	}

	public static void example1() {
		//findany is support parallel and is not based on order 
		Optional<Integer> optional = List.of(1, 2, 3, 4, 5).parallelStream().findAny();
		System.out.println(optional.get());//3 or //1
		
	}

	public static void example2() {
		//it  is  based on order and it will slow down the parallel stream so better to use serial stream
		//other examples skip, limit , findFirst
		Optional<Integer> optional = List.of(1, 2, 3, 4, 5).parallelStream().findFirst();
		System.out.println(optional.get());//1

	}

	public static void example3() {
		//unordered does not reorder the element ,it says if order based operations are applied then ignore the order
		Optional<Integer> optional = List.of(1, 2, 3, 4, 5).stream().unordered().parallel().findFirst();
		System.out.println(optional.get());//3

	
	}

	static void example4() {
	}

	public static void main(String[] args) {
//		example1();
//		example2();
//		example3();
//		example4();
	}
}