package uk.warley.ganesh.chapter7.methodsandencapsulation;

import uk.warley.ganesh.pkg1.ClassB;

public class StaticInitializerDemo10 {

	{
//		i = 20;//wont allow as it is final and it is already intialized
	}
	final int i = 10;

	static {
		j = 30;// allow in static intilizer
	}
	final static int j;

	final int k;
//	final static int l;//will have compilation error 

	
	//will ask to intilize k 
//	public StaticInitializerDemo10(int a) {
//	}
	public StaticInitializerDemo10() {
		k = 1;// allow in constructor
	}

	public static void m1() {
	//j=10; //wont allow as it has to be initialized in static block or while being declared 
	}

	public static void main(String[] args) {

	}
}
