package uk.warley.ganesh.chapter7.methodsandencapsulation;

import java.time.LocalDate;
import java.util.ArrayList;

public class MethodOverloading12 {
	public static void main(String[] args) {
		fly();//d  >=0 parameters
		fly(2);//j  Larger primitives
		fly((short)2);//j  LArger primitives
		fly(2.2);//o  double> Double> Object
		//rule
		// Exact match-> larger primitives-> Autoboxing--> var args
		
		
		fly2("abc");// CharSequence
		fly2(new ArrayList<String>());//Iterable
		fly2(LocalDate.now());//Object
	}

	
	public static void fly(Integer  a) {
		System.out.println("h");
	}	
	public static void fly(Short  a) {
		System.out.println("Short A");
	}
	public static void fly(float  a) {
		System.out.println("j");
	}
//	public static void fly(double  a) {
//		System.out.println("double");
//	}
	public static void fly(Object a) {
		System.out.println("o");
	}

	public static int fly(int... a) {
		System.out.println("d");
		return 0;
	}
	
	//already defined by varargs int ...a
//	public static int fly(int[] a) {
//		System.out.println("d");
//		return 0;
//	}
	
	public static int fly2(CharSequence  ss) {
		System.out.println("CharSequence");
		return 0;
	}
	public static int fly2(Object  ss) {
		System.out.println("Object");
		return 0;
	}
	public static int fly2(Iterable s) {
		System.out.println("Iterable");
		return 0;
	}
	
	

}
