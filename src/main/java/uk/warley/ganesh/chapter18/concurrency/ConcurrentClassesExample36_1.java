package uk.warley.ganesh.chapter18.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentClassesExample36_1 {
//	Collection<String> copyOnWriteListy =  Collections.synchronizedCollection(new ArrayList<String>());
	List<String> copyOnWriteListy = new CopyOnWriteArrayList<>();
	List<String> list = new ArrayList<>();

	public static void main(String[] args) {

		var a = new ConcurrentClassesExample36_1();

		Runnable runnable1 = () -> {
			a.copyOnWriteListy.add("Ganesh");
			a.copyOnWriteListy.remove("Ganesh");

		};

		Runnable runnable2 = () -> {
//				System.out.println("copyOnArrayList:"+a.copyOnWriteListy);
//				System.out.println("List:"+a.list);
			a.copyOnWriteListy.remove("Ganesh");
//				a.list.remove("Tidke");

		};

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 1000; i++) {
			executorService.submit(runnable1);
		}

		executorService.shutdown();
		try {
			executorService.awaitTermination(400, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(executorService.isShutdown());
		System.out.println("End:" + a.list + " Size:" + a.list.size());// java.util.ConcurrentModificationException
		System.out.println( "  Size:" + a.copyOnWriteListy.size());
		System.out.println("End:" + a.copyOnWriteListy + "  Size:" + a.copyOnWriteListy.size());// java.util.ConcurrentModificationException
		
		// End:[] Size:0
		// End:[] Size:0
		// End:[] Size:0

		// any concurrent classes - make sure at any point update/modification/write being done on shared
		// data, reader will always get consistent data either old or latest based on when reader reads the
		// data
		// CopyOnWrite is same

		// copyonWrite is always consistent with data as in no null in list (add +remove)- list size may vary
		// as remove migth happen first before add
		// normal list is always incosistent as there in null in it(add+remove) list size may vary as remove
		// migth happen first before add
		
		//add() called on copyonwrite = result is always same .size =consistent 
		//add on normal list is having incosistent data
		

	}
}