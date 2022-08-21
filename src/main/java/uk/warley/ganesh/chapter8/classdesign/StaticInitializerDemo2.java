package uk.warley.ganesh.chapter8.classdesign;

import uk.warley.ganesh.pkg1.ClassB;

public class StaticInitializerDemo2 {

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
//	public StaticInitializerDemo2(int a) {
//	}
	public StaticInitializerDemo2() {
		k = 1;// allow in constructor
	}

	public static void m1() {
//	l=10; //wont allow
	}

	public static void main(String[] args) {

	}
}
