package uk.warley.ganesh.chapter19.iostreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationExampl9 {

	static void example1() {

		try (var objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(
				new FileOutputStream(System.getProperty("user.dir") + "/resources/chapter19/folder1/objectdataDDD")))) {// FileNotFoundException
																														// is
																														// thrown
																														// by
																														// FileOutputStream
																														// incase
																														// parent
																														// folder
																														// is
																														// not
																														// present
																														// e.g
			DDD abc=new DDD();
			DDD abc1=new DDD();
			DDD abc2=new DDD();
			objectOutputStream.writeObject(abc);// if abc is not serialzable then it throws
												// java.io.NotSerializableException:
			objectOutputStream.writeObject(abc1);// if abc is not serialzable then it throws
			objectOutputStream.writeObject(abc2);// if abc is not serialzable then it throws
			
			objectOutputStream.flush();
		} catch (FileNotFoundException e) {// thrown by FileoutputStream
			e.printStackTrace();
		} catch (IOException e) {// thrown by ObjectOutputStream
			e.printStackTrace();
		}
//		
//		This is static block
//		This is constructor


		try (var objectInputStream = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream(System.getProperty("user.dir") + "/resources/chapter19/folder1/objectdataDDD")))) {

			while(true)
			{
				DDD abc = (DDD) objectInputStream.readObject();
				System.out.println(abc.a);// 10
				System.out.println(abc.b);// 11
				System.out.println(abc.c);// 0
				System.out.println(abc.str);// Mr Tidke
				System.out.println(abc.getVersion());// 1
				System.out.println("-----------------");
			}
			

		} catch (FileNotFoundException e) {// thrown by FileInputStream
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("EOD file");
		} catch (IOException e) {// thrown by ObjectInputStream
			e.printStackTrace();
		} 
		
//		This is static block
//		This is constructor
//		This is constructor
//		This is constructor
//		10
//		11
//		0
//		Mr Tidke
//		1
//		10
//		11
//		0
//		Mr Tidke
//		1
//		10
//		11
//		0
//		Mr Tidke
//		1
//		EOD file
	}

		

	static void example2() {

		
		//we can do this but does not work properly when readding or writing it
		try (var objectOutputStream = new ObjectOutputStream(System.out)) {// FileNotFoundException
																														// is
																														// thrown
																														// by
																														// FileOutputStream
																														// incase
																														// parent
																														// folder
																														// is
																														// not
																														// present
																														// e.g
			DDD abc=new DDD();
			DDD abc1=new DDD();
			DDD abc2=new DDD();
			objectOutputStream.writeObject(abc);// if abc is not serialzable then it throws
												// java.io.NotSerializableException:
			objectOutputStream.writeObject(abc1);// if abc is not serialzable then it throws
			objectOutputStream.writeObject(abc2);// if abc is not serialzable then it throws
			
			objectOutputStream.flush();
		} catch (FileNotFoundException e) {// thrown by FileoutputStream
			e.printStackTrace();
		} catch (IOException e) {// thrown by ObjectOutputStream
			e.printStackTrace();
		}
//		

//
		try (var objectInputStream = new ObjectInputStream(System.in)) {

			while(true)
			{
				DDD abc = (DDD) objectInputStream.readObject();
				System.out.println(abc.a);// 10
				System.out.println(abc.b);// 11
				System.out.println(abc.c);// 0
				System.out.println(abc.str);// Mr Tidke
				System.out.println(abc.getVersion());// 1
				System.out.println("-----------------");
			}
			

		} catch (FileNotFoundException e) {// thrown by FileInputStream
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("EOD file");
		} catch (IOException e) {// thrown by ObjectInputStream
			e.printStackTrace();
		} 
		
	}

		



	public static void main(String[] args) {
//		example1();
		example2();
//		example3();
//		example4();
	}
}

class DDD implements Serializable {
	private static final long serialVersionID = 1L;
	int a = 10;
	int b = 11;
	transient int c = 12;
	static String str = "Mr Tidke";
	static {
		System.out.println("This is static block");
	}

	public static long getVersion() {
		return serialVersionID;
	}

	public DDD() {
		System.out.println("This is constructor");
	}

}

