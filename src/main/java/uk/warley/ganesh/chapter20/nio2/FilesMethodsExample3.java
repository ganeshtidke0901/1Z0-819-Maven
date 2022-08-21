package uk.warley.ganesh.chapter20.nio2;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesMethodsExample3 {
	public static void main(String[] args) {
//		example1();
//		example2();
//		example3();
//		example4();
//		example5();
//		example6();
//		example7();
		example8();
	}

	public static void example1() {

		System.out.println(
				Files.exists(Path.of("C:\\Users\\ganes\\OneDrive\\Desktop\\1Z0-819\\chapter20\\Ganesh\\folder")));// true

		System.out.println(Files
				.exists(Paths.get("C:\\Users\\ganes\\OneDrive\\Desktop\\1Z0-819\\chapter20\\Ganesh\\folder21.lnk")));// true
		System.out.println(Files.exists(
				Paths.get("C:\\Users\\ganes\\OneDrive\\Desktop\\1Z0-819\\chapter20\\Ganesh\\folder2\\folder2.txt")));// true

		System.out.println(Files.exists(
				Paths.get("C:\\Users\\ganes\\OneDrive\\Desktop\\1Z0-819\\chapter20\\Ganesh\\folder2\\..\\folder4")));// true

	}

	public static void example2() {

		Path path1 = Path.of("C:\\Users\\ganes\\OneDrive\\Desktop\\1Z0-819\\chapter20\\Ganesh\\folder2\\folder2.txt");
		Path path2 = Path.of(
				"C:\\Users\\ganes\\OneDrive\\Desktop\\1Z0-819\\chapter20\\Ganesh\\folder2\\..\\folder2\\folder2.txt");

		Path path3 = Path.of("C:\\Users\\ganes\\OneDrive\\Desktop\\1Z0-819\\chapter20\\Ganesh\\folder2\\folder3.txt");
		Path path4 = Path.of("C:\\Users\\ganes\\OneDrive\\Desktop\\1Z0-819\\chapter20\\Ganesh\\folder2\\folder3.txt");

		Path path5 = Path.of("C:\\Users\\ganes\\OneDrive\\Desktop\\1Z0-819\\chapter20");
		Path path6 = Path.of("chapter20");// OR ./chapter20

		Path path7 = Path.of("chapter21");// OR ./chapter20

		try {
			// resolves all path symbols and follows the symbolic link and check for file existence
			System.out.println(Files.isSameFile(path1, path2));// true

			// does not check for file existence if two paths are equals()
			System.out.println(Files.isSameFile(path3, path4));// true

			System.out.println(path3.equals(path4));// true

			System.out.println(Files.isSameFile(path5, path6));// true
			System.out.println(path6.toAbsolutePath());// C:\Users\ganes\OneDrive\Desktop\1Z0-819\chapter20

			System.out.println(Files.isSameFile(path5, path7));// java.nio.file.NoSuchFileException: chapter21
			System.out.println(path7.toAbsolutePath());// C:\Users\ganes\OneDrive\Desktop\1Z0-819\chapter21

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void example3() {
		try {
			// createdDirectory1 is created if not present
			// if present then exception is thrown - java.nio.file.FileAlreadyExistsException:
			Files.createDirectory(Path.of("./chapter20/createdDirectory1"));
		} catch (IOException e) {
//				e.printStackTrace();
		}

		try {
			// createdDirectory2 and createdDirectory3 are created
			// No exception if directories are present
			Files.createDirectories(Path.of("./chapter20/createdDirectory2/createdDirectory3"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void example4() {

		try {
			// destination file already exist: java.nio.file.FileAlreadyExistsException: .\chapter20\copyFile4
			Files.copy(Path.of(".\\chapter20\\copyFile3"), Path.of(".\\chapter20\\copyFile4"));

			// destination file already exist: No Exception
			Files.copy(Path.of(".\\chapter20\\copyFile3"), Path.of(".\\chapter20\\copyFile4"),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void example5() {
		// ONLY SHALLOW COPY IS DONE- NO SUBDIRECTORES OR FILES ARE COPIED
		try {
			// destination folder already exist: java.nio.file.FileAlreadyExistsException:
			// .\chapter20\copyFolder3
			Files.copy(Path.of(".\\chapter20\\copyFolder1"), Path.of(".\\chapter20\\copyFolder3"));

			// destination file already exist: No Exception
			Files.copy(Path.of(".\\chapter20\\copyFolder1"), Path.of(".\\chapter20\\copyFolder3"),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void example6() {

		try (var v = new FileInputStream(".\\chapter20\\copyFile3")) {
			Files.copy(v, Path.of(".\\chapter20\\copyFile4"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void example7() {

		try {
			// File move
			// java.nio.file.FileAlreadyExistsException: .\chapter20\moveFolder2\abc
			Files.move(Path.of("./chapter20/moveFolder1/abc"), Path.of("./chapter20/moveFolder2/abc"));

			Files.move(Path.of("./chapter20/moveFolder1/abc"), Path.of("./chapter20/moveFolder2/abc"),
					StandardCopyOption.REPLACE_EXISTING);
			// Directory move
			// while moving folder, it copies all its content to new directory
			Files.move(Path.of("./chapter20/moveFolder1/moveFolder11"),
					Path.of("./chapter20/moveFolder2/moveFolder22"));

			Files.move(Path.of("./chapter20/moveFolder1/moveFolder11"), Path.of("./chapter20/moveFolder2/moveFolder22"),
					StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException e) {
			e.printStackTrace();
		}
		;

	}

	public static void example8() {
			try {
				//throws java.nio.file.NoSuchFileException: chapter20\abc21
//				Files.delete(Path.of("chapter20\\abc2"));

				//true or false 
				System.out.println(Files.deleteIfExists(Path.of("chapter20\\abc3")));//if exists true else false
			} catch (IOException e) {
				e.printStackTrace();
			}
	}	

}
