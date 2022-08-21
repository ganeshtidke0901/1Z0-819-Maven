package uk.warley.ganesh.chapter8.classdesign;

class AC1 {

	private int test() {
		return 0;
	}
}

public class ReDeclaringPrivateMethods6 extends AC1 {
	// redeclaring the private method.(it is not overriding or hiding as private methods not inherited)
	private int test() {
		return 0;
	}

	public static void main(String[] args) {

	}
}
