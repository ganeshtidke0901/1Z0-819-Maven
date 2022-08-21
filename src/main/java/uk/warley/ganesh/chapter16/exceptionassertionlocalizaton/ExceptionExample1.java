package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

import java.io.FileNotFoundException;

public class ExceptionExample1 {
	public static void main(String[] args) {

		try {
			AA.test();
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			AA.abc();
		} catch (Exception e) {
		}

		try {
			AA.xyz();
		} catch (FileNotFoundException e) {
		}

		AA.def();
		AA.test2();// not good practice throw and catch Error explicitly

	}
}

class AA {

	public static void test() throws Throwable {

	}

	public static void abc() throws Exception {
	}

	public static void xyz() throws FileNotFoundException {

	}

	public static void def() throws RuntimeException {

	}

	public static void test2() throws Error {

	}

}