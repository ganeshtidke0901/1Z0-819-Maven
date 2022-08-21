package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

public class CustomExceptionExample2 {
	public static void main(String[] args) throws XYZException2, XYZException3 {

//		Exception in thread "main" uk.warley.ganesh.chapter16.exceptionassertonlocalizaton.XYZException2
//		at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertonlocalizaton.CustomExceptionExample2.main(CustomExceptionExample2.java:6)
//		throw new XYZException2();

//		Exception in thread "main" uk.warley.ganesh.chapter16.exceptionassertonlocalizaton.XYZException2: Issue in something
//		at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertonlocalizaton.CustomExceptionExample2.main(CustomExceptionExample2.java:10)
//		throw new XYZException2("Issue in something");

//		Exception in thread "main" uk.warley.ganesh.chapter16.exceptionassertonlocalizaton.XYZException2: java.lang.RuntimeException: SOme other issue
//		at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertonlocalizaton.CustomExceptionExample2.main(CustomExceptionExample2.java:15)
//	Caused by: java.lang.RuntimeException: SOme other issue
//		throw new XYZException2(new RuntimeException("SOme other issue"));

//		Exception in thread "main" uk.warley.ganesh.chapter16.exceptionassertonlocalizaton.XYZException3
//		at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertonlocalizaton.CustomExceptionExample2.main(CustomExceptionExample2.java:21)
//		throw new XYZException3();

//		Exception in thread "main" uk.warley.ganesh.chapter16.exceptionassertonlocalizaton.XYZException3
//		at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertonlocalizaton.CustomExceptionExample2.main(CustomExceptionExample2.java:25)
//		throw new XYZException3("Hello");

//		Exception in thread "main" uk.warley.ganesh.chapter16.exceptionassertonlocalizaton.XYZException3
//		at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertonlocalizaton.CustomExceptionExample2.main(CustomExceptionExample2.java:30)		
//		throw new XYZException3(new RuntimeException("SOme other issue"));

	}
}

class XYZException2 extends Exception {
	public XYZException2() {
		super();// by default it put super() as first statement
	}

	public XYZException2(String s) {
		super(s);

	}

	public XYZException2(Throwable t) {
		super(t);
	}

	public XYZException2(Exception t) {
		super(t);

	}

	public XYZException2(String s, Throwable t) {
		super(s, t);
	}
}

class XYZException3 extends Exception {
	public XYZException3() {
	}

	public XYZException3(String s) {

	}

	public XYZException3(Throwable t) {
	}

	public XYZException3(Exception t) {

	}

	public XYZException3(String s, Throwable t) {
	}
}
