package uk.warley.ganesh.chapter19.iostreams;

import java.io.File;
import java.io.IOException;

public class FileExample1 {
	public static void main(String[] args) {
		System.out.println(File.separator);// \
		System.out.println(System.getProperty("file.separator"));// \

		File file = new File(System.getProperty("user.dir") + "/resources/chapter19/folder1/file1.txt");
		System.out.println(file.exists());// true

		File file2 = new File(System.getProperty("user.dir"), "/resources/chapter19/folder1/file1.txt");
		System.out.println(file2.exists());// true

		File file3 = new File(new File(System.getProperty("user.dir")), "/resources/chapter19/folder1/file1.txt");
		System.out.println(file3.exists());// true

		File file4 = new File(new File(System.getProperty("user.dir")), "/resources/chapter19/folder1/file2.txt");
		System.out.println(file4.exists());// false
		System.out.println(file4.delete());// false
		System.out.println(file4.getAbsolutePath());// C:\Users\ganes\OneDrive\Desktop\1Z0-819\resources\chapter19\folder1\file2.txt
		System.out.println(file4.getName());//file2.txt
		System.out.println(file4.getParent());//C:\Users\ganes\OneDrive\Desktop\1Z0-819\resources\chapter19\folder1
		System.out.println(file4.getPath());//C:\Users\ganes\OneDrive\Desktop\1Z0-819\resources\chapter19\folder1\file2.txt

		System.out.println(file4.isDirectory());//false
		System.out.println(file4.isFile());//false
		System.out.println(file4.length());//0
		
		System.out.println(file4.listFiles());//null
		System.out.println(file3.listFiles());//null
		System.out.println(file4.renameTo(new File(System.getProperty("user.dir"), "/resources/chapter19/folder1/file4.txt")));//false
		
		System.out.println(file3.lastModified());//1632950868941 from UTC 1 Jan 1970
		try {
			System.out.println(file3.getCanonicalPath());//C:\Users\ganes\OneDrive\Desktop\1Z0-819\resources\chapter19\folder1\file1.txt

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}
}
