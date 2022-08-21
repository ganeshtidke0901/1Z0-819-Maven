package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.function.Consumer;

public class WildCardExample22 {

	public static void main(String[] args) {
		AA<String> a = new AA<String>();

		a.doSomething(s -> System.out.println());
		Consumer<? super String> t1 = s -> System.out.println(s);
		Consumer<? super Object> t2 = s -> System.out.println(s);
		Consumer<? extends String> t3 = s -> System.out.println(s);
		Consumer<? extends CharSequence> t31 = s -> System.out.println(s);
		a.doSomething(t1);
		a.doSomething(t2);
		Object o1=null;
		t1.accept("");//though it becomes accept(Object w),  it allows String only
//		t31.accept("");//though it becomes accept(CharSequence) , it allows nothing, t31 becomes read only
		
		t1=t2;
//		t2=t1;//error
		t2=(Consumer<? super Object>) t1;
		
		t1=(Consumer<? super String>) t3;
		t3=(Consumer<? extends String>) t1;
		
		t31=t3;
		t3=(Consumer<? extends String>) t31;
		
		Consumer<Object> t4 = s -> System.out.println(s);
		t1=t4;
		a.doSomething(t4);
		
		
	}
}

class AA<T> {
	public void doSomething(Consumer<? super T> t) {
	}

}