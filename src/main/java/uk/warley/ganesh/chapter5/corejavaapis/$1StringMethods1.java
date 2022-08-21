package uk.warley.ganesh.chapter5.corejavaapis;

public class $1StringMethods1 {
	public static void main(String[] args) {
		example1();
	}

	static void example1() {
		String s = "Ganesh";
		int l = s.length();//6

		char c = s.charAt(0);// G
//		char d = s.charAt(s.length());// StringIndexOutofBoundException

		int i = s.indexOf(71);// 0
		i = s.indexOf(71, 0); // 0
		i = s.indexOf("Gan", 1000);// -1
		i = s.indexOf("1Gan");// -1

		String s2 = s.substring(1);// anesh
		String s3 = s.substring(1, 6);// anesh
		String s31 = s.substring(1, 8);// java.lang.StringIndexOutOfBoundsException
		String s4 = s.substring(6, 6);// empty string
//		String s5=s.substring(2,1);//java.lang.StringIndexOutOfBoundsException

		String s6 = s.toLowerCase();
		String s7 = s.toUpperCase();

		String s8 = "Ganesh";
		System.out.println(s8.equals(new Object()));// false
		System.out.println(s8.equalsIgnoreCase("ganesh"));// true

		boolean b1 = s8.startsWith("A");// false
		boolean b2 = s8.endsWith("h");// true

		char d = 90;
		String s9 = s.replace('G', 'B');// Banesh
		String s10 = s.replaceAll("Gan", "Ram");// Ramesh

		boolean b3 = s.contains("Gan");// true

		String s11 = s.trim().strip().stripLeading().stripTrailing();// removes spaces

		
		
		
		
		
//		mm(90);//compiler error
		mm('A');
	}

	static void mm(char a) {

	}
}
