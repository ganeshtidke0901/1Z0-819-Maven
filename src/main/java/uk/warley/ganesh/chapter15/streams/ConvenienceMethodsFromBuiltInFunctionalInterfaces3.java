package uk.warley.ganesh.chapter15.streams;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class ConvenienceMethodsFromBuiltInFunctionalInterfaces3 {
	public static void main(String[] args) {
		Consumer<String> consumer1 = s -> System.out.println(s);
		Consumer<String> consumer2 = s -> System.out.println("Hello"+s);
		Consumer<String> consumer3 = consumer1.andThen(consumer2);
		consumer3.accept("Ganesh"); //Ganesh
							    	//HelloGanesh
		
		Function<String, Integer> function1=s->s.length();
		Function<Integer, Float> function2=s->10f;
		Function<String, Float> function3=function1.andThen(function2);//<T,R>andThen <R,V> =<T,V>
		System.out.println(function3.apply("Ganesh"));//10.0 
		
		Function<String, Integer> after=s->s.length();
		Function<Float, String> before=s->s+"Ganesh";
		Function<Float, Integer> function4=after.compose(before);//<T, R> compose <V, T>=V,R
		System.out.println(before.apply(1f));//1.0Ganesh
		System.out.println(function4.apply(1f));// 9

		Predicate<String> predicate1=s->s.isEmpty();
		Predicate<String> predicate2=s->s.startsWith("G");
		Predicate<String> predicate3=predicate1.negate();
		
		Predicate<String> predicate4=predicate2.and(predicate3);
		Predicate<String> predicate5=predicate1.or(predicate2);
		
		
		System.out.println(predicate4.test("Ganesh"));//true
		System.out.println(predicate5.test("Ganesh"));//true
		
		
		
	}
}