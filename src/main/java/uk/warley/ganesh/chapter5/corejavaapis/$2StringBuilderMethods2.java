package uk.warley.ganesh.chapter5.corejavaapis;

public class $2StringBuilderMethods2 {

	public static void main(String[] args) {
		example1();
//		exmampe2();
		example3();
	}

	private static void example1() {
		StringBuilder builder = new StringBuilder();

		// builder.replace(1, 2,"Ganesh");//StringIndexOutOfBoundsException
		builder.replace(0, 1000, "Ganesh");// Ganesh

		builder.append(" Tidke");// Ganesh Tidke
		builder.append(false);// Ganesh Tidkefalse

		builder.indexOf("Gan");// 0
		builder.charAt(0);// 'G'
		builder.length();//17
		builder.substring(1, 1);// Empty string ""
		builder.substring(17, 17);// Empty string ""
//		builder.substring(5, 4);// StringIndexOutOfBoundsException

		builder.insert(17, "MR.");// Ganesh TidkefalseMR.
//		builder.insert(18, "MR. ");//StringIndexOutOfBoundsException

		
		builder.delete(12, 17);//Ganesh TidkeMR.
		builder.length();//15
//		builder.deleteCharAt(15);//StringIndexOutOfBoundsException
		
		builder.reverse();// .TRekdiT hsenaG
		builder.toString();
		System.out.println(builder);

	}

	private static void exmampe2() {
		StringBuilder builder = new StringBuilder();
		StringBuilder buider2 = new StringBuilder("Ganesh");
		StringBuilder builder3 = new StringBuilder(20);// capacity
	}

	private static void example3() {

	}

}
