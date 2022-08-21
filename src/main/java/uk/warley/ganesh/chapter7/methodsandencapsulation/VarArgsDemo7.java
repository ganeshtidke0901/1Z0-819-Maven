package uk.warley.ganesh.chapter7.methodsandencapsulation;

public class VarArgsDemo7 {
	public static void main(String[] args) {
		method1(1);//0
		method1(2, 3);//1
		method1(4, 5, 6);//2
		method1(2,new int[] { 7, 8, 9 });//3
	}

	static void method1(int a, int... args) {
		System.out.println(args.length);
	}

//varargs should be the last parameter 	
//	static void method1(int... args,int a) {
//		for (int i = 0; i < args.length; i++) {
//			System.out.println(args[i]);
//		}
//	}

// varargs should be the last parameter
//	static void method1(int... args,float... args1) {
//		for (int i = 0; i < args.length; i++) {
//			System.out.println(args[i]);
//		}
//	}

	
	
}
