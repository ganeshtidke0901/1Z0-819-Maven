package uk.warley.ganesh.chapter12.javafundamentals;

import java.util.ArrayList;
import java.util.List;

//@FunctionalInterface//optional
interface Walk {
	default int getSpeed() {// implicityly public
		return 5;
	}

//	 default int xyz() {//implicityly public
//		return 5;
//	}

	default List<String> abc() {// implicityly public
		return null;
	}
}

interface Run {
	default int getSpeed() {// implicityly public
		return 3;
	}
//	default void xyz() {//implicityly public
//		
//	}

	default ArrayList<String> abc() {// implicityly public
		return null;
	}
}

//must override getSpeed as it is there in both interfaces
public class InterfaceDefaultMethodExample11 implements Run, Walk {

	// if parent interfaces both having same signature with covarient return type or not , child should
	// override it
	@Override
	public int getSpeed() {
		Run.super.getSpeed();
		Walk.super.getSpeed();
		return 10;
	}

	void test() {
		System.out.println(Walk.super.getSpeed());// 5
		System.out.println(Run.super.getSpeed());// 3
		System.out.println(this.getSpeed());// 10

	}

//	@Override
//	public void xyz() {  cant override as both interface method does not match the return time(not even covarient)
//	}

	// if parent interfaces both having same signature with covariant return type or not , chidl should
	// override it
	@Override
	public ArrayList<String> abc() { // covarient return ty
		return Run.super.abc();
	}

	public static void main(String[] args) {
		new InterfaceDefaultMethodExample11().test();
	}
}
