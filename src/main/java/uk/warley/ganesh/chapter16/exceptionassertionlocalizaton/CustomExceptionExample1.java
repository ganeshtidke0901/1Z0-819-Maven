package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

public class CustomExceptionExample1 {
	public static void main(String[] args) {

	}
}

class XYZException extends Exception {
	public XYZException() {
		super();// by default it put super() as first statement
	}

	public XYZException(String s) {
		super(s);
	}

	public XYZException(Throwable t) {
		super(t);
	}
	public XYZException(Exception t) {
		super(t);
	}
	public XYZException(String s, Throwable t) {
		super(s, t);
	}
	
	
	
	
}
