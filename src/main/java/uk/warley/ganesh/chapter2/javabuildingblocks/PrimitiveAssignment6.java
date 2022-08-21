package uk.warley.ganesh.chapter2.javabuildingblocks;

public class PrimitiveAssignment6 {
	public static void main(String[] args) {

		byte a=127;
		System.out.println(Integer.toBinaryString(a));//111 1111
		System.out.println(0B11111111);//255(1111 1111)
//		short  b=65000;
		int c= 65000;
		long d=65000;
		
//		int e=d*c;
//		float f=120.0;
		double g=120.0;
		
//		byte h=a*a;
//		int i=g*a;
		int i=(int) (g*a);
		double i1= (g*a);
	}
}
