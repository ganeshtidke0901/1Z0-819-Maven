package uk.warley.ganesh.chapter8.classdesign;

class AC2 {

	public static void test() {
		System.out.println("AC2 test");
	}

	public static void aa() {
		System.out.println("AC2 test");
	}

	public static void bb() {
		System.out.println("AC2 test");
	}
}

public class HidingStaticMethods9 extends AC2 {
	// redeclaring the private method.(it is not overriding or hiding as private methods not inherited)
	public static void test() {
		System.out.println("Child test");
		
	}

	// compiler error - in both cases of hiding or overriding ,both method should be of same type -
	// instance/static
//	public  void aa() {
//		System.out.println("AC2 test");
//	}

	// all rules to applied to hiding from overriding - parent -public and child methd-protected
	// protected static void bb() {
//		System.out.println("AC2 test");
//	}

	public static void main(String[] args) {
		test();//Child test
		AC2.test();//AC2 test
		AC2 ac2=null;
		ac2.test();//AC2 test
	}
}
