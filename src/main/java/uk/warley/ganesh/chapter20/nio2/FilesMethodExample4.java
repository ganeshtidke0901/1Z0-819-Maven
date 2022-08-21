package uk.warley.ganesh.chapter20.nio2;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;

public class FilesMethodExample4 {
	public static void main(String[] args) {
//		example1();
		example2();
//		example3();
//		example4();
//		example5();
//		example6();
//		example7();
	}

	public static void example1() {
		try (var v = Files.newBufferedReader(Path.of(".\\chapter20\\copyFile3"))) {
			String line = "";
			while ((line = v.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (var v = Files.newBufferedWriter(Path.of(".\\chapter20\\copyFile3"))) {

			v.write("Hello");
			v.newLine();
			v.append(" Ganesh");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void example2() {

		try {
			List<String> list = Files.readAllLines(Path.of(".\\chapter20\\copyFile3"));
			list.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void example3() {
	}

	public static void example4() {
	}

	public static void example5() {
	}

	public static void example6() {

	}

	public static void example7() {
	}

}
