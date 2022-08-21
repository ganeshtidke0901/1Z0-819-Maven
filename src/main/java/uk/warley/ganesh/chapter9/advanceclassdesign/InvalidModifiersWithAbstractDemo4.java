package uk.warley.ganesh.chapter9.advanceclassdesign;

abstract class Class4 {

// abstract method has to be overridden but static is for hiding not for overriding so does not work
//	public abstract static void test();

	// abstract method has to be overridden but private is never inherited so does not work
//		public abstract private void test();

	// abstract method has to be overridden but final method is to be never overridden
//		public abstract final void test();

	static private void test() {
	}

	final private void test2() {
	}

	//final static method in child class is never be hidden  and if it is not static then never be overridden 
	final static void test3() {
	}

}


public class InvalidModifiersWithAbstractDemo4 extends Class4 {

}
