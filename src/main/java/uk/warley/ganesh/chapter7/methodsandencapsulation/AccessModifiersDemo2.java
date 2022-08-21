package uk.warley.ganesh.chapter7.methodsandencapsulation;

public class AccessModifiersDemo2 {
	public static void main(String[] args) {
		ClassA a=new ClassA();
//		System.out.println(a.number);// number is private to ClassA
		System.out.println(a.name);
		System.out.println(a.surname);
		System.out.println(a.schoolName);
	
	}
}

