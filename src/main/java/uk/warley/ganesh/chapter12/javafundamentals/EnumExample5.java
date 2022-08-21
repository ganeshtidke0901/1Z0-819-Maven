package uk.warley.ganesh.chapter12.javafundamentals;

//protected enum OnlyOne{} //cant be protected or private as same of class or interface

enum OnlyOne {
	ONCE(true);

	private OnlyOne(boolean b) {
		this.val = b;
		System.out.println("Constructing...");
	}

	private final boolean val;
	static void test() {
		System.out.println("static test");
	}
}

public class EnumExample5 {
	public static void main(String[] args) {
		OnlyOne one1;// if we define this alone and run , OnlyOne wont be loaded and intiliaze the enum values(ONCE)
		OnlyOne one2=null;// if we define this alone and run , OnlyOne wont be loaded and intiliaze the enum values(ONCE)
		OnlyOne.test();// here it will start as enum Onlyone is loaded
//		OnlyOne one2 = OnlyOne.ONCE;// here it will start initializing the Enum values by calling constructer
		
		

	}
}