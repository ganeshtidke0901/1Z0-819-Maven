package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

public class AssertionsExample10 {
	public static void main(String[] args) {

		//by default it is always disabled
		// for this program ,assertions are enabled: -ea /-enableassertions
		// java -ea AssertionsExample10.java
		// java -da AssertionsExample10.java
		// java -ea:com.package1... -da:com.package2.Class1 AssertionsExample10.java
		// java -ea:com.package1.Class2 -da:com.package2... AssertionsExample10.java

		int age = 1;
		assert 1 == age;
		assert 1 == age : "message";
		assert 1 == age : "message";
		assert 1 == age : 11;
		assert (1 == age) : 11;
		assert (age > 1 ? true : false) : 11;

//		assert (11==age):11;//Exception in thread "main" java.lang.AssertionError: 11

		try {// not good practice
			assert (11 == age) : 11;
		} catch (AssertionError e) {
		}

		assert ++age > 1;// not good practice

	}
}
