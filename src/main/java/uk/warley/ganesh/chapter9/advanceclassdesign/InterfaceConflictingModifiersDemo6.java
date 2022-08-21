package uk.warley.ganesh.chapter9.advanceclassdesign;

interface Dance {

	// can't be private or protected or package private, always should be public
//	private int a=10;
	void test();

}

abstract class AC4 implements Dance {
//	public void test() {} //we can have this
}

class Class7 extends AC4 {
	@Override
	public void test() {
	}
}

public class InterfaceConflictingModifiersDemo6 {

}
