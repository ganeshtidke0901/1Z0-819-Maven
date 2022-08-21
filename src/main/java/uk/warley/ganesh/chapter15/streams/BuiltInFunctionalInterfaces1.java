package uk.warley.ganesh.chapter15.streams;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BuiltInFunctionalInterfaces1 {
	public static void main(String[] args) {

		Supplier<String> supplier = () -> "Ganesh";//String::new
		Consumer<String> consumer = s -> System.out.println(s);
		BiConsumer<String, Integer> biConsumer = (s, i) -> System.out.println(s + i);
		Predicate<String> predicate = (s) -> s.isEmpty();
		BiPredicate<String, String> biPredicate = (s, c) -> s.contains(c);
		Function<String, Integer> function = s -> s.length();
		BiFunction<String, String, Integer> biFunction = (s1, s2) -> (s1 + s2).length();
		UnaryOperator<String> operator = s -> s + "g";
		BinaryOperator<String> binaryOperator = (s1, s2) -> s1 + s2;

		
		System.out.println(supplier.get());// Ganesh
		consumer.accept("Ganesh");// Ganesh
		biConsumer.accept("Ganesh", 2);// Ganesh2
		System.out.println(predicate.test("Ganesh"));// false
		System.out.println(biPredicate.test("Ganesh", "Tidke"));// false
		System.out.println(function.apply("Ganesh"));// 6
		System.out.println(biFunction.apply("Ganesh", "Tidke"));// 11
		System.out.println(operator.apply("Ganesh"));// Ganeshg
		System.out.println(binaryOperator.apply("Ganesh", "Tidke"));// GaneshTidke

	}
}