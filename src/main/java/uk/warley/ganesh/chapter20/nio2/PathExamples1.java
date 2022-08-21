package uk.warley.ganesh.chapter20.nio2;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExamples1 {

	public static void main(String[] args) {
//		example1();
		example2();

	}

	public static void example1() {
		Path path1 = Path.of("ganesh\\xyz");// relative
		Path path2 = Path.of("/usrs/ganesh");// absolute path
		Path path3 = Path.of("/home/zoomdirectory/.././info");// absolute
		Path path4 = Path.of("./ganesh/xyz");// relative

	}

	private static void example2() {
		URI uri = null;
		URI uri1 = null;

		try {
			uri = new URI("file://icecrea.txt");
			uri1 = new URI("https://www.google.com/index.html");
		} catch (URISyntaxException e) {
		}

		Path path1 = Path.of(uri);
		Path path2 = Path.of(uri1);

	}

	private static void example3() {

		Path path1 = FileSystems.getDefault().getPath("C:/gnesh");
		Path path2 = FileSystems.getDefault().getPath("ganesh/etc");

	}

	private static void example4() {

		File file = new File("C:/ganesh");

		Path path1 = file.toPath();

		File file2 = path1.toFile();
	}

	private static void example5() {
		Path path1 = Paths.get("c:/ganesh");
	}

}
