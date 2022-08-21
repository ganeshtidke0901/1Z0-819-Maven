package uk.warley.ganesh.chapter7.methodsandencapsulation;

import uk.warley.ganesh.pkg1.ClassB;

public class AccessModifiersDemo4 extends ClassB {

	void test() {
//		System.out.println(number);// number is private to ClassB
//		System.out.println(name);// name is default (package-private)
		System.out.println(surname); // surname is protected
		System.out.println(schoolName);

	}

	public static void main(String[] args) {
		ClassB b = new ClassB();
//		System.out.println(b.number);// number is private to ClassB
//		System.out.println(b.name);// name is default (package-private)
//		System.out.println(b.surname); // surname is protected and can be accessed using child reference
		System.out.println(b.schoolName);

		AccessModifiersDemo4 accessModifiersDemo4 = new AccessModifiersDemo4();
//		System.out.println(accessModifiersDemo4.number);// number is private to ClassB
//		System.out.println(accessModifiersDemo4.name);// name is default (package-private)
		System.out.println(accessModifiersDemo4.surname); // surname is protected and can be accessed using child
															// reference
		System.out.println(accessModifiersDemo4.schoolName);

		ClassB accessModifiersDemo41 = new AccessModifiersDemo4();
//		System.out.println(accessModifiersDemo41.number);// number is private to ClassB
//		System.out.println(accessModifiersDemo41.name);// name is default (package-private)
//		System.out.println(accessModifiersDemo41.surname); // surname is protected and can be accessed using child reference
		System.out.println(accessModifiersDemo41.schoolName);

	}
}

class ClassC  {

	static void test2() {
		AccessModifiersDemo4 accessModifiersDemo4 = new AccessModifiersDemo4();
//		System.out.println(accessModifiersDemo4.number);// number is private to ClassB
//		System.out.println(accessModifiersDemo4.name);// name is default (package-private)
//		System.out.println(accessModifiersDemo4.surname); // only accessible from within AccessModifiersDemo4
		System.out.println(accessModifiersDemo4.schoolName);
		
			
	}

}


class ClassD extends AccessModifiersDemo4  {

	static void test2() {
		AccessModifiersDemo4 accessModifiersDemo4 = new AccessModifiersDemo4();
//		System.out.println(accessModifiersDemo4.number);// number is private to ClassB
//		System.out.println(accessModifiersDemo4.name);// name is default (package-private)
//		System.out.println(accessModifiersDemo4.surname); // only accessible from within AccessModifiersDemo4 (becomes private to AccessModifiersDemo4 )
		System.out.println(accessModifiersDemo4.schoolName);
		
			
	}

}