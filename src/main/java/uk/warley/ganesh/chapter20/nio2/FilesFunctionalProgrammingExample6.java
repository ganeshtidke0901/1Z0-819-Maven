package uk.warley.ganesh.chapter20.nio2;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class FilesFunctionalProgrammingExample6 {
	public static void main(String[] args) {
//		example1();
//		example2();
//		example3();
//		example4();
		example5();
//		example6();
//		example7();
	}

	public static void example1() {

		try {
			// java.nio.file.NoSuchFileException: .\chapter201 if not exist
			// java.nio.file.NotDirectoryException: .\chapter20\xyz.txt if not directory
			Stream<Path> s = Files.list(Path.of("./chapter20"));
			s.forEach(p -> System.out.println(p));

//			.\chapter20\abc
//			.\chapter20\copyFile3
//			.\chapter20\copyFile4
//			.\chapter20\copyFolder1
//			.\chapter20\copyFolder3
//			.\chapter20\createdDirectory1
//			.\chapter20\createdDirectory2
//			.\chapter20\folder1
//			.\chapter20\Ganesh
//			.\chapter20\moveFolder1
//			.\chapter20\moveFolder2
//			.\chapter20\xyz.txt

			// if Path.of("chapter20")
//			chapter20\abc
//			chapter20\copyFile3
//			chapter20\copyFile4
//			chapter20\copyFolder1
//			chapter20\copyFolder3
//			chapter20\createdDirectory1
//			chapter20\createdDirectory2
//			chapter20\folder1
//			chapter20\Ganesh
//			chapter20\moveFolder1
//			chapter20\moveFolder2
//			chapter20\xyz.txt

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copyToTempFolder(Path source, Path target) {

		try {
			Files.copy(source, target);// //if folder is created and has some content then evenif we use
										// StandardCopyOption.REPLACE_EXISTING, there would be exception
										// java.nio.file.DirectoryNotEmptyException: temp\Ganesh\folder2\folder21
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (Files.isDirectory(source)) {
			try (Stream<Path> v = Files.list(source)) {// has to be inside try with resources to avoid resource leakage
				v.forEach(s -> copyToTempFolder(s, target.resolve(s.getFileName())));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public static void example2() {
		copyToTempFolder(Path.of("chapter20"), Path.of("temp"));
	}

	public static void example3() {
		try (Stream<Path> stream = Files.walk(Path.of("chapter20"), 0, FileVisitOption.FOLLOW_LINKS)) {
			stream.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
//		chapter20

		System.out.println("-----------------------------------------");

		try (Stream<Path> stream = Files.walk(Path.of("chapter20"), 1, FileVisitOption.FOLLOW_LINKS)) {
			stream.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}

//		chapter20
//		chapter20\abc
//		chapter20\copyFile3
//		chapter20\copyFile4
//		chapter20\copyFolder1
//		chapter20\copyFolder3
//		chapter20\createdDirectory1
//		chapter20\createdDirectory2
//		chapter20\folder1
//		chapter20\Ganesh
//		chapter20\moveFolder1
//		chapter20\moveFolder2
//		chapter20\xyz.txt

		System.out.println("-----------------------------------------");

		try (Stream<Path> stream = Files.walk(Path.of("chapter20"), 1, FileVisitOption.FOLLOW_LINKS)) { // if circlular
																										// path happens
																										// because of
																										// symbolic link
																										// then it
																										// throws
																										// FileSystemLoopException
			stream.parallel().forEach(p -> {
				try {
					System.out.println(p + "--" + Files.size(p));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

//		-----------------------------------------
//		chapter20--4096
//		chapter20\abc--3
//		chapter20\copyFile3--14
//		chapter20\copyFile4--9
//		chapter20\copyFolder1--0
//		chapter20\copyFolder3--0
//		chapter20\createdDirectory1--0
//		chapter20\createdDirectory2--0
//		chapter20\folder1--0
//		chapter20\Ganesh--4096
//		chapter20\moveFolder1--0
//		chapter20\moveFolder2--0
//		chapter20\xyz.txt--21
	}

	public static void example4() {

		try (Stream<Path> stream = Files.find(Path.of("chapter20"), 1, (p,a)->p.toString().endsWith(".txt")&& a.isRegularFile())) {
			stream.parallel().forEach(s->System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//chapter20\xyz.txt
		System.out.println("--------------------------------------");
		try (Stream<Path> stream = Files.find(Path.of("chapter20"), 1, (p,a)-> a.isDirectory())) {
			stream.parallel().forEach(s->System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
//		chapter20
//		chapter20\copyFolder1
//		chapter20\copyFolder3
//		chapter20\createdDirectory1
//		chapter20\createdDirectory2
//		chapter20\folder1
//		chapter20\Ganesh
//		chapter20\moveFolder1
//		chapter20\moveFolder2
		
		
	}

	public static void example5() {

		try(Stream<String> lines=Files.lines(Path.of("chapter20/xyz.txt"))) {
			lines.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		xyz
//		20-02-22 05:10qq

	}

	public static void example6() {

	}

	public static void example7() {
	}

}
