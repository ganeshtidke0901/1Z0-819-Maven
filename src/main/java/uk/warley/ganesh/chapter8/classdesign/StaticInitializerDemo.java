package uk.warley.ganesh.chapter8.classdesign;

import uk.warley.ganesh.pkg1.ClassB;

public class StaticInitializerDemo {
	{
		i = 20;// step5
//		System.out.println("Instance Initializer:i="+i);//does not allow to be used before declaration
		System.out.println("Instance Initializer");
	}
	int i = 10;// step6

	public static void main(String[] args) {
		StaticInitializerDemo demo = new StaticInitializerDemo();
		System.out.println(demo.i);// 10
		System.out.println(j);// 20
		System.out.println(k);// 2

		
//		Static Initializer
//		Instance Initializer
//		10
//		20
//		2
		
		
		ClassD classD = null;// class is not loaded until any method or variable is used or object is created
		classD.m1();// now static initializer is called

		ClassB b;// does not intialize the static block 
	}

	static {
		j = 30;// step1
//		System.out.println("Static Initializer:i="+j);//does not allow to be used before declaration
		System.out.println("Static Initializer");

	}
	static int j = 20;// step2

	static int k = 1;  //step3
	static {
		k = 2;//step4
	}

}

class ClassD {
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