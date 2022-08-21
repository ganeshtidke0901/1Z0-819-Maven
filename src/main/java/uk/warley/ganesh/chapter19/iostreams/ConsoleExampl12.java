package uk.warley.ganesh.chapter19.iostreams;

import java.io.Console;

public class ConsoleExampl12 {

	//please run on command prompt to see the result
	static void example1() {
		
		Console console=System.console();
		if(console!=null)
		{
			console.writer().println("Enter the name:");
			String s=console.readLine();
			System.out.println(s);
			console.format("%-10s %-5d", "Ganesh",1000);
			System.out.println();
			console.writer().println("Enter password");
			System.out.println(console.readPassword());
			System.out.println(console.readLine("%s ==%d", "Enter password of length",5));
			
		}else
		{
			System.out.println("console is not available");
		}
//		Enter the name:
//			Ganesh
//			Ganesh
//			Ganesh     1000
//			Enter password
//
//			Tidke
//			Enter password of length ==5Hello
//			Hello
		
		
	}

	static void example2() {
	}

	public static void main(String[] args) {
		example1();
//		example2();
//		example3();
//		example4();
	}
}
