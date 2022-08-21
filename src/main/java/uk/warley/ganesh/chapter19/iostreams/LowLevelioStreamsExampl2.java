package uk.warley.ganesh.chapter19.iostreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LowLevelioStreamsExampl2 {

	static void example1() {
		try {
			InputStream inputStream = new FileInputStream(
					System.getProperty("user.dir") + "/resources/chapter19/folder1/data1.txt");
			OutputStream outputStream = new FileOutputStream(
					System.getProperty("user.dir") + "/resources/chapter19/folder1/data2.txt");// new file is created if
																								// not exists
			int n;
			while ((n = inputStream.read()) != -1) {
				System.out.print((char) n);
				outputStream.write(n);

			}

			inputStream.close();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void example2() {
		try {
			InputStream inputStream = new FileInputStream(
					System.getProperty("user.dir") + "/resources/chapter19/folder1/data3.txt");
			OutputStream outputStream = new FileOutputStream(
					System.getProperty("user.dir") + "/resources/chapter19/folder1/data4.txt", true);// existing file is
																										// appened
			int n;
			while ((n = inputStream.read()) != -1) {
				System.out.print((char) n);
				outputStream.write(n);

			}

			inputStream.close();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void example3() {
		try (InputStream inputStream = new FileInputStream(
				System.getProperty("user.dir") + "/resources/chapter19/folder1/data5.txt");
				OutputStream outputStream = new FileOutputStream(
						System.getProperty("user.dir") + "/resources/chapter19/folder1/data6.txt");// existing
																									// file is
		) {

			int n;
			byte[] array = new byte[100];
			while ((n = inputStream.read(array)) != -1) {// n is numner of chars read
				System.out.print(array);
				outputStream.write(array, 0, n);// or write(array)
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void example4() {
		try (InputStream inputStream = new FileInputStream(
				System.getProperty("user.dir") + "/resources/chapter19/folder1/data7.txt");
				OutputStream outputStream = new FileOutputStream(
						System.getProperty("user.dir") + "/resources/chapter19/folder1/data8.txt");// existing
																									// file is
		) {

			int n;
			n = inputStream.read();// n is integer(byte) read from file
			System.out.println((char) n);
			System.out.println(inputStream.markSupported());// false
			if (inputStream.markSupported())// if true
			{
				inputStream.mark(4);// H-->ello-- Ganesh Tidke
				System.out.println((char) inputStream.read());
				System.out.println((char) inputStream.read());
				System.out.println((char) inputStream.read());
				System.out.println((char) inputStream.read());

				inputStream.reset();// -->ello-- Ganesh Tidke //throws IOException if read more than marked -4 and
									// called reset or stream was never marked before
				System.out.println((char) inputStream.read());// e
				inputStream.skip(1);//-->lo-- Ganesh Tidke 
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
