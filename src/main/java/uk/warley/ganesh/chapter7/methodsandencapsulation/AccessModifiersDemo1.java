package uk.warley.ganesh.chapter7.methodsandencapsulation;

public class AccessModifiersDemo1 {
	int number = 20;

	public static void main(String[] args) {
		ClassA a = new ClassA();
//		System.out.println(a.number);// number is private to ClassA
		System.out.println(a.name);
		System.out.println(a.surname);
		System.out.println(a.schoolName);
		
		
		
	}
}

class ClassA {
	private int number = 10;
	String name = "Ganesh";
	protected String surname = "Tidke";
	public String schoolName = "Gajanan";

	private int getNumber() {
		return number;
	}

	String getName() {
		return name;
	}

	protected String getSurName() {
		return surname;
	}

	public String getSchoolName() {
		return schoolName;
	}
}
