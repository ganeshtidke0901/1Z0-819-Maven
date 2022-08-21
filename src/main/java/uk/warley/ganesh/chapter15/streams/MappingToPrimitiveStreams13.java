package uk.warley.ganesh.chapter15.streams;

import java.util.ArrayList;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MappingToPrimitiveStreams13 {
	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1, 2);
		IntStream intStream = stream.mapToInt(s -> s);

		Stream<String> stream1 = Stream.of("Ganesh", "Tidke");
		DoubleStream doubleStream = stream1.mapToDouble(s -> s.length() * 1.0);// ToDoubleFunction<T>

		Stream<String> stream2 = Stream.of("Ganesh", "Tidke");
		LongStream longStream = stream2.mapToLong(s -> s.length());// ToLongFunction<T>

		IntStream intStream2 = IntStream.of(1, 2, 3, 4);
		Stream<Integer> stream3 = intStream2.mapToObj(s -> s);// IntFunction<R>

		Stream<Integer> stream4 = Stream.of(1, 2);
		Stream<String> stream5 = stream4.map(n -> n + "");// Function<T,R>

		IntStream intStream3 = IntStream.of(1, 2, 3);
		IntStream intStream4 = intStream3.map(n -> n * 1);// IntUnararyOperator

		IntStream intStream5 = IntStream.of(1, 2, 3);
		DoubleStream doubleStream2 = intStream5.mapToDouble(n -> n * 1.0);// IntToDoubleFunction

		var integerList = new ArrayList<Integer>();
		IntStream intStream6 = integerList.stream().flatMapToInt(s -> IntStream.of(s));// whatever source is , flatMap
																						// will always map streams of
																						// sometype to single stream of
																						// sometype. here IntStream is
																						// created for each Integer and
																						// flatMapToInt will flatten all
																						// IntStreams created to one
																						// IntStream

		
		var doubleList = new ArrayList<Double>();
		DoubleStream doubleStream6 = doubleList.stream().flatMapToDouble(s -> DoubleStream.of(s * 1.0));

		var longList = new ArrayList<Long>();
		LongStream longStream6 = longList.stream().flatMapToLong(s -> LongStream.of(s));

		IntStream intStream7 = IntStream.of(1, 2, 3, 4);
		Stream<Integer> stream7 = intStream7.boxed();

	}
}
