package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;



public class SuppressedExceptionExample9 {

	static void example3() {

		try (JammedBrentwoodCage cage = new JammedBrentwoodCage()) {
		} 

//		
//		Exception in thread "main" java.lang.IllegalStateException: cage door does not close
//		at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.JammedBrentwoodCage.close(SuppressedExceptionExample9.java:26)
//		at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.SuppressedExceptionExample9.example3(SuppressedExceptionExample9.java:10)
//		at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.SuppressedExceptionExample9.main(SuppressedExceptionExample9.java:18)

	}
	

	public static void main(String[] args) {
		example3();
	}
}

class JammedBrentwoodCage implements AutoCloseable {

	@Override
	public void close()  {
		throw new IllegalStateException("cage door does not close");
	}
}


