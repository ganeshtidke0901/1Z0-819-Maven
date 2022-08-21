
package uk.warley.ganesh.chapter5.corejavaapis;

import java.util.ArrayList;
import java.util.List;

public class StringConcatenation8 {
	public static void main(String[] args) {
//		example1();
		example2();
	}

	private static void example1() {

		String s1 = "ganesh";
		s1 += 1 + 2;
		System.out.println(s1);//ganesh3
		s1 += 5;
		System.out.println(s1);//ganesh35

		String s2 = "ganesh";
		System.out.println(1 + 2 + s2);//3ganesh
		System.out.println(s2 + 1 + 2);//ganesh12
		System.out.println(s2 + 2 * 3);//ganesh6

	}

	private static void example2() {
		String s1="Ganesh";
		String s2=new String("  ");
		System.out.println(s2);//empty string 
		System.out.println(s2.isBlank());//true
		System.out.println(s2.isEmpty());//false
		
		String s3=new String(new byte[] {65,66,76,90});
		System.out.println(s3);//ABLZ
		
	}

}
