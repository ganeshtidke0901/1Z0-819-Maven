package uk.warley.ganesh.chapter20.nio2;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathMethodsExampe2 {

    public static void main(String[] args) {
//		example1();
//		example2();
//		example3();
//		example4();
//		example5();		
//		example6();
        example7();
    }

    public static void example1() {

        Path path1 = Path.of("aaa");
        Path path2 = Path.of("bbb");
        Path path3 = path1.resolve(path2);
        System.out.println(path3);// aaa\bbb

        Path path4 = Path.of("aaa1\\aaa2\\.\\..");
        Path path5 = Path.of("bbb");
        Path path6 = path4.resolve(path5);
        System.out.println("" + path6);// aaa1\aaa2\.\..\bbb

        System.out.println("" + path4.normalize());// aaa1

    }

    private static void example2() {
        Path path1 = Path.of("C:\\Ganesh");
        Path path2 = Path.of("folder");
        Path path3 = path1.resolve(path2);
        System.out.println(path3);// C:\Ganesh\folder

        Path path4 = Path.of("C:\\Ganesh\\abc");
        Path path5 = Path.of("C:\\Ganesh\\xyz");
        Path path6 = path4.resolve(path5);
        System.out.println("" + path6);// C:\Ganesh\xyz

        Path path7 = Path.of("\\Ganesh\\abc");
        Path path8 = Path.of("\\Ganesh\\xyz");
        Path path9 = path7.resolve(path8);
        System.out.println("" + path9);// \Ganesh\xyz

    }

    private static void example3() {

        Path path1 = Paths.get("/land/property/notgood");
        for (int i = 0; i < path1.getNameCount(); i++) {
            System.out.println("" + path1.getName(i));
        }
//		land
//		property
//		notgood

        System.out.println(path1.getNameCount());// 3
        System.out.println(path1.getName(2));// notgood
//		System.out.println(path1.getName(3));//java.lang.IllegalArgumentException

        System.out.println("" + path1.subpath(0, 3));// land\property\notgood
        System.out.println("" + path1.subpath(0, 2));// land\property (second index is exclusive of the element)
//		System.out.println("" + path1.subpath(0, 4));//java.lang.IllegalArgumentException

        System.out.println("" + path1.getFileName());// notgood (always last folder or file name irrespective of
        // extension)
        System.out.println("" + Path.of("/home/ganesh/textfile.txt").getFileName());// textfile.txt

        System.out.println("" + path1.getParent());// \land\property
        System.out.println("" + Path.of("/home/ganesh/../textfile.txt").getParent());// \home\ganesh\.. (even it is / ,
        // method will covert it to \)
        System.out.println("" + Path.of("textfile.txt").getParent());// null
        System.out.println("" + Path.of("./textfile.txt").getParent());// .

    }

    private static void example4() {
        Path path1 = Paths.get("/land/property/notgood");
        System.out.println("" + path1.getRoot());// \
        System.out.println("" + Path.of("ganesh/../textfile.txt").getRoot());// null
        System.out.println("" + Path.of("C:\\Ganensh").getRoot());// C:\
        System.out.println("" + Path.of("C:/Ganensh").getRoot());// C:\

        System.out.println(path1.toAbsolutePath());// C:\land\property\notgood (here it was already an absolute path so
        // it just added C: as the program running on windows)
        System.out.println(Path.of("ganesh/../textfile.txt").toAbsolutePath());// C:\Users\ganes\OneDrive\Desktop\1Z0-819\ganesh\..\textfile.txt
        System.out.println(path1.getName(1).toAbsolutePath());// C:\Users\ganes\OneDrive\Desktop\1Z0-819\property

    }

    private static void example5() {

        Path path1 = Paths.get("aaa/bbb");
        Path path2 = Paths.get("ccc/ddd");
        System.out.println(path1.relativize(path2));// ..\..\ccc\ddd
        System.out.println(path2.relativize(path1));// ..\..\aaa\bbb

        Path path3 = Paths.get("/aaa/bbb");
        Path path4 = Paths.get("/ccc/ddd");
        System.out.println(path3.relativize(path4));// ..\..\ccc\ddd
        System.out.println(path4.relativize(path3));// ..\..\aaa\bbb

        Path path5 = Paths.get("C:\\aaa\\bbb");
        Path path6 = Paths.get("D:\\ccc/ddd");
//		System.out.println(path5.relativize(path6));// java.lang.IllegalArgumentException: 'other' has different root
        System.out.println(path6.relativize(path5));// java.lang.IllegalArgumentException: 'other' has different root

    }

    private static void example6() {

        System.out.println(Paths.get("aaa/bbb/../").normalize());// aaa
        System.out.println(Paths.get("/aaa/bbb/../.").normalize());// \aaa
        System.out.println(Paths.get("/aaa/bbb/../..").normalize());// \
        System.out.println(Paths.get("C:/aaa/bbb/../..").normalize());// C:\
        System.out.println(Paths.get("ganesh/../../..").normalize());// ..\..
        System.out.println(Paths.get("ganesh/..").normalize());// empty string

    }

    private static void example7() {

        try {
            System.out.println(Paths.get("aaa/bbb/../").toRealPath());//java.nio.file.NoSuchFileException: aaa\bbb\..
        } catch (IOException e) {
        }


        try {
            System.out.println(Paths.get("C:\\Ganesh\\folder").toRealPath());// C:\Ganesh\folder
        } catch (IOException e) {
        }

        //not sure of this
        try {
            System.out.println("--" + Paths.get("C:\\Users\\ganes\\OneDrive\\Desktop\\1Z0-819\\chapter20\\Ganesh\\folder21.lnk").toRealPath());// C:\Users\ganes\OneDrive\Desktop\1Z0-819\chapter20\Ganesh\folder21.lnk
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            System.out.println(Paths.get(".").toRealPath());// C:\Users\ganes\OneDrive\Desktop\1Z0-819
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(Paths.get("C:\\Ganesh\\folder\\..\\.").toRealPath());// C:\Ganesh
        } catch (IOException e) {
        }
    }

}
