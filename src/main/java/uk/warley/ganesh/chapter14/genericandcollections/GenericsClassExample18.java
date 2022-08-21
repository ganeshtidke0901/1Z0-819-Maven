package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class GenericsClassExample18 {
	public static void main(String[] args) {
		Generic3<String> g3 = () -> "Ganesh";

		// if dont declare generic type parameter while using , it becomes Object class
		Generic3 g4 = new Generic3() {
			@Override
			public Object abc() {
				return null;
			}
		};
		Function function = p -> {
			System.out.println(p);
			return new Object();
		};

		System.out.println(function.apply(new Object()));//
	}

}

interface Generic3<T> {
	T abc();
}

interface Generic33<T extends CharSequence> {
	T abc();
}

//interface Generic331<T super CharSequence> {
//	T abc();
//}

class JJ<T> {
	public void test(List<T> t) {

	}
}

class KK<T> {
	public void test(List<? extends T> t) {

	}

	public void test33(List<? super T> t) {

	}
}

class MM<T> {
//	public void test(List<T extends CharSequence> t) {//cant be T extends someting as T can be anything dynamically 
//		
//	}
}