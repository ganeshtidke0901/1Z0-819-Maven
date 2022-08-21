package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

import java.util.Iterator;

public class SuppressedExceptionExample7 {

	static void example1()
	{

		try(JammedTurkeyCage cage=new JammedTurkeyCage()) {
			
		} 
//		Exception in thread "main" java.lang.IllegalStateException: cage door does not close
//		at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.JammedTurkeyCage.close(SuppressedExceptionExample7.java:22)
//		at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.SuppressedExceptionExample7.example1(SuppressedExceptionExample7.java:9)
//		at uk.warley.ganesh/uk.warley.ganesh.chapter16.exceptionassertionlocalizaton.SuppressedExceptionExample7.main(SuppressedExceptionExample7.java:14)

	}
	

	static void example2()
	{

		try(JammedTurkeyCage cage=new JammedTurkeyCage()) {
			
		}catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
		
		//cage door does not close

	}
	
	

	static void example3()
	{

		try(JammedTurkeyCage cage=new JammedTurkeyCage()) {
			System.out.println("in try");
			throw new Exception("Exception message");
		}catch (IllegalStateException e) {////catching does not matter
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
//		in try
//		Exception message
		System.out.println("-------------------");
		//IllegalStateException from close is suppressed
		try(JammedTurkeyCage cage=new JammedTurkeyCage()) {
			System.out.println("in try");
			throw new Exception("Exception message");
		}catch (IllegalStateException e) {//catching does not matter
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());//Exception message
			for (Throwable t:e.getSuppressed()) {
				System.out.println(t.getMessage());//cage door does not close
			}
		}
		
//		in try
//		Exception message
//		cage door does not close

	}
	public static void main(String[] args) {
//		example1();
//		example2();
		example3();
	}
}

class JammedTurkeyCage implements AutoCloseable {

	@Override
	public void close() throws IllegalStateException {
		throw new IllegalStateException("cage door does not close");
	}
}
