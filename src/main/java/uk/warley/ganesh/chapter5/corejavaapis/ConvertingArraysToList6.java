package uk.warley.ganesh.chapter5.corejavaapis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertingArraysToList6 {
	public static void main(String[] args) {

//		example0();
//		example1();
		example2();
//		example3();

	}

	private static void example0() {
		String[] array = { "Ganesh", "Tidke" };
		List<String> list = Arrays.asList(array);// Fixed sized

		System.out.println(list);// [Ganesh, Tidke]
//		list.remove(0);//UnsupportedOperationException
		list.set(0, "Mr Ganesh");
		System.out.println(list);// [Mr Ganesh, Tidke]
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);// Mr Ganesh, Tidke
		}

		List<String> list1 = Arrays.asList("Ganesh", "Tidke");

	}

	private static void example1() {
		String[] array = { "Ganesh", "Tidke" };
		List<String> list=List.of(array);//immutable list
//		list.set(0, "Mr Ganesh");//UnsupportedOperationException
		
	}

	private static void example2() {
		List<String> list=new ArrayList<String>();
		list.add("Ganesh");
		list.add("Tidke");
		Object [] array= list.toArray();
		String [] array2= list.toArray(new String[3]);//[Ganesh, Tidke]
		array2[2]="Jsut";
		System.out.println(Arrays.toString(array2));//[Ganesh, Tidke, Jsut]
		System.out.println(list);//[Ganesh, Tidke]
		String [] array3=list.toArray(new String[0]);//[Ganesh, Tidke]
		
		System.out.println(array3.length);//2
		
		
	}

	private static void example3() {

	}
}
