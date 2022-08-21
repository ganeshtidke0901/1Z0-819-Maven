package uk.warley.ganesh.chapter5.corejavaapis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ArrayListDemo5 {
	public static void main(String[] args) {
//		example1();
		example2();
//		example3();
//		example4();
	}

	private static void example1() {
		ArrayList arrayList1=new ArrayList();
		ArrayList arrayList2=new ArrayList(10);//capacity
		ArrayList arrayList3=new ArrayList(arrayList2);
		
		ArrayList<String> list1=new ArrayList<>();//E =String
		for (String string : list1) {
			
		}
		var list2=new ArrayList<>();//E=Object
		for (Object object : list2) {
			
		}
		
	}

	private static void example2() {
		List<String> list1=new  ArrayList<>();
		list1.add("Ganesh");
		list1.add(0, "Tidke");
		
		
		System.out.println(list1.remove(0));//Tidke
		System.out.println(list1.remove("Tidke"));//false
	
		System.out.println(list1.set(0, "Ganesh"));//Ganesh
		System.out.println(list1.isEmpty());//false
		System.out.println(list1.size());//1
		list1.clear();
		
		System.out.println(list1.contains("Ganesh"));//false
		
		list1.add("Ganesh");
		System.out.println(list1.equals(Arrays.asList("Ganesh")));//true
		list1.add(null);
		System.out.println(list1.equals(Arrays.asList("Ganesh")));//false
		
	}

	private static void example3() {

	}

	private static void example4() {

	}
}
