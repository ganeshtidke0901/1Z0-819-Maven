package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LinkedListExample7 {
	public static void main(String[] args) {
	
		//Deque extends Queue
		Deque<Float> floats=new LinkedList<>();
//		floats.add(1);//1--> Integer into  Float not possible
		floats.add(1f);
		floats.add(2f);
		floats.add(3f);
		System.out.println(floats);//[1.0, 2.0, 3.0]

		floats.offer(4f);
		floats.offer(5f);
		System.out.println(floats);//[1.0, 2.0, 3.0, 4.0, 5.0]
		System.out.println(floats.remove(1));//false as 1 --> Integer --> Object and this object does not exist
		System.out.println(floats.remove(1f));//true as 1f--> Float--> Object
		System.out.println(floats);//[2.0, 3.0, 4.0, 5.0]
		
		System.out.println(floats.poll());//2.0
		System.out.println(floats);//[3.0, 4.0, 5.0]
		
		
		System.out.println(floats.peek());//3.0
		System.out.println(floats);//[3.0, 4.0, 5.0]
		
		floats.clear();
		Stack<String > dwd;
		System.out.println(floats.peek());//null
		System.out.println(floats.poll());//null
	}
}
