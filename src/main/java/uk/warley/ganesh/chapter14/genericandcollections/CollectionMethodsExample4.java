package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionMethodsExample4 {
	public static void main(String[] args) {
		
		Collection<String> list=new ArrayList<String>();
		Collection<String> set=new HashSet<String>();
		
		
		System.out.println(list.add("Ganesh"));//true
		System.out.println(list.add("Ganesh"));//true
		
		System.out.println(set.add("Ganesh"));//true
		System.out.println(set.add("Ganesh"));//false
		
		
		System.out.println(list.remove("Ganesh"));//true
		System.out.println(set.remove("ABC"));//false
		
		
		System.out.println(list.isEmpty());//false
		System.out.println(set.isEmpty());//false
		
		System.out.println(list.size());//1
		System.out.println(set.size());//1
		
		list.clear();
		set.clear();
		
		System.out.println(list.contains("Ganesh"));//false
		System.out.println(set.contains("Ganesh"));//false
		
		
		
		System.out.println(list.removeIf(s->"Ganesh".startsWith(s)));//false
		System.out.println(list.removeIf("Ganesh"::startsWith));//false  //calling on particular object
		
		System.out.println(list.removeIf(String::isEmpty));//false == s-> s.empty()-calling on parameter object
		list.forEach(s->System.out.println(s));
		list.forEach(System.out::println);
		
		
	}
}
