package uk.warley.ganesh.chapter12.javafundamentals;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class LambdasSyntaxExample16 {
//	var var1=2;//cant use as class member
//	static var var2=2;//cant use as class member
	Predicate<Boolean> p4 = (var var) -> false;
	
	public static void main(String[] args) {
		// all valid syntax -commented
//		()-> 0
//		(Strig s)-> 0
//		var-> System.out.println()
//		(var var) -> System.out.println()
//		var-> {return 0;}

		Predicate<Boolean> p1 = p -> false;
		Predicate<Boolean> p2 = (p) -> false;
		Predicate<Boolean> p3 = (var) -> false;
		Predicate<Boolean> p4 = (var var) -> false;
		Predicate<Boolean> p5 = p -> {return false;};

//		BiPredicate<String, Boolean> p6=(var,var)-> true;//duplicate parameter
		BiPredicate<String, Boolean> p6 = (var1, var) -> true;
//		BiPredicate<String, Boolean> p7=(var var1,var)-> true;//if var mentioned as type ,should be applied to all parameters
		BiPredicate<String, Boolean> p7 = (var var1, var var) -> true;
		BiPredicate<String, Boolean> p8 = (final var var1, final var var) -> true;
//		BiPredicate<String, Boolean> p9=(final var1,var)-> true;//if final applied then should be type applied

	}

}
