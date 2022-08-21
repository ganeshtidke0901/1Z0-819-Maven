package uk.warley.ganesh.chapter2.javabuildingblocks;

public class InitializationBlocksOrder1 {

	int b = 10;
	{
//		System.out.println(a);
		System.out.println("Instance Initializer block:" + b);
	}

	public InitializationBlocksOrder1() {
		b = 20;
		a = 10;
		System.out.println("Constructor b:" + b);
		System.out.println("Constructor a:" + a);

	}

	public static void main(String[] args) {
//		var i = new InitializationBlocksOrder();
		AA aa=new AA();
//		AA.mm();
//		AA aa=null;
	}

	public void instanceMethod1() {
		System.out.println("InstanceMethod1 a:" + a);

	}

	int a;

	static {
//		System.out.println(a);
		System.out.println("static Initializer block Main:");
	}
}



class AA{
	static {
//		System.out.println(a);
		System.out.println("AA static Initializer block:");
	}
	public static void mm() {
		
		System.out.println("AA static method:");
		
	}
	int c;
	
	AA()
	{
		System.out.println("before AA constru: c="+c);
		c=12;
		System.out.println("after AA constru: c="+c);
	}
	
	{
		System.out.println("before c=11, c is "+c);
		c=11;
		System.out.println("after c=11, c is "+c);
	
	}
}