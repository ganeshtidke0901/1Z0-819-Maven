package uk.warley.ganesh.chapter12.javafundamentals;

public class InnerClassExample7 {
	private static int a = 11;
	private int b = 12;

	private void test() {
	}

	private class Inner1 {
//		private static int a;//cant be declared static unless is constant (final static)
		final private static int a = 1;
		private int b = 2;

		private void printMe() {
			System.out.println("Printing inner1");
			System.out.println("Inner1 :" + a + "---" + b);// Inner1 :1---0
			System.out.println("Inner1 :" + this.a + "---" + this.b);// Inner1 :1---0
			System.out.println("Inner1 :" + InnerClassExample7.this.a + "---" + InnerClassExample7.this.b);// Inner1
		}
//		public static void printMe2() {}//cant have static method
		
//		public final static void printMe2() {}//cant have even final static method 
	}

	abstract class Inner2 extends Inner1 {
	}

	protected final class Inner3{
	}

	public class Inner4 {
	}

	public static void main(String[] args) {
		InnerClassExample7 classExample1 = new InnerClassExample7();
		InnerClassExample7.Inner1 inner1 = classExample1.new Inner1();
		inner1.printMe();//outer class can access inner class private method
		System.out.println(inner1.a);//1
		System.out.println(inner1.b);//2
	}
}
