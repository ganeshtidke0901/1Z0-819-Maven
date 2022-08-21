package uk.warley.ganesh.chapter15.streams;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BuiltInFunctionalInterface2 {
	public static void main(String[] args) {


		Supplier<LocalDate> supplier1 = LocalDate::now;
		Supplier<LocalDate> supplier2 = () -> LocalDate.now();

		Consumer<String> consumer1 = s -> System.out.println(s);
		Consumer<String> consumer2 = System.out::println;

		var map = new HashMap<String, Integer>();
		BiConsumer<String, Integer> biConsumer1 = map::put;
		BiConsumer<String, Integer> biConsumer2 = (s, i) -> map.put(s, i);

		Predicate<String> predicate1 = String::isEmpty;
		Predicate<String> predicate2 = (s) -> s.isEmpty();

		BiPredicate<String, String> biPredicate1 = (s, c) -> s.contains(c);
		BiPredicate<String, String> biPredicate2 = String::contains;

		Function<String, Integer> function1 = s -> s.length();
		Function<String, Integer> function2 = String::length;
		
		
		BiFunction<String, String, String> biFunction1 = (s1, s2) -> s1.concat(s2);
		BiFunction<String, String, String> biFunction2 = String::concat;
		
		UnaryOperator<String> operator1 = s -> s.toUpperCase();
		UnaryOperator<String> operator2 = String::toUpperCase;
		
		BinaryOperator<String> binaryOperator1 = (s1, s2) -> s1.concat(s2);
		BinaryOperator<String> binaryOperator2 = String::concat;

		System.out.println(supplier1.get());// 2021-09-11
		System.out.println(supplier1);// uk.warley.ganesh.chapter15.streams.BuiltInFunctionalInterfaces2$$Lambda$23/0x0000000800087040@6b143ee9

	
	}
}