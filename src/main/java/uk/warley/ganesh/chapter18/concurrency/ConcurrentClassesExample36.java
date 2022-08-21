package uk.warley.ganesh.chapter18.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentClassesExample36 {
	Collection<String> copyOnWriteListy1 =  Collections.synchronizedCollection(new ArrayList<String>());
	List<String> copyOnWriteListy = new CopyOnWriteArrayList<>();
	List<String> list = new ArrayList<>();

	public static void main(String[] args) {

		var a = new ConcurrentClassesExample36();

		Runnable writer = () -> {
			a.copyOnWriteListy.add("Ganesh");
//				a.list.add("Tidke");

		};

		Runnable reader = () -> {
//				System.out.println("copyOnArrayList:"+a.copyOnWriteListy);
//				System.out.println("List:"+a.list);
			a.copyOnWriteListy.remove("Ganesh");
//				a.list.remove("Tidke");

		};

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			executorService.submit(writer);
			executorService.submit(reader);
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
		// End:[Tidke, Tidke, Tidke, Tidke, Tidke, Tidke, Tidke, Tidke, Tidke] Size:9
		// End:[Tidke, Tidke, Tidke, Tidke, Tidke, Tidke, Tidke, Tidke, Tidke, Tidke] Size:10
		System.out.println( "  Size:" + a.copyOnWriteListy.size());
		System.out.println("End:" + a.copyOnWriteListy + "  Size:" + a.copyOnWriteListy.size());// java.util.ConcurrentModificationException
		
		// End:[Ganesh] Size:1
		// End:[Ganesh, Ganesh] Size:2
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