package uk.warley.ganesh.chapter13.annotations;

public class CommonAnnotaionsExample2 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Justone.test();
	}
}

abstract class Parent {
	abstract int a();
}

class Child extends Parent {

	@Override // optional but applied, it make sure it is overriding method
	int a() {
		return 0;
	}
}

@FunctionalInterface // marker annotation
interface AA {
	void test();

	String toString();// coming frm Object
}

class Justone {

	@Deprecated(since = "any version may be 1.27.9", forRemoval = true)
	static void test() {
	}
}