package uk.warley.ganesh.chapter8.classdesign;

public class ConstructorDemo4 {
	private ConstructorDemo4() {// private con is written , default con is not prrovided
	}

	public static void main(String[] args) {
		ConstructorDemo4 constructorDemo4 = new ConstructorDemo4();
	}
}

class AA {

	public static void main(String[] args) {
		ConstructorDemo4 constructorDemo4 = null;
//		constructorDemo4=new ConstructorDemo4();// constructor is private
		System.out.println("Hello AA");
	}
}