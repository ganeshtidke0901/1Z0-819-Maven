package uk.warley.ganesh.chapter19.iostreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationExampl8 {

	static void example1() {

//		try (var objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(
//				System.getProperty("user.dir") + "/resources/chapter19/folder1/objectdataXYZ")))) {// FileNotFoundException
//																									// is
//																									// thrown
//																									// by
//																									// FileOutputStream
//																									// incase
//																									// parent
//																									// folder
//																									// is
//																									// not
//																									// present
//																									// e.g
//																									// folder1
//			XYZ xyz= new XYZ();
//			objectOutputStream.writeObject(xyz);// if xyz is not serialzable then it throws
//												// java.io.NotSerializableException:
//			objectOutputStream.flush();
//		} catch (FileNotFoundException e) {// thrown by FileoutputStream
//			e.printStackTrace();
//		} catch (IOException e) {// thrown by ObjectOutputStream
//			e.printStackTrace();
//		}
//		CCC static block
//		XYZ This is static block
//		CCC instance block
//		CCC  consructor
//		XYZ constructor

		try (var objectInputStream = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream(System.getProperty("user.dir") + "/resources/chapter19/folder1/objectdataXYZ")))) {

			XYZ xyz = (XYZ) objectInputStream.readObject();// java.io.InvalidClassException
			System.out.println(xyz.a);// 10
			System.out.println(xyz.b);// 11
			System.out.println(xyz.c);// 12
			System.out.println(xyz.str);// Mr Tidke
			System.out.println(xyz.getVersion());// 1

		} catch (FileNotFoundException e) {// thrown by FileInputStream
			e.printStackTrace();
		} catch (IOException e) {// thrown by ObjectInputStream
			e.printStackTrace();
		} catch (ClassNotFoundException e) {// readObject
			e.printStackTrace();
		}

//		CCC static block
//		XYZ This is static block
//		java.io.InvalidClassException: uk.warley.ganesh.chapter19.iostreams.XYZ; no valid constructor
//			at java.base/java.io.ObjectStreamClass$ExceptionInfo.newInvalidClassException(ObjectStreamClass.java:159)
//			at java.base/java.io.ObjectStreamClass.checkDeserialize(ObjectStreamClass.java:875)
//			at java.base/java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:2170)
//			at java.base/java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1679)
//			at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:493)
//			at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:451)
//			at uk.warley.ganesh/uk.warley.ganesh.chapter19.iostreams.SerializationExampl8.example1(SerializationExampl8.java:50)
//			at uk.warley.ganesh/uk.warley.ganesh.chapter19.iostreams.SerializationExampl8.main(SerializationExampl8.java:68)
	}

	public static void main(String[] args) {
		example1();
//		example2();
//		example3();
//		example4();
	}
}

class CCC {
	public int a = 10;
	int b = 11;
	transient int c = 12;
	static String str = "Mr Tidke";
	static {
		System.out.println("CCC static block");
	}

	{
		System.out.println("CCC instance block");
	}

	CCC(int a) {// should have no-arg constructor to be called by deserialization process
		System.out.println("CCC  consructor");
	}
}

class XYZ extends CCC implements Serializable {
	private static final long serialVersionID = 1L;

	static {
		System.out.println("XYZ This is static block");
	}

	public XYZ() {
		super(1);
		System.out.println("XYZ constructor");
	}

	public static long getVersion() {
		return serialVersionID;
	}

}
