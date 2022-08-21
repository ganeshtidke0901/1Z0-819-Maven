package uk.warley.ganesh.chapter5.corejavaapis;

import java.util.ArrayList;
import java.util.List;

public class WrapperClassesDemo10 {
	public static void main(String[] args) {

		example1();
		example2();
		example3();
		example4();
		example5();
	}

	private static void example1() {
		byte a = 11;
		char c = 65;

		Byte byte1 = Byte.valueOf((byte) 11);
		Short short1 = Short.valueOf((short) 20);
		Character character = Character.valueOf('c');
		Character character2 = Character.valueOf((char) 65);
		Integer integer = Integer.valueOf(10);
		Long long1 = Long.valueOf(100);
		Float float1 = Float.valueOf(0.0f);
		Double d = Double.valueOf(0.0);

		Byte byte2 = Byte.valueOf("11");
		Short short2 = Short.valueOf("12");
		Integer integer2 = Integer.valueOf("11");
		Long long12 = Long.valueOf("11");
		Float float12 = Float.valueOf("11");
		Double d2 = Double.valueOf("12");

		byte byte3 = Byte.parseByte("11");
		short short3 = Short.parseShort("12");
		int integer3 = Integer.parseInt("11");
		long long13 = Long.parseLong("11");
		float float13 = Float.parseFloat("11");
		double d23 = Double.parseDouble("12");

	}

	private static void example2() {
		//Autoboxing
		List<Integer>  integers=new ArrayList<Integer>();
		integers.add(1);
		integers.add(2);
		integers.remove(1);
		System.out.println(integers);//[1]
		integers.remove(new Integer(1));
		System.out.println(integers);//[]
	}

	private static void example3() {

	}

	private static void example4() {
		// TODO Auto-generated method stub

	}

	private static void example5() {

	}
}
