package uk.warley.ganesh.chapter19.iostreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class HighLevelioStreamsExampl5 {

	static void example1() {
		try {
			InputStream fileInputStream = new FileInputStream(
					System.getProperty("user.dir") + "/resources/chapter19/folder1/data9.txt");
			OutputStream fileOutputStream = new FileOutputStream(
					System.getProperty("user.dir") + "/resources/chapter19/folder1/data10.txt", false);// append to
																										// existing file
																										// or create new
																										// file is
																										// created

			try (BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
					BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {
				// this try will close the stream automatically calling clos() and also calls close for low level
				// streams passed to it
				int n;
				byte[] bytes = new byte[10];
				while ((n = bufferedInputStream.read(bytes, 0, bytes.length)) > 0) {
					System.out.print(bytes);
					fileOutputStream.write(bytes, 0, n);
				}
				bufferedOutputStream.flush();
			} finally {

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void example2() {
		try (Reader reader = new FileReader(System.getProperty("user.dir") + "/resources/chapter19/folder1/data9.txt");
				Writer writer = new FileWriter(
						System.getProperty("user.dir") + "/resources/chapter19/folder1/data10.txt"); // existing
																										// file is
				BufferedReader bufferedReader = new BufferedReader(reader);
				BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

			String line;
			while ((line = bufferedReader.readLine()) != null) {// n is numner of chars read
				System.out.print(line);
				bufferedWriter.write(line);// or write(array)
			}
			bufferedWriter.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
//		example1();
		example2();
	}
}
