package uk.warley.ganesh.chapter12.javafundamentals;

//@FunctionalInterface//optional
interface Walk1 {
	static  int getSpeed() {//implicityly public
		return 5;
	}

}

interface Run1 {
	static int getSpeed() {//implicityly public
		return 3;
	}
}

//static methods in interfaces are never inherited unlike in class it gets hidden
public class InterfaceStaticMethodExample12 implements Run1,Walk1{

	public int getSpeed() {// this neither overriding  or hiding - (cant access getSpeed() of Walk1 or Run1 at all as it is not inherited)
		return 10;
	}//you can try adding static
	
	
	void test() {
		System.out.println(Walk1.getSpeed());//5
		System.out.println(Run1.getSpeed());//3
		System.out.println(this.getSpeed());//10
		
	}
	
	public static void main(String[] args) {
		new InterfaceStaticMethodExample12().test();
	}
}
