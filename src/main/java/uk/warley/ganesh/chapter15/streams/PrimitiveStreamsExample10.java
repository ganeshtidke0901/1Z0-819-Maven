package uk.warley.ganesh.chapter15.streams;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamsExample10 {
	public static void main(String[] args) throws Exception {

		Stream<String> stream = Stream.of("Ganesh", "Tidke", "Mr");
		stream.map(s -> s.length())// Stream<String> is converted into Stream<Integer>
				.forEach(System.out::println);// 6
												// 5
												// 2

		Stream<String> stream1 = Stream.of("Ganesh", "Tidke", "Mr");
		stream1.mapToInt(s -> s.length())// Stream<String> is converted into IntStream
				.forEach(System.out::println);// 6
												// 5
												// 2

		DoubleStream doubleStream = DoubleStream.empty();
		IntStream intStream = IntStream.empty();
		LongStream longStream = LongStream.empty();

		DoubleStream doubleStream2 = DoubleStream.generate(Math::random);
		DoubleStream doubleStream3 = DoubleStream.iterate(0.5, i -> i / 2);
		doubleStream3.limit(3).forEach(s -> System.out.print(s));// 0.5,0.25,0.125
		System.out.println();
		IntStream intStream2 = IntStream.range(1, 5);
		intStream2.forEach(s -> System.out.print(s));// 1,2,3,4

		System.out.println();
		IntStream intStream3 = IntStream.rangeClosed(1, 5);
		intStream3.forEach(s -> System.out.print(s));// 1,2,3,4,5

		System.out.println();
		IntStream intStream4 = IntStream.rangeClosed(1, 5);
		OptionalDouble optionalDouble = intStream4.average();
		System.out.println(optionalDouble.getAsDouble());// 3.0

		System.out.println();
		IntStream intStream5 = IntStream.rangeClosed(1, 5);
		intStream5.boxed().// IntStream is converted into Stream<Integer>
				forEach(s -> System.out.println(s));
		
		System.out.println();
		IntStream intStream6 = IntStream.rangeClosed(1, 5);
		intStream6.mapToObj(n->n)// IntStream is converted into Stream<Integer>
				.forEach(s -> System.out.println(s));
		
		System.out.println();
		IntStream intStream7 = IntStream.rangeClosed(1, 5);//range available only for int and long stream
		intStream7.mapToObj(n->n+"s")// IntStream is converted into Stream<String>
				.forEach(s -> System.out.println(s));
		
		System.out.println();
		IntStream intStream8 = IntStream.rangeClosed(1, 5);
		 OptionalInt optionalInt=intStream8.max();
		 System.out.println(optionalInt.getAsInt());//5
		 System.out.println(optionalInt.isPresent());//true
		 System.out.println(optionalInt.orElseGet(()->1));////5
		 System.out.println(optionalInt.orElse(100));//5
		 System.out.println(optionalInt.orElseThrow());//5
		 System.out.println(optionalInt.orElseThrow(()-> new Exception()));//5
		 
		 //same for max()
		 
		 IntStream intStream9 = IntStream.rangeClosed(1, 5);
		 int sume =intStream9.sum();//15
		 IntStream intStream10 = IntStream.rangeClosed(1, 5);
		 long scount =intStream10.count();
		 System.out.println("----------------------------------");
		 IntStream intStream11 = IntStream.rangeClosed(1, 5);
		 IntSummaryStatistics intSummaryStatistics=intStream11.summaryStatistics();
		 System.out.println(intSummaryStatistics.getCount());//long
		 System.out.println(intSummaryStatistics.getSum());//long
		 System.out.println(intSummaryStatistics.getAverage());//double
		 System.out.println(intSummaryStatistics.getMax());//int
		 System.out.println(intSummaryStatistics.getMin());//int
		 
		 
		 
		 
		 
	}
}
