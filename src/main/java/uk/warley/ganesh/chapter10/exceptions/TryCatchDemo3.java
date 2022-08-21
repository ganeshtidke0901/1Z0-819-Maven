package uk.warley.ganesh.chapter10.exceptions;

public class TryCatchDemo3 {
	public static void main(String[] args) {
//		System.out.println(example6());
//	
//		example5();
//		example4();
//		example3();
//		example2();
//		example1();
//		example8();
		System.out.println(example9());
	}

	private static void example1() {
		try {
		} catch (Exception e) {
		}

		try {
		} catch (Exception e) {
		}
//		catch (Exception e) {//duplicate does not work
//		}
	}

	private static void example2() {
		try {
		} catch (Exception e) {
		}
//		catch (RuntimeException ) {//does not work as broader exception handler is declared first so it wont come to RuntimeException
//		}
		finally {
		}
	}

	private static void example3() {
		try {

		} catch (ClassCastException | IllegalArgumentException e) {
		}

		try {

		} catch (IllegalArgumentException | ClassCastException e) {
		} catch (RuntimeException e) {
		}

//		try {
//		} catch (ClassCastException | RuntimeException e) { //cant have redundant types and should not be related
//		}

//		try {
//
//		} catch (IllegalArgumentException e | ClassCastException e) {//can have only one variable declared
//		}

	}

	private static void example4() {
		try {
		} finally {
		}
	}

	private static void example5() {

		// throws Arithmetic exception as the last exception from this method as catch one is
		
//		Exception in thread "main" java.lang.ArithmeticException
//		at uk.warley.ganesh/uk.warley.ganesh.chapter10.exceptions.TryCatchDemo3.example5(TryCatchDemo3.java:74)
//		at uk.warley.ganesh/uk.warley.ganesh.chapter10.exceptions.TryCatchDemo3.main(TryCatchDemo3.java:7)
		try {
			throw new RuntimeException();
		} catch (Exception e) {
			throw new IllegalArgumentException();
		} finally {
			throw new ArithmeticException();
		}
	}

	private static int example6() {

		try {
			throw new RuntimeException();
		} catch (Exception e) {
			throw new IllegalArgumentException();
		} finally {
			throw new ArithmeticException();
		}
	}

	private static int example7() {

		// returns 2
		try {
			throw new RuntimeException();
		} catch (Exception e) {
			return 1;
		} finally {
			return 2;
		}
	}

	private static int example8() {

		// finally is not executed
		try {
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("A");
			System.exit(0);
			return 1;
		} finally {
			System.out.println("B");
			return 2;
		}
	}

	private static int example9() {

		// A
		// B
		// RuntimeException
		try {
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("A");
			return 1;
		} finally {
			System.out.println("B");
			throw new RuntimeException();
		}
	}

}
