package uk.warley.ganesh.chapter4.makingdecisions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ForEachLoop4 {
	public static void main(String[] args) {
		example1();
		example2();
		example3();
		example4();
		__();
		$();
	}

	private static void example1() {
		int[] a = new int[5];
		for (var i : a) {

		}
		for (int i : a) {

		}
		for (Integer i : a) {// auto boxing/unboxing

		}

	}

	private static void example2() {
		int[] a = new int[5];
		int i;
//		for ( i : a) {}//  i has to be delcared

	}

	private static void example3() {
		int[] a = new int[5];
//		for (var i=10 : a) {} //should not be intilized

	}

	private static void example4() {
		Collection<String> c = new ArrayList<String>();// Extends Iterbale
		for (String string : c) {

		}
		Map<String, String> map = new HashMap<String, String>();
//		for (String string : map) {	} //Can only  iterate over instance of java.lang.Iterable or array

	}

	private static void __() {
		// TODO Auto-generated method stub

	}

	private static void $() {
		// TODO Auto-generated method stub

	}
}
