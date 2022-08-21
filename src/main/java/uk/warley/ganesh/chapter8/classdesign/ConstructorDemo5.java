package uk.warley.ganesh.chapter8.classdesign;

public class ConstructorDemo5 {
	String s;

	private ConstructorDemo5() {// private con is written , default con is not provided
		this("Ganesh");
	}

	public ConstructorDemo5(String s) {
		this.s = s;// super() is added before this statement
//		this(1);//cant be second statement
	}

	public ConstructorDemo5(int s) {
		System.out.println();
//		super(); //should be first statement
	}

	public static void main(String[] args) {
		ConstructorDemo5 constructorDemo5 = new ConstructorDemo5();
	}
}
