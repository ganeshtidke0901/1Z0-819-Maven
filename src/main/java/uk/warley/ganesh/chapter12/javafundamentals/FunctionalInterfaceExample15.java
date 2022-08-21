package uk.warley.ganesh.chapter12.javafundamentals;

@FunctionalInterface // optional
interface Sprintn {
	public void sprint(int speed);// only one abstarct method
}

@FunctionalInterface // optional
interface Sprint1 {

	private static void abc() {

	}

	private void xyz() {

	}

	default void mno() {

	}

	void pqr();// only one abstract method

}

//@FunctionalInterface // if it is mentioned then there has to be one abstract method
//interface Sprint2 {
//}

@FunctionalInterface // optional
interface Sprint3 {
	String toString();// public abstarct but implentor will always implement as it is inherited from Obect class so does
						// not count as abstract method 

	boolean equals(Object o);// again it is specified in Objects

	int hashCode();// specified in Objects

	public int xyz();// only one abstarct method
}

@FunctionalInterface // optional
interface Sprint4 {
	String toString();// public abstarct but implentor will always implement as it is inherited from Obect class so does
						// not count as abstract method 

	boolean equals(String o);// // only one abstarct method not from Object class

	int hashCode();// specified in Objects

}

public class FunctionalInterfaceExample15 {

}
