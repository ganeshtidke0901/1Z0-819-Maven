package uk.warley.ganesh.chapter9.advanceclassdesign;

//class can be public or package private
abstract class Class1 {
}
//  compiler error
//class  abstract Class2 {
//
//}



public class AbstractClassDemo1 extends Class1 {
	public static void main(String[] args) {
		// abstract class can't be instantiated	
		// Class1 class1=new Class1();
	}
}
