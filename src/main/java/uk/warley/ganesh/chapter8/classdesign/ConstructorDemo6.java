package uk.warley.ganesh.chapter8.classdesign;

public class ConstructorDemo6 extends AB {
	String s;

	private ConstructorDemo6() {// private con is written , default con is not provided
		this("Ganesh");// super() is not added before this statement
	}

	public ConstructorDemo6(String s) {
		this(1);
		this.s = s;// super() is added before this statement by compiler
//		this(1);//cant be second statement
	}

	public ConstructorDemo6(int s) {
		System.out.println();// super() is added before this statement by compiler
//		super(); //should be first statement
	}

	public ConstructorDemo6(short s) {
		super();// super() is added explicitly
//		super(); //can't add second time
	}

	public ConstructorDemo6(byte s) {
		this();
//				super(); //can't add as this() is added
	}

	public static void main(String[] args) {
		ConstructorDemo6 constructorDemo6 = new ConstructorDemo6();
	}

}

class AB {

//	AB(int a) //if added , child class needs to call this con explicitly 
//	{
//		
//	}
}