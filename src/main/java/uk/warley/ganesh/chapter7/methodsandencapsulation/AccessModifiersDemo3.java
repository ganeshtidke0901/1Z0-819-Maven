package uk.warley.ganesh.chapter7.methodsandencapsulation;

import uk.warley.ganesh.pkg1.ClassB;

public class AccessModifiersDemo3 {
	public static void main(String[] args) {
		ClassB b=new ClassB();
//		System.out.println(a.number);// number is private to ClassB
//		System.out.println(b.name);// name is default (package-private)
//		System.out.println(b.surname); // surname is protected
		System.out.println(b.schoolName);
	
	}
}

