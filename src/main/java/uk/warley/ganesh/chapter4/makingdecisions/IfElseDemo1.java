package uk.warley.ganesh.chapter4.makingdecisions;

public class IfElseDemo1 {
	public static void main(String[] args) {
		example1();
		example2();
	}
	private static void example1() {
		int i = 0;
		if (i == -1)System.out.println();
		else if (i == 2)System.out.println();
		else if (i == 3)System.out.println();
		else System.out.println();
	}
	private static void example2() {

		if(true)
		if(false)System.out.println();
		else System.out.println();
		else if(""=="")System.out.println();
		else System.out.println();
		if(false)System.out.println();
		else System.out.println();

		
//		if(true) System.out.println();
//		if(false)System.out.println();
//		else System.out.println();
//		else System.out.println();

		if(true) 
		if(false)System.out.println();
		else System.out.println();
		else System.out.println();

		if(true) 
		if(true) 
		if(false)System.out.println();
		else System.out.println();
		else System.out.println();
		
	}

	
}
