package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GenericsMethodsExample19 {
	public static void main(String[] args) {

		Generic4.<String>test("Ganesh");// explicitly telling T type
		Generic4.test("Ganesh");// implicitly telling T type based on argument type

		Generic4 generic4 = new Generic4();
		generic4.test2(null);// T =Object
		generic4.test2(12);// T =Integer
		generic4.<Double>test2(1d);// T =Double
//		generic4.<Double>test2(1);// error as Explicitly mentioned type is Double and you passing 1--> Integer not Double

		generic4.test2(new ArrayList<String>());// T = ArrayList
	}

}

class Generic4 {

	public static <T extends CharSequence> void test(T a) {
		System.out.println("generic method:" + a);
	}
//	public static <T super CharSequence> void test(T a) {
//		System.out.println("generic method:" + a);
//	}

	public <T> void test2(T a) {
		System.out.println("generic method:" + a);
	}
	
	public <T> void test22(List<T> a) {
		System.out.println("generic method:" + a);
	}
	
	public <T> void test222(List<? extends T> a) {
		System.out.println("generic method:" + a);
	}
	public <T extends CharSequence> List<T> test2222(List<? extends T> a) {
		System.out.println("generic method:" + a);
		return null;
	}
	public <T extends Comparator<? super T>> List<T> test2w222(T a) {
		System.out.println("generic method:" + a);
		return null;
	}
}

class Generic41<T> {// 

	public static <T extends CharSequence> void test(T a) {
		System.out.println("generic method:" + a);
	}
//	public static <T super CharSequence> void test(T a) {
//		System.out.println("generic method:" + a);
//	}

	public <T> void test2(T a) {// this T is hiding <T> from Generic41
		System.out.println("generic method:" + a);
	}
	
	public <T> void test22(List<T> a) {
		System.out.println("generic method:" + a);
	}
	
	public <T> void test222(List<? extends T> a) {
		System.out.println("generic method:" + a);
	}
	public <T extends CharSequence> List<T> test2222(List<? extends T> a) {
		System.out.println("generic method:" + a);
		return null;
	}

}
