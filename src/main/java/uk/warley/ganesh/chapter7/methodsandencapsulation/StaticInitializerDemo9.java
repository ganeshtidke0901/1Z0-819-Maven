package uk.warley.ganesh.chapter7.methodsandencapsulation;

import uk.warley.ganesh.pkg1.ClassB;

public class StaticInitializerDemo9 {
	{
		i = 20;// step3
//		System.out.println("Instance Initializer:i="+i);//does not allow to be used before declaration
		System.out.println("Instance Initializer");
	}
	int i = 10;// step4

	public static void main(String[] args) {
		StaticInitializerDemo9 demo = new StaticInitializerDemo9();
		//Static Initializer
		//Instance Initializer
		
		System.out.println(demo.i);// 10
		System.out.println(j);// 20

		ClassD00 classD = null;// class is not loaded until any method or variable is used or object is created
		classD.m1();// now static initialiser is called
		
		ClassB b;//does not intialize the static block
	}

	static {
		j = 30;// step1
//		System.out.println("Static Initializer:i="+j);//does not allow to be used before declaration
		System.out.println("Static Initializer");
	}
	static int j = 20;// step2

}

class ClassD00 {
	{
		i = 20;// step3
		System.out.println("Instance Initializer-ClassD");

	}
	int i = 10;// step4
	static {
		j = 30;// step1
		System.out.println("Static Initializer-ClassD");

	}
	static int j = 20;// step2

	static void m1() {
	}
}