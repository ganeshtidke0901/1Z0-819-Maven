package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferenceExample00 {
	public static void main(String[] args) {

		List<Integer> integers = new ArrayList<Integer>();
		integers.add(100);
		integers.add(200);
		integers.add(50);

		// calling static methods
		Consumer<List<Integer>> consumer1 = s -> Collections.sort(s);// accept method is accepting list and sorting it
		Consumer<List<Integer>> consumer2 = Collections::sort;
		
		Consumer<String> consumer3 = s-> s.isEmpty();//  this method returns boolean but here it is discarded
		Consumer<String> consumer4 = String::isEmpty;//  this method returns boolean but here it is discarded
		consumer1.accept(integers);
		System.out.println(integers);

		// calling instace methods on Perticular object
		var str = "abc";
		Predicate<String> predicate1 = s -> str.startsWith(s);
		Predicate<String> predicate2 = str::startsWith;

		// calling instance method on parameter
		var str1 = "abc";
		Predicate<String> predicate3 = s -> s.isEmpty();
		Predicate<String> predicate4 = String::isEmpty;

		BiPredicate<String, String> biPredicate1 = (p, q) -> p.startsWith(q);
		BiPredicate<String, String> biPredicate2 = String::startsWith;

		// calling constructors
		Supplier<List<String>> supplier1 = () -> new ArrayList<>();
		Supplier<List<String>> supplier2 = ArrayList::new;

	}
}
