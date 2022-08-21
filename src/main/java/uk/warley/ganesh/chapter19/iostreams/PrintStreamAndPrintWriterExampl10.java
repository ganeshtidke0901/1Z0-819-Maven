package uk.warley.ganesh.chapter19.iostreams;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Locale;

public class PrintStreamAndPrintWriterExampl10 {

	static void example1() {
		try (PrintWriter printWriter = new PrintWriter(
				System.getProperty("user.dir") + "/resources/chapter19/folder1/zoo.log");
				PrintStream printStream = new PrintStream(
						System.getProperty("user.dir") + "/resources/chapter19/folder1/zoo1.log");) {

//			System.out//this is an object of printStream

			printStream.print(1);
			printWriter.print(1);

			printStream.println();
			printWriter.println();

			printStream.println("Hello");
			printWriter.println("Hello");

			printStream.format("Hello %d \n", 1);
			printWriter.format("Hello %d \n", 1);

			printStream.format(Locale.FRANCE, "Hello %d  \n", 10000);
			printWriter.format(Locale.FRANCE, "Hello %d  \n", 10000);

			System.out.format(Locale.FRANCE, "Hello %d  \n", 10000);// Hello 10000
//			System.out.format("%f", 10000);//java.util.IllegalFormatConversionException
			System.out.format("%d", 10000);// 10000
			System.out.println();
			System.out.format("%.1f", 10000f);// 10000.0
			System.out.println();
			System.out.format("%11.1f", 10000f);// 10000.0
			System.out.println();
			System.out.format("%011.1f", 10000f);// 000010000.0
			System.out.println();
			System.out.format("%1.3f", 100.1235f);// 100.123

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	static void example2() {

		try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(
				new FileWriter(System.getProperty("user.dir") + "/resources/chapter19/folder1/zoo2.log")));
				PrintStream printStream = new PrintStream(new BufferedOutputStream(new FileOutputStream(
						System.getProperty("user.dir") + "/resources/chapter19/folder1/zoo3.log")));) {

			printStream.print(1);
			printWriter.print(1);

			printStream.println();
			printWriter.println();

			printStream.println("Hello");
			printWriter.println("Hello");

			printStream.format("Hello %d \n", 1);
			printWriter.format("Hello %d \n", 1);

			printStream.format(Locale.FRANCE, "Hello %d  \n", 10000);
			printWriter.format(Locale.FRANCE, "Hello %d  \n", 10000);

			System.out.format(Locale.FRANCE, "Hello %d  \n", 10000);// Hello 10000
//			System.out.format("%f", 10000);//java.util.IllegalFormatConversionException
			System.out.format("%d", 10000);// 10000
			System.out.println();
			System.out.format("%.1f", 10000f);// 10000.0
			System.out.println();
			System.out.format("%11.1f", 10000f);// 10000.0
			System.out.println();
			System.out.format("%011.1f", 10000f);// 000010000.0
			System.out.println();
			System.out.format("%1.3f", 100.1235f);// 100.123

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	static void example3() {

		// printwriter can take outputstream
		// but printstream wont take writer
		try (PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(
				new FileOutputStream(System.getProperty("user.dir") + "/resources/chapter19/folder1/zoo6.log")));
				PrintStream printStream = new PrintStream(new BufferedOutputStream(new FileOutputStream(
						System.getProperty("user.dir") + "/resources/chapter19/folder1/zoo7.log")));) {

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	static void example4() throws FileNotFoundException {
		System.out.println("closing stream");
		try (System.out) {
		}
		System.out.println("dfasdf");// nothign is printed as stream is closed and also does not thrwo any exception

		
		//but
		BufferedReader reader=new BufferedReader(new FileReader(System.getProperty("user.dir") + "/resources/chapter19/folder1/zoo.log"));
		try (reader) {
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//java.io.IOException: Stream closed
		
	}

	public static void main(String[] args) throws FileNotFoundException {
//		example1();
//		example2();
//		example3();
		example4();

	}
}
