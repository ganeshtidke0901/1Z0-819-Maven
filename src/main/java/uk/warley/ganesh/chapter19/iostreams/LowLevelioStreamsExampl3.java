package uk.warley.ganesh.chapter19.iostreams;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class LowLevelioStreamsExampl3 {

	static void example1() {
		try {
			Reader reader = new FileReader(
					System.getProperty("user.dir") + "/resources/chapter19/folder1/data1.txt");
			Writer writer = new FileWriter(
					System.getProperty("user.dir") + "/resources/chapter19/folder1/data2.txt");// new file is created if
																								// not exists
			int n;
			while ((n = reader.read()) != -1) {
				System.out.print((char) n);
				writer.write(n);

			}

			reader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void example2() {
		try {
			Reader reader = new FileReader(
					System.getProperty("user.dir") + "/resources/chapter19/folder1/data3.txt");
			Writer writer = new FileWriter(
					System.getProperty("user.dir") + "/resources/chapter19/folder1/data4.txt", true);// existing file is
																										// appened
			int n;
			while ((n = reader.read()) != -1) {
				System.out.print((char) n);
				writer.write(n);

			}

			reader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void example3() {
		try (Reader reader = new FileReader(
				System.getProperty("user.dir") + "/resources/chapter19/folder1/data5.txt");
				Writer writer = new FileWriter(
						System.getProperty("user.dir") + "/resources/chapter19/folder1/data6.txt");// existing
																									// file is
		) {

			int n;
			char[] array = new char[100];
			while ((n = reader.read(array)) >0 ) {// n is numner of chars read
				System.out.print(array);
				writer.write(array, 0, n);// or write(array)
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void example4() {
		try (Reader reader = new FileReader(
				System.getProperty("user.dir") + "/resources/chapter19/folder1/data7.txt");
				Writer writer = new FileWriter(
						System.getProperty("user.dir") + "/resources/chapter19/folder1/data8.txt");// existing
																									// file is
		) {

			int n;
			n = reader.read();// n is integer(byte) read from file
			System.out.println((char) n);
			System.out.println(reader.markSupported());// false
			if (reader.markSupported())// if true
			{
				reader.mark(4);// H-->ello-- Ganesh Tidke
				System.out.println((char) reader.read());
				System.out.println((char) reader.read());
				System.out.println((char) reader.read());
				System.out.println((char) reader.read());

				reader.reset();// -->ello-- Ganesh Tidke //throws IOException if read more than marked -4 and
									// called reset or stream was never marked before
				System.out.println((char) reader.read());// e
				reader.skip(1);//-->lo-- Ganesh Tidke 
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
//		example3();
		example4();
	}
}
