package uk.warley.ganesh.chapter5.corejavaapis;

public class StringDoubleEquals9 {
	public static void main(String[] args) {

		String s1 = "Ganesh";
		String s2 = "Ganesh";
		System.out.println(s1 == s2);// true

		String s3 = "Gan" + "esh";
		String s4 = "Ganesh";
		System.out.println(s3 == s4);// true
		System.out.println(s3.intern() == s4.intern());// true

		String s5 = "Gan";
		s5 = s5 + "esh";// or s5+="esh";
		String s6 = "Ganesh";
		System.out.println("--"+  (s5 == s6));// false

		String s7 = "Ga" + "ne" + "sh";
		String s8 = "Ganesh";
		String s9 = " Ganesh".trim();
		String s10 = "Ganesh".trim();
		String s11 = "Ganesh" + "Ganesh".substring(6, 6);//other part dynamic-new Strig is created
		String s12="Gan"+getStr();
		String s13="Ganesh".substring(0);
		String s14="Gan"+"esh".substring(0);
		
		System.out.println(s7 == s8);// true
		System.out.println("++"+(s8 == s9));// false
		System.out.println(s8 == s10);// true
		System.out.println(s8 == s11);// false
		System.out.println(s8 == s12);// false
		System.out.println(s8 == s13);// true
		System.out.println(s8 == s14);// false

	}

	static String getStr() {
		return "esh";
	}
}
