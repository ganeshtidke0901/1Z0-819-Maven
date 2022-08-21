package uk.warley.ganesh.chapter8.classdesign;

class AC3 {

	final public static void test() {
		System.out.println("AC2 static test");
	}

	final public void aa() {
		System.out.println("AC2 test");
	}

}

public class FinalMethods10 extends AC3 {

	//final methods are always inherited
//	final method can't be overrided or hidden
//	public static void test() {
//		System.out.println("Child test");
//	}
//
//	@Override
//	public void aa() {
//		System.out.println("AC2 test");
//	}

	public static void main(String[] args) {
		
		test();//AC2 static test
		new FinalMethods10().aa();//AC2 test
	}
}
