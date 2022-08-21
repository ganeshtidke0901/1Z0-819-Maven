package uk.warley.ganesh.chapter9.advanceclassdesign;

abstract class Class3 {
	int a;

	Class3() {
		System.out.println("Class3()");
	}

	public Class3(int a) {
		System.out.println("Class3(int a)");
	}

	abstract void test();

	void test2() {
	}

}

public class AbstractClassDemo2 extends Class3 {
	public static void main(String[] args) {
		var a = new AbstractClassDemo2();//Class3()
	}

	@Override
	void test() {
	}
}
