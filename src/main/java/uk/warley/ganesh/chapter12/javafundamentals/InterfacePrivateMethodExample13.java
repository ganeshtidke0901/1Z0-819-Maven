package uk.warley.ganesh.chapter12.javafundamentals;

//@FunctionalInterface//optional
interface Walk2 {

	private int getSpeed() {
		return 5;
	}

	private static int getSpeedAgain() {
		return 8;
	}
	public default void walk() {
		getSpeed();
		getSpeedAgain();
	}

//	only private ,private static , default(public) methods allowed
//	protected int getSpeed2() {
//		return 5;
//	}
//	public int getSpeed3() {
//		return 5;
//	}
}

interface Run2 {

}

//private methods in interfaces are never inherited like in class
public class InterfacePrivateMethodExample13 implements Run2, Walk2 {


	public static void main(String[] args) {
		new InterfacePrivateMethodExample13().walk();
	}
}
