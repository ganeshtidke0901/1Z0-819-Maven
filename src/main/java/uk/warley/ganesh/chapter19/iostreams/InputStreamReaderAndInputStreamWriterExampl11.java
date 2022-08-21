package uk.warley.ganesh.chapter19.iostreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class InputStreamReaderAndInputStreamWriterExampl11 {

	static void example1() {
		try (Reader reader = new InputStreamReader(System.in); Writer writer = new OutputStreamWriter(System.out)) {

			System.out.println("Please Enter a valaue:");
			int a = reader.read();
			writer.write(a);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		Please Enter a value:
//			a
//			a
	}

	static void example2() {
		try (Reader reader = new InputStreamReader(new BufferedInputStream(new FileInputStream("filename")));
				Writer writer = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("")))) {

			System.out.println("Please Enter a valaue:");
			int a = reader.read();
			writer.write(a);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		example1();
//		example2();
//		example3();
//		example4();
	}
}
