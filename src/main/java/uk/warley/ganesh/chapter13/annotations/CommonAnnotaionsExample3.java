package uk.warley.ganesh.chapter13.annotations;

import java.util.ArrayList;
import java.util.List;

public class CommonAnnotaionsExample3 {

	public static void main(String[] args) {
		test1();
		System.out.println("hello");
	}

	@SuppressWarnings("deprecation") // uk\warley\ganesh\chapter13\annotations\CommonAnnotaionsExample2.java:17:
										// warning: [removal] test() in JustAnother has been deprecated and marked for
										// removal JustAnother.test();
	static void test1() {
		JustAnother.test();
	}

	@SuppressWarnings("unchecked") // Note: uk\warley\ganesh\chapter13\annotations\CommonAnnotaionsExample2.java uses
									// unchecked or unsafe operations.
	static void test2() {
		JustAnother.test2(new ArrayList());
		// or
		List<String> s = new ArrayList();
	}
}

class JustAnother {

	@Deprecated(since = "1.1", forRemoval = true)
	static public void test() {
		System.out.println("");
	}
	static public void test2(List<String> s) {
		System.out.println("");
	}
}