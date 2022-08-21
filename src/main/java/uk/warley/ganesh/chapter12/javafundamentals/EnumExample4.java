package uk.warley.ganesh.chapter12.javafundamentals;

enum EnumDemo1 {
	WINTER, SUMMER, SPRINT, FALL
}

enum EnumDemo2 {
	WINTER("Hello"), SUMMER(""), SPRINT(""), FALL("");

	EnumDemo2(String string) {// implicitly it is private
		this.str = string;
	}

//	protected EnumDemo2() {// implicitly it is private so default, protected or public wont work
//		this.str = "Nothing";
//	}

	String str;// can be final- good to make it final
}

enum EnumDemo3 {
//	WINTER, SUMMER, SPRINT, FALL //need semicolon here as lines are added after this
//	String str;// can be final- good to make it final

}

enum EnumDemo4 {
	WINTER, SUMMER, SPRINT, FALL;

	public  String str;//good to make it final and private 

	public void print() {
		for (final var var : EnumDemo4.values()) {
			System.out.println(var);// var is type not keyword
		}
	}

}

enum EnumDemo5 {
	WINTER("Hello"), SUMMER(""), SPRINT(""), FALL("");

	EnumDemo5(String string) {// implicitly it is private
		this.str = string;
	}

	private final String str;

	public void print() {
		for (final var var : EnumDemo4.values()) {
			System.out.println(var);// var is type not keyword
		}
	}

}

enum EnumDemo6 {
	WINTER(), SUMMER, SPRINT, FALL()
}

enum EnumDemo7 {
	WINTER("Hello"), SUMMER, SPRINT, FALL();// if arg constructor is added then no-arg is not added implicitly

	private EnumDemo7() {// if commented out then , error at 61
	}

	private EnumDemo7(String str) {
	}
	
	
}

public class EnumExample4 {
	public static void main(String[] args) {
		System.out.println(EnumDemo2.FALL);// FALL
		System.out.println(EnumDemo2.FALL.ordinal());// 3
		System.out.println(EnumDemo2.WINTER.str);// Hello
//		System.out.println(EnumDemo2.valueOf("Hello"));//java.lang.IllegalArgumentException

		var var = EnumDemo2.SUMMER;
		EnumDemo2 season = EnumDemo2.SUMMER;
		switch (season) {// or var
		case SUMMER:

			break;
//		case EnumDemo2.WINTER://does not work with enumtype name

		default:
			break;
		}

	}
}