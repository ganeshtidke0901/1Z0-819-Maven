package uk.warley.ganesh.chapter8.classdesign;

class AC5{
	public String name = "Parent";
	protected static String name1 = "Parent";
	
	protected String name2="parent";
	protected static String name3="parent";
	
	private static int a;

	public static boolean test() {
		a=10;
		return false;
	}

}

public class HidingVariables12 extends AC5 {

	// hiding the name from parent
	protected String name = "Child";
	protected static String name1 = "Child";

	public static boolean test() {
		return true;
	}


	public static void main(String[] args) {
		HidingVariables12 child = new HidingVariables12();
		AC5 parent = child;
		System.out.println(parent.name);//Parent
		System.out.println(child.name);// Child
		System.out.println(parent.name1);//Parent
		System.out.println(child.name1);// Child
		System.out.println(parent.test());// false
		System.out.println(child.test());// true 
	
		
		System.out.println(parent.name2);//Parent
		System.out.println(child.name2);// Parent
		System.out.println(parent.name3);//Parent
		System.out.println(child.name3);// Parent
		
	}
}
