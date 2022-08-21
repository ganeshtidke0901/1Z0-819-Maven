package uk.warley.ganesh.chapter15.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPipelinesExamples9 {
	
	static void example1()
	{
		Stream.generate(()-> "Elsa")//
		.filter(n->n.length()==4) //filter allows each element to  pass through it
		.sorted() //waits for everything to there to be sorted - so goes in loop
		.limit(2)//
		.forEach(System.out::println);//
	}

	static void example2()
	{
		Stream.generate(()-> "Elsa")
		.filter(n->n.length()==4) //filter allows each element to  pass through it
		.limit(2) //it limits 2 strings so it  becomes finite
		.sorted() 
		.forEach(System.out::println);//Elsa is printed twice
	}
	
	
	static void example3()
	{
		Stream.generate(()-> "fhsgjdfghdhfn")
		.filter(n->n.length()==4) //filter does not  allow each element to  pass through it- keep on processing 
		.limit(2) 
		.sorted() 
		.forEach(System.out::println);
	}
	
	static void example4()
	{
		Stream.generate(()-> "Elsa")
		.filter(n->n.length()==4) 
		.limit(2) 
		.sorted() 
		.collect(Collectors.toSet())
		.stream()
		.forEach(System.out::println);//Elsa
	}
	
	static void example5()
	{
		Stream.iterate("Ganesh",i->i+1)
		.filter(n->n.length()<60) 
		.limit(2) 
		.peek(System.out::println) 
		.forEach(System.out::println);//Elsa
	}
	
	
	public static void main(String[] args) {
//			example1();
		example5();
		
	}
}
