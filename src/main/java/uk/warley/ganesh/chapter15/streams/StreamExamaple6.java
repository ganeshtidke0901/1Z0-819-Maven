package uk.warley.ganesh.chapter15.streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamExamaple6 {
	public static void main(String[] args) {
		
		//Finite Streams
		Stream<String> stream1=Stream.empty();
		Stream<String> stream2=Stream.of();
		Stream<String> stream3=Stream.of("Ganesh","Tidke");
		Stream<String> stream4=Stream.of("Ganesh");
		
		List<Integer> integers=List.of(1,2,4);
		Stream<Integer> stream5=integers.stream();
		Stream<Integer> stream6=integers.parallelStream();
		
		
		//Infinite Streams
		
		Stream<Double> stream7=Stream.generate(()-> Math.random());
		Stream<Double> stream8=Stream.iterate(1d,i-> i+1);//1.0,2.0,3.0........
		Stream<Double> stream9=Stream.iterate(1d,i-> i<100,i-> i+1);//seed,Predicate, supplier
		
	}
}
