package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;



public class SuppressedExceptionExample10 {

	static void example3() {

		
		
		try (JammedSchenfieldCage cage = new JammedSchenfieldCage()) {
		 System.out.println("in try");
		 throw new RuntimeException("Runtime Exception message");
		}finally {
			throw new IllegalStateException("finally thrown message");
		}
		

		//finally does not show suppressed one
//		in try
//		Exception in thread "main" java.lang.IllegalStateException: finally thrown message
//			at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.SuppressedExceptionExample10.example3(SuppressedExceptionExample10.java:13)
//			at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.SuppressedExceptionExample10.main(SuppressedExceptionExample10.java:23)


	}
	
static void example4() {

		
		try {
			try (JammedSchenfieldCage cage = new JammedSchenfieldCage()) {
				 System.out.println("in try");
				 throw new RuntimeException("Runtime Exception message");
				}finally {
					throw new IllegalStateException("finally thrown message");
				}	
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
			for (Throwable t : e.getSuppressed()) {
				System.out.println(t.getMessage());
			}
		}
	
//		in try
//		finally thrown message

//it means finally thrown exception does not capture/cover suppressed exceptions
	}
	

	public static void main(String[] args) {
//		example3();
		example4();
	}
}

class JammedSchenfieldCage implements AutoCloseable {

	@Override
	public void close()  {
		throw new IllegalStateException("cage door does not close");
	}
}


