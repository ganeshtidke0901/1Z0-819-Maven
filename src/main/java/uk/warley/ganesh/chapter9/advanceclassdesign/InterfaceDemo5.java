package uk.warley.ganesh.chapter9.advanceclassdesign;

import java.util.ArrayList;
import java.util.List;

interface Runner {// public(not sure) abstract interface Runner
	void test();// public abstract void test();

	int i = 1;// public static final int i=1;
	List<String> test2();
}

//interface cant be final
//final interface Runner1{}

interface Runner2 extends Runner
{
	void test();
	ArrayList<String> test2();
}


public class InterfaceDemo5 implements Runner, Runner2 {
	
	//here test() has to be public as all abstract method in interface are public implicitly 
	@Override
	public void test() {
	}

	public static void main(String[] args) {

	}

	@Override
	public ArrayList<String> test2() {
		return null;
	}

}
