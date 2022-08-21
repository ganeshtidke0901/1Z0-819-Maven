package uk.warley.ganesh.chapter10.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResources4 {
	public static void main(String[] args) {
//		System.out.println(example7());
//		example8();
//		example5();
//		example4();
		example3();
//		example2();
//		example1();

	}

	private static void example1() {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("d.txt");
		} catch (Exception e) {

		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (Exception e2) {
				}
			}
		}

//		OR 

		try (FileInputStream fileInputStream2 = new FileInputStream("b.txt")) {

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void example2() {
//		C c=null;	- Syntax error on token "c", VariableDeclaratorId expected after 

//		try( c=new C();)
//		{
//			
//		}

//		Closing it
//		Handler
//		Finally
		try (C c = new C();) {// implicit finally is added by compiler at the end but run first before any catch/finally
			throw new Exception();
		} catch (Exception e) {
			System.out.println("Handler");
		} finally {
			System.out.println("Finally");
		}

	}

	private static void example3() {
//		Hello
//		Closing it
//		Finally
	
		try (C c = new C();) {// implicit finally is added by compiler at the end but run first before any catch/finally
		System.out.println("Hello");
		} catch (Exception e) {
			System.out.println("Handler");
		} finally {
			System.out.println("Finally");
		}
	}

	private static void example4() {
	}

	private static void example5() {
	}

//	private static int example6() {
//	}
//
//	private static int example7() {
//	}
//
//	private static int example8() {
//	}

	static class C implements AutoCloseable {

		@Override
		public void close() throws Exception {
			System.out.println("Closing it");

		}

	}
}
