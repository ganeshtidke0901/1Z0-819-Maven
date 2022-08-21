package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

public class SuppressedExceptionExample8 {

	static void example3() {

		try (JammedLondonCage cage = new JammedLondonCage()) {
			System.out.println("in try");
			throw new Exception("Exception message");
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());// Exception message
			for (Throwable t : e.getSuppressed()) {
				System.out.println(t.getMessage());// cage door does not close
			}
		}

//		in try
//		Exception message
//		cage door does not close		
	}
	
	static void example4() {

	
		try (JammedLondonCage cage = new JammedLondonCage();JammedLondonCage cage2 = new JammedLondonCage()) {
			System.out.println("in try");
			throw new RuntimeException("Exception message");
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		} 
		
		// main exception that is RuntimeException is not caught
//		in try
//		Exception in thread "main" java.lang.RuntimeException: Exception message
//			at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.SuppressedExceptionExample8.example4(SuppressedExceptionExample8.java:29)
//			at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.SuppressedExceptionExample8.main(SuppressedExceptionExample8.java:63)
//			Suppressed: java.lang.IllegalStateException: cage door does not close
//				at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.JammedLondonCage.close(SuppressedExceptionExample8.java:71)
//				at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.SuppressedExceptionExample8.example4(SuppressedExceptionExample8.java:30)
//				... 1 more
//			Suppressed: java.lang.IllegalStateException: cage door does not close
//				at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.JammedLondonCage.close(SuppressedExceptionExample8.java:71)
//				at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.SuppressedExceptionExample8.example4(SuppressedExceptionExample8.java:30)
//				... 1 more

	
	}
	static void example5() {

		
		try (JammedScotlandCage cage = new JammedScotlandCage()) {
			System.out.println("in try");
			throw new RuntimeException(new Exception("HEHEHEHHH"));
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		} 
		
		// main exception that is RuntimeException is not caught
//		in try
//		Exception in thread "main" java.lang.RuntimeException: java.lang.Exception: HEHEHEHHH
//			at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.SuppressedExceptionExample8.example5(SuppressedExceptionExample8.java:55)
//			at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.SuppressedExceptionExample8.main(SuppressedExceptionExample8.java:67)
//			Suppressed: java.lang.IllegalStateException: cage door does not close
//				at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.JammedScotlandCage.close(SuppressedExceptionExample8.java:84)
//				at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.SuppressedExceptionExample8.example5(SuppressedExceptionExample8.java:56)
//				... 1 more
//		Caused by: java.lang.Exception: HEHEHEHHH
	}

	public static void main(String[] args) {
//		example3();
//		example4();
		example5();
	}
}

class JammedLondonCage implements AutoCloseable {

	@Override
	public void close() {
		throw new IllegalStateException("cage door does not close");
	}
}


class JammedScotlandCage implements AutoCloseable {

	@Override
	public void close() {
		throw new IllegalStateException("cage door does not close");
	}
}
