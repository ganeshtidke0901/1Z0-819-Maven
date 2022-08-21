package uk.warley.ganesh.chapter12.javafundamentals;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class LambdasWithLocalVarialeExample17 {
	int n;

	BiPredicate<String, Boolean> p1 = (final var var1, final var var) -> {
		System.out.println(n);
		int n=11;
		return true;
	};

	public void test() {
		BiPredicate<String, Boolean> p2 = (final var var1, final var var) -> {
			System.out.println(n);
			n=11;
			return true;
		};
	}

	public void test1(int var1) {
//		BiPredicate<String, Boolean> p2 = (final var var1, final var var) -> {  //cant use var1 local varible as parameter
//			System.out.println(n);
//			return true;
//		};

		BiPredicate<String, Boolean> p2 = (final var var2, final var var3) -> { // cant use var1 local varible as
																				// parameter
//		int var1=11;//cant create another var1 as it is in local scope
//			var1=12; cant assign the value as it wil not fit into effectively final
			System.out.println(var1);
			return true;
		};
	}

	public static void main(String[] args) {

		int a;// should be final or effectively final to be used in lambda bodies as we do for anonymous class
				// body
		final int b;
		
		a = 11;
		b=13;
		BiPredicate<String, Boolean> p8 = (final var var1, final var var) -> {
			System.out.println(a);
//			System.out.println(n);//lambda declared in static method 
			return true;
		};

//		a=22; //line 13 will fail as it will no longer be effecively final
		BiPredicate<String, Boolean> p9 = (final var var1, final var var) -> {
			System.out.println(b);
//			System.out.println(n);//lambda declared in static method 
			return true;
		};

	
	}

}
