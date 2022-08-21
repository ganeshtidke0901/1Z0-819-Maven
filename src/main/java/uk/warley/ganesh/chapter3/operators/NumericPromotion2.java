package uk.warley.ganesh.chapter3.operators;

public class NumericPromotion2 {

	public static void main(String[] args) {

		example1();

	}

	public static void example1() {
		short a = 10;
		short b = 20;
//		byte dd=128;
		short c = 10 * 20;
		short d = (short) (a * b); // need to apply cast as both a and b result into int
		int e = 10;
		float f = e;

		float g = 10;
		int h = (int) g;

		long i = 10;
		double j = i;
		long k = (long) j;
		double l=i*j;
		
		int m=10;
		float n=10;
		float o=m*n;

		System.out.println(100==o);//true
		
		short p= (short)10* (short)10;//here compiler knows the literal value
		short q=(short) ((short)a* (short)b);
		
	}

}
