package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.ArrayList;
import java.util.List;

public class ListMethodsExample5 {
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		list.remove(1);// will always remove value at index 1 which is 2
		System.out.println(list);// [1, 3]

		list.remove(Integer.valueOf(1));//will remove value 1
		System.out.println(list);//[3]
		
		
//		for (Integer integer : list) {
//			list.remove(integer);//java.util.ConcurrentModificationException
//		}
		
		System.out.println(list.get(0));//3
		list.set(0, 4);//[4]
		list.replaceAll(s->s+10);//[14]
		
		
	}
}
