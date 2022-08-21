package uk.warley.ganesh.chapter8.classdesign;

public class FinalFieldsWithConstructor {
	final static String s2;//first way
	static {
		s2 = "Ganesh";
	}

	final static String s3 = "Tidke";//second way

	final String s;//first way

	FinalFieldsWithConstructor() {
		this.s = "";

	}

	final String s4 = "xyz";//second way
	final String s5;//third way
	{
		s5 = "abc";
	}

	public static void main(String[] args) {

	}
}
