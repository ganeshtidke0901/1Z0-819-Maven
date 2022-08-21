package uk.warley.ganesh.chapter5.corejavaapis;

public class MathAPI7 {
	public static void main(String[] args) {
		example1();
	}

	private static void example1() {
		
		System.out.println(Math.min(1, -2));//-2
		System.out.println(Math.max(1, -2));//1
		
		
		int i=Math.round(20.1f);//20
		long l=Math.round(20.55);//21
		System.out.println(i);
		System.out.println(l);
	
		double d=Math.pow(5, 2);//25.0

		double d2=Math.random();
		System.out.println(d2);
		
		//Range 7-25
		System.out.println((int)(d2*((25-7)+1)));
	
	
	}
}
