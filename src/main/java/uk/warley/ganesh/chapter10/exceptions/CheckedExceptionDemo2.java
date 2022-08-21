package uk.warley.ganesh.chapter10.exceptions;

import java.io.IOException;

public class CheckedExceptionDemo2 {
	public static void main(String[] args) {

		try {
			example1();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			example2();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		example3();

		try {
			example4();
		} catch (Throwable e2) {
			e2.printStackTrace();
		}

		example5();

		try {
			example6();
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		
		example7();

	}

	private static void example1() throws Exception {
		// if it declares checked exception ten caller has to have handler even this method does not throw
		// exception

	}

	private static void example2() throws Exception {
		try {

		} catch (Exception e) {

		} finally {
			throw new Exception();
		}
	}

	private static void example3() {
		try {
			System.out.println("something");
		} catch (Throwable e) {

		}
	}

	private static void example4() throws Throwable {

		try {
			System.out.println("something");
			throw new Exception();
		} catch (Exception e) {
			throw new Throwable();
		}
	}

	private static void example5() {
		try {

		} catch (Exception e) {
		}

		// IOException is never throw so handler is never reachable
//		try {
//
//		} catch (IOException e) {
//			// TODO: handle exception
//		}

//		try {
//
//		} catch (AbsentInformationException e) {
//			// TODO: handle exception
//		}

//		try {
//			
//		} catch (RandomException e) {
//
//		}

		try {
			throw new IOException();
		} catch (IOException e) {
			// TODO: handle exception
		}

//		try {
//		} catch (BrokenBarrierException e) {
//			// TODO: handle exception
//		}
	}

	private static void example6() throws IOException {
		System.out.println("something");
	}

	private static void example7() throws RuntimeException {
		System.out.println("---something");
	}

	static class RandomException extends Exception {
	}
}
