package uk.warley.ganesh.chapter4.makingdecisions;

public class BasicForLoop3 {
	public static void main(String[] args) {
//		example1();
//		example2();
		example3();
//		example4();
//		example5();
//		example6();
		
	}

	private static void example1() {

		for (; ; ) {
		}
		
		
//		for (; ; ) {
//		} //Unreachable code
	
	}

	private static void example2() {
		byte c=30;
		for (int i=0,b=10;c>20 ; c++,i++) {
			
		}
//		for (int i=0,int b=10;c>20 ; c++) {} //DOES NOT COMPILE  cant have two ints in multiple declaration
		
	}

	private static void example3() {
		byte c=0;
		for (int i=0,b=10;c<10; c++,c+=3,System.out.println(c)) {
			;
		}

		
	}

	private static void example4() {
		for (int i = 0; i<10; example3()) {
			
		}
//		for (example3(); i<10; ) {} //only declaration allowed in first section
		
		
		int i=0;
//		for (int i = 0; i <10; i++) {} //redeclaring int i as there are not in different block {}
		
	}

	private static void example5() {
		// TODO Auto-generated method stub
		
	}

	private static void example6() {
		// TODO Auto-generated method stub
		
	}
}
