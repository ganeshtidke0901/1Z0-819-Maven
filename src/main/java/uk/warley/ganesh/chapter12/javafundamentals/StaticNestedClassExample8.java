package uk.warley.ganesh.chapter12.javafundamentals;

public class StaticNestedClassExample8 {
	private static int a = 11;
	private int b = 12;

	private void test() {
	}

	static public class Inner1 {
		private static int a = 1;
		private int b = 2;

		private void printMe() {
			System.out.println("Printing inner1");
			System.out.println("Inner1 :" + a + "---" + b);// Inner1 :1---0
			System.out.println("Inner1 :" + this.a + "---" + this.b);// Inner1 :1---0
			StaticNestedClassExample8 classExample1 = new StaticNestedClassExample8();
			System.out.println(classExample1.b);// 12
			System.out.println(StaticNestedClassExample8.a);// 11
		}

		public static void printMe2() {

			System.out.println("Printing inner1");
			System.out.println("Inner1 :" + a + "---");// Inner1 :1---b does not work as it is instance variable
//			System.out.println("Inner1 :" + this.a + "---" + this.b);// this cant be used as it is static methods
			StaticNestedClassExample8 classExample1 = new StaticNestedClassExample8();
			System.out.println(classExample1.b);// 12
			System.out.println(StaticNestedClassExample8.a);// 11
//			System.out.println(StaticNestedClassExample8.this);//cant use as you are trying to access outer class object from static context(here it is static nested class )

		}

		public final static void printMe3() {
		}

	}

//	static abstract void method1() {} //here method is abstract which is supposed to be overridden and static says if inherited by child then should be hidden 

	static abstract class Inner2 extends Inner1 {
	}

	final protected class Inner3 {
	}

	public class Inner4 {
	}

	public static void main(String[] args) {
		Inner1 inner1 = new Inner1();
//		OR StaticNestedClassExample8.Inner1 inner1 = new Inner1();
		inner1.printMe();// outer class can access inner class private method
		System.out.println(inner1.a);// 1
		System.out.println(Inner1.a);// 1
		System.out.println(StaticNestedClassExample8.Inner1.a);// 1
		System.out.println(inner1.b);// 2
	}

}
