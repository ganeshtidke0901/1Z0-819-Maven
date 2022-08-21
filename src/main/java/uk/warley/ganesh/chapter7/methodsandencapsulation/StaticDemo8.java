package uk.warley.ganesh.chapter7.methodsandencapsulation;

public class StaticDemo8 {

	public static void main(String[] args) {
		StaticDemo8 demo = new StaticDemo8();
		demo.method1();

		StaticDemo8 demo2 = null;
		demo2.method1();// still works as compiler converts it into StaticDemo.method1()

		StaticDemo8.method1();
	}

	static void method1() {
		System.out.println("method1");
	}
}
