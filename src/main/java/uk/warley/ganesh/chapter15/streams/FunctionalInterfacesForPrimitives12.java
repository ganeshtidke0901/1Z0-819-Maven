package uk.warley.ganesh.chapter15.streams;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.UnaryOperator;

public class FunctionalInterfacesForPrimitives12 {
	public static void main(String[] args) {
		BooleanSupplier booleanSupplier = () -> true;
		System.out.println(booleanSupplier.getAsBoolean());// true

		// same for LongSupplier, DoubleSupplier
		IntSupplier intSupplier = () -> 1;
		System.out.println(intSupplier.getAsInt());// 1

		// same for IntConsumer, LongConsumer
		DoubleConsumer consumer = (d) -> System.out.println(d);
		consumer.accept(100);// 100.0

		// same for IntPredicate, LongPredicate
		DoublePredicate doublePredicate = (s) -> s == 100.0;
		System.out.println(doublePredicate.test(100d));// true

		// same for DoubleFunction,LongFunction
		IntFunction<String> function = (i) -> i + "Ganesh";
		System.out.println(function.apply(1));// 1Ganesh

		// same for DoubleUnaryOpearator,LongUnaryOperator
		IntUnaryOperator intUnaryOperator = s -> s + 1;
		System.out.println(intUnaryOperator.applyAsInt(1));// 2

		// same for DoubleBinaryOpearator,LongBinaryOperator
		IntBinaryOperator intBinaryOperator = (a, b) -> a + b;
		System.out.println(intBinaryOperator.applyAsInt(1, 2));// 3

		System.out.println("-----------------------------------------------------------");

		// same for ToIntFunction, ToLongFunction
		ToDoubleFunction<String> toDoubleFunction = s -> s.length();
		System.out.println(toDoubleFunction.applyAsDouble("Ganesh"));

		// same for ToIntFunction, ToLongFunction
		ToDoubleBiFunction<String, String> toDoubleBiFunction = (a, b) -> (a + b).length();
		System.out.println(toDoubleBiFunction.applyAsDouble("Ganesh", "Tidke"));// 11.0

		// DoubleToLongFunction, IntToDoubleFunction,IntToLongFunction, LongToIntFunction,
		// LongToDoubleFunction
		DoubleToIntFunction doubleToIntFunction = n -> (int) n;
		System.out.println(doubleToIntFunction.applyAsInt(100.0));// 100

		// its like BiConsumer where first parameter is any T and second is doubel
		// same like ObjIntConsumer, ObjLongConsumer
		ObjDoubleConsumer<String> objDoubleConsumer = (s, i) -> System.out.println(s + i);
		objDoubleConsumer.accept("Ganesh", 100.0d);// Ganesh100.0
	}

}
