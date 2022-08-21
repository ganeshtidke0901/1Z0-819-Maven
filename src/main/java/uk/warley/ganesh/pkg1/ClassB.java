package uk.warley.ganesh.pkg1;

public class ClassB {

	static {
		System.out.println("Static initializer:ClassB");
		
	}

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
