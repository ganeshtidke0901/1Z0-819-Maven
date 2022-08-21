package uk.warley.ganesh.chapter9.advanceclassdesign;

interface Dance1 {
	void test();

}

interface Dance2 {

	int test();
}

//overridding rule is applied but here return type is not co-varient
//class Class8 implements Dance1, Dance2 {
//
//}

interface Dance3 {

	CharSequence test();
}

interface Dance4 {

	String test();
}

class Class9 implements Dance4, Dance3 {


	@Override
	public String test() {
		return null;
	}
}

public class DuplicateInterfaceMethods7 {

}
