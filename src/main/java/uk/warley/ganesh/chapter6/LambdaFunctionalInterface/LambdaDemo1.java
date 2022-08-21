package uk.warley.ganesh.chapter6.LambdaFunctionalInterface;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaDemo1 {
	public static void main(String[] args) {
		example1();
		example2();
		example3();
		example4();
		example5();
	}

	private static void example1() {

		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return 0;
			}
		};

		Comparator<String> comparator2 = (String o1, String o2) -> {return 0;};
		Comparator<String> comparator3 = (String o1, String o2) -> 0;
		Comparator<String> comparator4 = (var o1, var o2) -> 0;
		Comparator<String> comparator5 = (o1, o2) -> 0;

		// Not allowed
//		Comparator<String> comparator10 = (o1, var o2) -> 0 ;
//		Comparator<String> comparator11 = (String  o1, var o2) -> 0 ;
//		Comparator<String> comparator6 = (o1, o2) -> return 0 ;
//		Comparator<String> comparator6 = (o1, o2) -> {return 0 };

	}

	private static void example2() {

		Predicate<String> predicate1 = new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t.isEmpty();
			}
		};
		
		
		Consumer<String>  consumer=new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		
		Supplier<String> supplier=new Supplier<String>() {
			
			@Override
			public String get() {
				return "Ganaesh";
			}
		};

		
		
		Predicate<String> predicate2 = s -> s.isEmpty();
		Consumer<String> consumer2=s->System.out.println(s);
		Supplier<String> supplier2=()-> "Ganesh";
		

	}

	private static void example3() {
		
	}

	private static void example4() {
	}

	private static void example5() {
	}
}
