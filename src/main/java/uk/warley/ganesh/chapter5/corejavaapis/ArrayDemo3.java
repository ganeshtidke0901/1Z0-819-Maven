package uk.warley.ganesh.chapter5.corejavaapis;

import java.util.Arrays;

public class ArrayDemo3 {
	public static void main(String[] args) {

		example1();
//		example2();
//		example3();
//		example4();

	}

	private static void example1() {
		int [] a1=new int[-5];//NegativeArraySizeException
		int[] a2 = new int[0];
		a2[0] = 0;// ArrayIndexOutOfBoundsException
		a2[1] = 0;
		a2[2] = 0;
		a2[3] = 0;
		a2[4] = 0;

	}

	private static void example2() {
		int[] a1[] = new int[1][];// last empty index to declare dynamic size
		a1[0] = new int[1];
		a1[0][0] = 10;

		int[] a2[] = new int[1][0];// last 0 index to declare dynamic size
		a2[0] = new int[10];
		a2[0][9] = 10;

	}

	private static void example3() {

		byte[] a3 = new byte[5];
		for (int i = 0; i < a3.length; i++) {
			System.out.print(a3[i] + "  ");// 0 0 0 0 0
		}
		System.out.println();
		char[] a2 = new char[5];
		for (int i = 0; i < a2.length; i++) {
			System.out.print(a2[i] + " ");// empty char
		}

		System.out.println();
		int[] a1 = new int[5];
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i] + " ");// 0 0 0 0 0
		}

		System.out.println();
		long[] a5 = new long[5];
		for (int i = 0; i < a5.length; i++) {
			System.out.print(a5[i] + " ");// 0 0 0 0 0
		}

		System.out.println();
		float[] a6 = new float[5];
		for (int i = 0; i < a6.length; i++) {
			System.out.print(a6[i] + " ");// 0.0 0.0 0.0 0.0 0.0
//			a6[0]=0.0;//not allowed but still initial value is 0.0
		}

		System.out.println();
		double[] a7 = new double[5];
		for (int i = 0; i < a7.length; i++) {
			System.out.print(a7[i] + " ");// 0.0 0.0 0.0 0.0 0.0

		}

		System.out.println();
		boolean[] a8 = new boolean[5];
		for (int i = 0; i < a8.length; i++) {
			System.out.print(a8[i] + " ");// false false false false false
		}

		System.out.println();
		ArrayDemo3[] a9 = new ArrayDemo3[5];
		for (int i = 0; i < a9.length; i++) {
			System.out.print(a9[i] + " ");// null null null null null
		}

	}

	private static void example4() {
		int[] a = { 10, -2, -1, 0, 6 };
		Arrays.sort(a);// -2 -1 0 6 10

		String[] a2 = { "Ganesh", "tidke", "ganesh", "12a", "12A" };
		Arrays.sort(a2);// 12A 12a Ganesh ganesh tidke

		int[] a3 = null;
		Arrays.sort(a3);// NullPointerException

	}


}
