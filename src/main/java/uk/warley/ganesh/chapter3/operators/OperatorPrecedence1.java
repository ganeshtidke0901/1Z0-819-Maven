package uk.warley.ganesh.chapter3.operators;

public class OperatorPrecedence1 {

	public static void main(String[] args) {

//		example2();
//		example3();
//		example4();
//		example5();
//		example6();
//		example7();
		example8();
//		example9();
}

	public static void example1() {
		int a = 10;
//		int b=10++;
		int b = 20;
		int c = a++ * 2 + ++a * 5;
		System.out.println("a=" + a + " b=" + b + " c=" + c);
		//a=12 b=20 c=80
	}

	public static void example2() {
		int a = 10;
		int b = 20;
		int c = a++ * (byte) -++a;
		System.out.println("a=" + a + " b=" + b + " c=" + c);
		byte d = -0b0000011;
		System.out.println(d);//-3 
		System.out.println(Integer.toBinaryString(d));//11111111111111111111111111111101  (-3 is stored with 2's complement)
		System.out.println(Integer.toBinaryString(0b0000011));//00000000000000000000000000000011  (3 is stored as is)
			System.out.println(0b0000011);//3
		System.out.println(-0b0000011);//-3
		
		//a=12 b=20 c=-120
		//11111111111111111111111111111101

	}

	public static void example3() {
		int a = 10;
		int b = 20;
		int c = a++ * ++b % a++;
		System.out.println(c);//1
		System.out.println(10*21%11);//1

	}

	public static void example4() {
		int a = 10;
		int b = 20;
		int c = a++ * ++b % a++ << 2;
		System.out.println(c);//4 (1<<2 ---> 00000000000000000000000000001<<2)

	}

	public static void example5() {
		int a = 10;
		int b = 20;
		int c = (byte) a++ * ++b % a++ << 2; // a++ applied first, ++b , (byte) ,* , <</>>/>>>
		System.out.println(c);//4

	}

	public static void example6() {
		int a = 10;
		int b = 20;

		boolean c = b> a && b > 0 && null instanceof String && ++b>0;
		System.out.println(b);//20 here tough ++ has more precedence but && short-circuit  
		System.out.println(c);// >,instanceof, &&
		System.out.println(null instanceof String);//false

	}
	
	public static void example7() {
		int a = 10;
		int b = 20;

		boolean c = b> a & b > 0 && null instanceof String | b<a == b>1==false; //(>,<,>=,<=,instanceof), (==,!=) ,(&,|),
		System.out.println(true&true&& false|false==true==false);
		System.out.println(true&true&& false|true);
		System.out.println(true&& true);
		System.out.println(true);
		System.out.println(c);

	}
	public static void example8() {
		int a = 1;
		int b = 2;
		int c=   ~-(short)a;
//		System.out.println(~-10);
//		System.out.println(~(-10));
		System.out.println(c);
		
		int d= -~(short)a;
//		System.out.println(-~a);
//		System.out.println(-(-11));
		System.out.println(~1);//-1-2=-2 
		System.out.println(-~1);//2
	}

	

	public static void example9() {
		int a = 10;
		int b = 20;

		boolean c = b> a & b > 0 && null instanceof String | b<a == b>1==false && a>b?false:true; //(>,<,>=,<=,instanceof), (==,!=) ,(&,|),
		System.out.println(true&true&& false|false==true==false&& false?false:true);
		System.out.println(true&true&& false|true&& false?false:true);
		System.out.println(true&& true&& false?false:true);
		System.out.println(true&& false?false:true);
		System.out.println(false?false:true);
		System.out.println(c);

	}
}
