package uk.warley.ganesh.chapter15.streams;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

public class OptionalForPrimitives11 {
	public static void main(String[] args) {
		LongStream longStream = LongStream.of(5, 0);
		long l = longStream.sum();

		DoubleStream doubleStream = DoubleStream.of(5, 0);
		OptionalDouble optionalDouble = doubleStream.min();
		System.out.println(optionalDouble.getAsDouble());
		System.out.println(optionalDouble.orElse(100d));
		System.out.println(optionalDouble.orElseGet(() -> 200));// DoubleSupplier
		System.out.println(optionalDouble.orElseThrow());// DoubleSupplier
		System.out.println(optionalDouble.orElseThrow(RuntimeException::new));

		// same for IntOptional, LongOptional,DoubleOptional
	}
}
