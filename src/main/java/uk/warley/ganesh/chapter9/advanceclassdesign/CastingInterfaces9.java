package uk.warley.ganesh.chapter9.advanceclassdesign;

interface Runner3 {
}

class A implements Runner3 {
}

class B implements Runner3 {
}

final class C {

}

final class D implements Runner3 {

}

public class CastingInterfaces9 {

	static void test1() {
		Runner3 r1 = new A();
		Runner3 r2=(B)r1;//ClassCastException
		B b=(B)r1;//ClassCastException

	}

	static void test2() {

		Runner3 r1 = new A();
		B b = new B();
		
		System.out.println(b instanceof Runner3);// true
		System.out.println(r1 instanceof Runner3);// true
		System.out.println(r1 instanceof B);// false whatever r1 is holding can be assigned to B reference:NO

	}

	static void test3() {
		CastingClasses8 castingClasses = new CastingClasses8();
		
		Runner3 runner3 = (Runner3) castingClasses;// ClassCastException
		castingClasses = (CastingClasses8) runner3;// ClassCastException
		System.out.println(castingClasses instanceof Runner3);// false //unrelated but does not show error as it is
		// having interface
//		Runner3 runner3=null;
		System.out.println(runner3 instanceof  CastingClasses8);// false //unrelated but does not show error as it is
		// having interface

		
	}

	static void test4() {

		C c = new C();
		Runner3 r1 = new A();
//		System.out.println(c instanceof Runner3); //as C is final class and does not extend Runner3
//		System.out.println(r1 instanceof C); ////as C is final class and does not extend Runner3

	}

	public static void main(String[] args) {
		test3();

		// classes casting with unrelated classes -compiler errors
		// instanceof with unrelated classes -compiler errors
		
		// inteerface casting with unrelated interface- compiler no error
		// instanceof with unrelated interface -compiler no error
		//
	//as C is final class and does not extend Runner3 - compoler error
		
	}
}
