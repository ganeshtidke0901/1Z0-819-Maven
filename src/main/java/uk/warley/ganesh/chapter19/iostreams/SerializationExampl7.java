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

public class SerializationExampl7 {

	static void example1() {

//		try (var objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(
//				System.getProperty("user.dir") + "/resources/chapter19/folder1/objectdataABC2")))) {// FileNotFoundException
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
//			ABC2 abc = new ABC2();
//			objectOutputStream.writeObject(abc);// if abc is not serialzable then it throws
//												// java.io.NotSerializableException:
//			objectOutputStream.flush();
//		} catch (FileNotFoundException e) {// thrown by FileoutputStream
//			e.printStackTrace();
//		} catch (IOException e) {// thrown by ObjectOutputStream
//			e.printStackTrace();
//		}
		
		//if run separately
//		NNN static block
//		ABC2 This is static block
//		NNN instance block
//		NNN  consructor
//		ABC2 constructor


		try (var objectInputStream = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream(System.getProperty("user.dir") + "/resources/chapter19/folder1/objectdataABC2")))) {

			ABC2 abc = (ABC2) objectInputStream.readObject();
			System.out.println(abc.a);// 10
			System.out.println(abc.b);// 11
			System.out.println(abc.c);// 12
			System.out.println(abc.str);// Mr Tidke
			System.out.println(abc.getVersion());// 1

		} catch (FileNotFoundException e) {// thrown by FileInputStream
			e.printStackTrace();
		} catch (IOException e) {// thrown by ObjectInputStream
			e.printStackTrace();
		} catch (ClassNotFoundException e) {//readObject
			e.printStackTrace();
		}
		//if run separately if not then static block will be called once once while writing where class is loaded in memory
//		NNN static block
//		ABC2 This is static block
//		NNN instance block
//		NNN consructor
//		10
//		11
//		12
//		Mr Tidke
//		1
		
		
		
		//if NNN is serializable
//		NNN static block
//		ABC2 This is static block
//		10
//		11
//		0
//		Mr Tidke
//		1

	}


	public static void main(String[] args) {
		example1();
//		example2();
//		example3();
//		example4();
	}
}

class NNN  {
	

	public int a = 10;
	int b = 11;
	transient int c = 12;
	static String str = "Mr Tidke";
	static {
		System.out.println("NNN static block");
	}

	{

		System.out.println("NNN instance block");
		
	}

	NNN() {
		System.out.println("NNN  consructor");
//		a=111110;//if we uncomment this while reading from data file then this value  will be assigned
	}
}

class ABC2 extends NNN implements Serializable {
	private static final long serialVersionID = 1L;

	static {
		System.out.println("ABC2 This is static block");
	}

	ABC2()
	{
		System.out.println("ABC2 constructor");
	}
	public static long getVersion() {
		return serialVersionID;
	}


}
