package uk.warley.ganesh.chapter9.advanceclassdesign;

interface Runner4 {
}

interface Runner5 extends Runner4 {
}

interface A1 {
}

interface B1 {
}

class DD implements Runner5 {
}

interface UnrelatedInterface {
}

public class CastingInterfaces10 {

	static void test1() {
		Runner5 runner5 = new DD();
		Runner4 runner4 = null;
		runner4 = runner5;
		UnrelatedInterface interface1 = null;
		System.out.println(runner4 instanceof Runner4);// true;
		System.out.println(interface1 instanceof Runner4);// false;

	}

	static void test2() {
		Runner4 runner4 = null;
		Runner5 runner5 = null;
		runner4 = (Runner4) runner5;

	}

	static void test3() {
		A1 a=null;
		B1 b=null;
		System.out.println(a instanceof A1);//false
		a=(A1) b;
		b=(B1) a;
		
		System.out.println(a instanceof A1);//false
		
	}
	static void test5() {
		A1 a=new A1() {
		};
		B1 b=new B1() {
		};
		System.out.println(a instanceof A1);//false
		a=(A1) b;//Exception in thread "main" java.lang.ClassCastException
		b=(B1) a;//Exception in thread "main" java.lang.ClassCastException:
		
		System.out.println(a instanceof A1);//false
		
	}
	static void test4() {

	}

	public static void main(String[] args) {
		test5();
	}
}
