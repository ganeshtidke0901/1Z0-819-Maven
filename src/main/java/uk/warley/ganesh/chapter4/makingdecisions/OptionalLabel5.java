package uk.warley.ganesh.chapter4.makingdecisions;

import java.util.Iterator;

public class OptionalLabel5 {
	public static void main(String[] args) {
		example1();
		example2();

	}

	private static void example1() {
		LABEL1: while (true) {
		}
//		System.out.println();//Unreachble code
	}

	private static void example2() {
		LABEL1: if (true == true)
			LABEL2: {
			}
		LABEL3: System.out.println();
		int j=0;
		
	}

	private static void example3() {
		int a = 0;
		LABEL1: do {

		}
		
		
		while (a < 0);
		LABEL1: for (int i = 0; i < 10; i++) {
			LABEL2: switch (i) {
			case 0:
			LABEL5:	continue;//allowed as in loop

			default:
				LABEL6: break;
			}
		}
		
		
		
		LABEL4: switch (0) {
		case 10:

//			continue;// continue only for loops
		default:
			break;
		}
	}

	private static void example4() {

	}

	private static void example5() {

	}

	private static void example6() {

	}

	private static void example7() {

	}
}
