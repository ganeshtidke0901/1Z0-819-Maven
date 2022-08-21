package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

public class TryWithResourcesExceptionExample4 {
	public static void main(String[] args) {
		System.out.println("Started");
		try (MySomethinigReader2 mySomethinigReader2 = new MySomethinigReader2();) {
			System.out.println("in try block");
		}
//		Started
//		in try block
//		Closed2

		try (MySomethinigReader2 mySomethinigReader2 = new MySomethinigReader2();
				MySomethinigReader3 mySomethinigReader3 = new MySomethinigReader3();) {
			System.out.println("in try block");
		}finally {
			System.out.println("finally");
		}

//		in try block
//		Closed3
//		Closed2
//		finally

	
	
	
	
	}
}

class MySomethinigReader2 implements AutoCloseable {

	@Override
	public void close() {
		System.out.println("Closed2");
	}
}

class MySomethinigReader3 implements AutoCloseable {

	@Override
	public void close() {
		System.out.println("Closed3");
	}
}