package uk.warley.ganesh.chapter20.nio2;

import java.io.FileInputStream;
import java.io.IOException;
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

public class FilesAttributesExample5 {
	public static void main(String[] args) {
//		example1();
//		example2();
//		example3();
		example4();
//		example5();
//		example6();
//		example7();
	}

	public static void example1() {
		System.out.println(Files.isDirectory(Path.of("./chapter20/moveFolder2/abc")));//false as abc is file
		System.out.println(Files.isDirectory(Path.of("./chapter20/moveFolder2")));//true
		System.out.println(Files.isDirectory(Path.of("./chapter20/moveFolder2/11")));//false as 11 directory does not exist
		
		//NEED TO CHECK THIS - NOT WORKNG IN WINDOWS
		System.out.println(Files.isSymbolicLink(Path.of("./chapter20/Ganesh/folder21.lnk")));//false 

		System.out.println(Files.isRegularFile(Path.of("./chapter20/copyFile3")));//true 
		System.out.println(Files.isRegularFile(Path.of("./chapter20/copyFile3//file1.txt")));//false as file does not exist
		
		
		try {
			System.out.println(Files.isHidden(Path.of("./chapter20/copyFile3")));//false
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(Files.isReadable(Path.of("./chapter20/copyFile3")));//true
		System.out.println(Files.isReadable(Path.of("./chapter20/xyz.txt")));//true
		System.out.println("---------------------------------------------");
		System.out.println(Files.isExecutable(Path.of("./chapter20/xyz.txt")));//true
		System.out.println(Files.isWritable(Path.of("./chapter20/xyz.txt")));//true
		System.out.println(Files.isWritable(Path.of("./chapter20/xyz1.txt")));//false as file does not exist
		
		System.out.println("---------------------------------------------");
		try {
			//throws exception if not found 
			System.out.println(Files.size(Path.of("./chapter20/xyz.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	public static void example2() {

		
		try {
			FileTime fileTime=Files.getLastModifiedTime(Path.of("./chapter20/xyz.txt"));
			System.out.println(fileTime.toMillis());
//			System.out.println(LocalDateTime.ofEpochSecond(fileTime.toMillis(), 0, ZoneOffset.UTC));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void example3() {
		
		try {
			//java.nio.file.NoSuchFileException: .\chapter20\xyz1.txt if not exist
			BasicFileAttributes attributes=Files.readAttributes(Path.of("./chapter20/xyz.txt"), BasicFileAttributes.class);
			System.out.println(attributes.isDirectory());//false
			System.out.println(attributes.isRegularFile());//true
			System.out.println(attributes.isSymbolicLink());//false
			System.out.println(attributes.size());//21
			System.out.println(attributes.lastModifiedTime());//2022-02-20T17:12:49.477778Z
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void example4() {
		
		try {
			//java.nio.file.NoSuchFileException: .\chapter20\xyz1.txt if not exist
			BasicFileAttributeView view=Files.getFileAttributeView(Path.of("./chapter20/xyz.txt"), BasicFileAttributeView.class);
			System.out.println(view.readAttributes().isRegularFile());
			view.setTimes(FileTime.fromMillis(1020100000500000000l), null, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void example5() {
		
		
		
	}

	public static void example6() {

	}

	public static void example7() {
	}

}
