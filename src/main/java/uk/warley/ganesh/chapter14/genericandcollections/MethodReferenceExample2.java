package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Interface1 {

	void abc(int a, int b);
}

class Penguin {

	public static Integer countBabies(Penguin... cuties) {
		return cuties.length;
	}

	public Integer countBabies1(Penguin... cuties) {
		return cuties.length;
	}

	public Integer countBabies2() {
		return 0;
	}
	

	public Integer countBabies3(Penguin penguin) {
		return 0;
	}
}

public class MethodReferenceExample2 {
	public static void xyz() {

	}
	public static void main(String[] args) {

		Interface1 interface1 = (a, b) -> xyz();
//		Interface1 interface2=MethodReferenceExample2::xyz;//The type MethodReferenceExample2 does not define xyz(int, int) that is applicable here

		Penguin[] cuties1 = new Penguin[0];
		Penguin[] cuties2 = new Penguin[] {};
		Supplier<Integer> supplier1 = () -> Penguin.countBabies();// we can pass zero elements in array Penguin[]
																	// cuties1 or cuties2
		Supplier<Integer> supplier2 = Penguin::countBabies;// we can pass zero elements in array Penguin[] cuties1 or
															// cuties2

		Function<Penguin, Integer> function1 = p -> Penguin.countBabies(p);// R apply(T)
		Function<Penguin, Integer> function2 = Penguin::countBabies;

		BiFunction<Penguin, Penguin, Integer> bifunction1 = (p, q) -> Penguin.countBabies(p,q);// R apply(T,U)
		BiFunction<Penguin, Penguin, Integer> bifunction2 = Penguin::countBabies;

		BiFunction<Penguin, Penguin, Integer> bifunction3 = (p, q) -> p.countBabies1();// in lambda its upto us what we
																						// can use out of supplied
																						// parameters. e.g q is not used
		BiFunction<Penguin, Penguin, Integer> bifunction4 = (p, q) -> p.countBabies1(q);
		BiFunction<Penguin, Penguin, Integer> bifunction5 = Penguin::countBabies1;// here is definitely using p to call
																					// method and q to be passed to
																					// method as parameter

		// p, q can be used after scope of lambda but before line 51 ,cant be used
		Penguin p = new Penguin();
		Penguin q = new Penguin();

		System.out.println(bifunction3.apply(p, q));// 0
		System.out.println(bifunction4.apply(p, q));// 1
		System.out.println(bifunction5.apply(p, q));// 1

		// lambda parameters passed must be used in method reference as parameters or to call method (p,q
		// must be used by countBabies2)
//		BiFunction<Penguin, Penguin, Integer> bifunction6 = Penguin::countBabies2;// The type Penguin does not define countBabies2(Penguin) that is applicable here

		
		
		Function<Penguin, Integer> function3=p::countBabies3;// s-> p.countBabies3(s);
		BiFunction<Penguin,Penguin, Integer> bifunction7=Penguin::countBabies3;// (p,q)-> p.countBabies3(q);
		
		
		Predicate<String> p1=s-> s.startsWith("A");//
		Consumer<String> p2=s-> s.startsWith("A");//when there is not return for method , body lamda body returns or not , does not matter
		Consumer<String> p3="A"::startsWith;//when there is not return for method , body lamda body returns or not , does not matter
		
	}
}
