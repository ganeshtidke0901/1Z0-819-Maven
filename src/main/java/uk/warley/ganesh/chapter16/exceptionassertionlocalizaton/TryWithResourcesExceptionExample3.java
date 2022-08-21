package uk.warley.ganesh.chapter16.exceptionassertionlocalizaton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExceptionExample3 {
	public static void main(String[] args) throws FileNotFoundException { // it is fine throw FileNotFoundException

		// it is fine to declare FileNotFoundException if nothing is being thrown in method but it is not
		// fine to catch FileNotFoundException when nothing is being thrown from try body
//		try {
//		} catch (FileNotFoundException e2) {// Unreachable catch block for FileNotFoundException. This exception is
//											// never thrown from the try statement body
//		}

		// this is ok
		try {
		} catch (Exception e) {
		}

		try {
			FileReader fileReader0 = new FileReader(new File("sompath"));
		} catch (FileNotFoundException e2) {// this is coming from FileReader constructor. exception fromn close() is
											// considered when try with resources is used
		}

		try (FileReader fileReader = new FileReader(new File("sompath"))) {
		} catch (FileNotFoundException e1) { // FileNotFoundException coming from constructor of FileReader
		} catch (IOException e1) {// and IOException is coming from // FileReader's inherited close() method
		}

		MyFileReader myfileReader = null;
		try (myfileReader) // either myFileReader or MyFileReader myfileReader=new MyFileReader()
		{
		} catch (Exception e) { // this Exception being thrown by MyFileReader close method
		}

		try (MyFileReader myfileReader2 = new MyFileReader()) // either myFileReader or MyFileReader myfileReader=new
																// MyFileReader()
		{
		} catch (Exception e) { // this Exception being thrown by MyFileReader close method
			e.printStackTrace();
		}

		try (MySomethinigReader myfileReader2 = new MySomethinigReader()) // either myFileReader or MyFileReader
																			// myfileReader=new MyFileReader()
		{
		}
		try (AutoCloseable myfileReader2 = new MySomethinigReader()) // either myFileReader or MyFileReader
		{
		} catch (Exception e) {//coming from AutoCloseable
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class MyFileReader implements AutoCloseable {

	@Override
	public void close() throws Exception { // interface AutoCloseable{ void close() throws Exception;}

	}
}

class MySomethinigReader implements AutoCloseable {

	@Override
	public void close() { // interface AutoCloseable{ void close() throws Exception;}

	}
}