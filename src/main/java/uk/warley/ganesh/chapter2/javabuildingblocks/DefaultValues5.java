package uk.warley.ganesh.chapter2.javabuildingblocks;

public class DefaultValues5 {
	static byte a;
	static short b;
	static int c;
	static long d;
	static float e;
//	static float e1=0.0; //DOES NOT WORK - NEED TO ADD 0.0F
	static double f;
	static char g;
	static boolean h;
	static String i;

	public static void main(String[] args) {
		var defaultValues = new DefaultValues5();
		System.out.println(a);//0
		System.out.println(b);//0
		System.out.println(c);//0
		System.out.println(d);//0
		System.out.println(e);//0.0
		System.out.println(f);//0.0
		System.out.println("--" + g + "---");//empty char
		System.out.println(h);//false
		System.out.println(i);//null

	}
}
