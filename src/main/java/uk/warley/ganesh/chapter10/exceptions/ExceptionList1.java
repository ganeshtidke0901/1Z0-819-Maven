package uk.warley.ganesh.chapter10.exceptions;

public class ExceptionList1 {
	static {

//		Exception in thread "main" java.lang.ExceptionInInitializerError
//		Caused by: java.lang.ArithmeticException: / by zero
//		int i = 1 / 0;

	}

	public static void main(String[] args) {
//		example1();
//		example2();
//		example3();
//		example4("");
		example5();
		example6();
	}

	static void example1() {
		int i = 1 / 0;// java.lang.ArithmeticException: / by zero
	}

	private static void example2() {
		int[] arr = { 12, 3 };
		System.out.println(arr[2]);// ArrayIndexOutOfBoundsException
	}

	private static void example3() {
		String s = "Ganesh";
		Object o = s;
		Integer integer = (Integer) o;// ClassCastException

	}

	private static void example4(String s) {
//		IllegalArgumentException

		if (!(s instanceof String)) {
			throw new IllegalArgumentException("Invalid s type");
		}

	}

	private static void example5() {

//		Integer integer = Integer.valueOf("gaehs");// NumberFormatException
		String s=Integer.toBinaryString(55);
		System.out.println(s);
	}

	private static void example6() {

		// NoClassDefFoundError- thrown when class is not found at time but was present at compile time

	}

}
