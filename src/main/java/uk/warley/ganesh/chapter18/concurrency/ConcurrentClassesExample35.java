package uk.warley.ganesh.chapter18.concurrency;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;

public class ConcurrentClassesExample35 {

	public static void main(String[] args) {

		ConcurrentMap<String, Integer> concurrentMap = new ConcurrentHashMap<String, Integer>();
		concurrentMap.put("Ganesh", 2);// when one thread is trying to access concurrent map then no other thread is
										// allowed to use this map.hence the put operation is atomic. in case of one
										// thread is writing and another thread reads latest value written by first
										// thread , this atomic operation wont help as in e.g if second thread get
										// chance
										// first to run read atomic operation and first thread is sleeping before
										// writing to map, it means second thread will always get empty map . so in
										// order to make this work , we need to order the execution by letting first
										// thread always writes and second thread reads later
										// if it was not concurrent map then put operation is not atomic and two threads
										// would be able to call put opertation and thats how both threads will be
										// mixing up their state with data (read and write operations) in put method

		Queue<String> queue = new ConcurrentLinkedQueue<String>();
		queue.offer("ganesh");
		System.out.println(queue.offer("tidke"));// true
		System.out.println(queue.peek());// ganesh
		System.out.println(queue.poll());// ganesh
		System.out.println(queue.poll());// tidke
		System.out.println(queue.poll());// null

		ConcurrentMap<String, String> concurrentMap2 = new ConcurrentSkipListMap<String, String>();// SkipList is always
																									// sorted version
		concurrentMap2.put("Ganesh", "Tidke");
		concurrentMap2.put("Ashwini", "Zya");
		concurrentMap2.put("ABC", "XYZ");

		System.out.println(concurrentMap2);// {ABC=XYZ, Ashwini=Zya, Ganesh=Tidke} sorted as per keys

		NavigableSet<String> navigableSet = new ConcurrentSkipListSet<String>();
		// or
		SortedSet<String> navigableSet1 = new ConcurrentSkipListSet<String>();

		navigableSet.add("Ganesh");
		navigableSet.add("ABC");
		navigableSet.add("XZY");
		System.out.println(navigableSet);//[ABC, Ganesh, XZY]

		List<String> list=new CopyOnWriteArrayList<>();
		list.add("Ganesh");
		list.add("Tidke");
		System.out.println(list);//[Ganesh, Tidke]
		
		
		Set<String> set=new CopyOnWriteArraySet<String>();
		set.add("Ganesh");
		set.add("Tidke");
		System.out.println(set);
		
		
		for (String string : list) {//when i got iterator , i got on [Ganesh,Tidke] ..next we add element then new copy is created but here still we are iterating over old data
			System.out.println(string);//Ganesh
										//Tidke
			list.add("Ganesh");
		}
		
		System.out.println(list);//[Ganesh, Tidke, Ganesh, Ganesh]
		
		
		
		BlockingQueue<String> blockingQueue=new LinkedBlockingQueue<String>();

	}
}