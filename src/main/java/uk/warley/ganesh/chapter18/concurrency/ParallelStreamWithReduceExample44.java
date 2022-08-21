package uk.warley.ganesh.chapter18.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamWithReduceExample44 {
	public static void example1() {
		// -----------------------suppose to use concurrent classes like ConcuurentSkipListSet
		ArrayList<String> s = List.of("Ganesh", "Tidke").stream().collect(ArrayList::new, ArrayList::add,
				ArrayList::addAll);
		System.out.println(s);// [Ganesh, Tidke]

		ArrayList<String> list2 = List.of("Ganesh", "Tidke").stream().collect(Collectors.toCollection(ArrayList::new));
		System.out.println(list2);// [Ganesh, Tidke]

		ArrayList<String> list3 = List.of("Ganesh", "Tidke", "XZY", "ABC").stream().collect(() -> {
			var var = new ArrayList();
			System.out.println("hashcode" + var.hashCode());
			;
			return var;
		}, (list, str) -> {
			System.out.println("accumulator list:" + list + ".add(" + str + ")");
			list.add(str);
		}, (list11, list22) -> {
			System.out.println("Combiner:" + list11 + ".addAll(" + list22 + ")");
			list11.addAll(list22);
		});
		System.out.println(list3);
//		hashcode1
//		accumulator list:[].add(Ganesh)
//		accumulator list:[Ganesh].add(Tidke)
//		accumulator list:[Ganesh, Tidke].add(XZY)
//		accumulator list:[Ganesh, Tidke, XZY].add(ABC)
//		[Ganesh, Tidke, XZY, ABC]
	}

	public static void example2() {
		ArrayList<String> list3 = List.of("Ganesh", "Tidke", "XZY", "ABC").stream().parallel().collect(() -> {
			var var = new ArrayList();
			System.out.println("hashcode" + var.hashCode());
			;
			return var;
		}, (list, str) -> {
			System.out.println("accumulator list:" + list + ".add(" + str + ")");
			list.add(str);
		}, (list11, list22) -> {
			System.out.println("Combiner:" + list11 + ".addAll(" + list22 + ")");
			list11.addAll(list22);
		});
		System.out.println(list3);

		
//		hashcode1
//		hashcode1
//		accumulator list:[].add(Tidke)
//		hashcode1
//		hashcode1
//		accumulator list:[].add(Ganesh)
//		accumulator list:[].add(XZY)
//		Combiner:[Ganesh].addAll([Tidke])
//		accumulator list:[].add(ABC)
//		Combiner:[XZY].addAll([ABC])
//		Combiner:[Ganesh, Tidke].addAll([XZY, ABC])
//		[Ganesh, Tidke, XZY, ABC]
		
	}

	public static void example3() {
		
		List.of(1,2,3,4).parallelStream().collect(Collectors.toSet());
		//this does not support parallel reduction
		
		//to achieve it 
		//1. stream is parallel
		//And stream is unordered or collector is Characteristics.UNORDERED
		//And Collecor is  s Characteristics.CONCURRENT
		//in this case collector is Characteristics.UNORDERED but nut  CONCURRENT
		
		
	}

	static void example4() {
		Stream<String> ohMy=Stream.of("lions","tigers","bears");
		Map<Integer, String> map =ohMy.collect(Collectors.toMap(k->k.length(),v->v,(s1,s2)->s1+"-"+s2));
		System.out.println(map);//{5=lions-bears, 6=tigers}
		
		Stream<String> ohMy1=Stream.of("lions","tigers","bears").parallel();
		ConcurrentMap<Integer, String> map1 =ohMy1.collect(Collectors.toConcurrentMap(k->k.length(),v->v,(s1,s2)->s1+"-"+s2));
		System.out.println(map1);//{5=lions-bears, 6=tigers}
		
		Collector<String, ?, ConcurrentMap<Object, Object>> b=Collectors.toConcurrentMap(k->k.length(),v->v,(s1,s2)->s1+"-"+s2);
		System.out.println(b.characteristics());//[CONCURRENT, UNORDERED, IDENTITY_FINISH]
		System.out.println(Collectors.toSet().characteristics());//[UNORDERED, IDENTITY_FINISH]
		
		
	}

	static void example5() {
		
		Stream<String> ohMy1=Stream.of("lions","tigers","bears").parallel();
		ConcurrentMap<Integer, List<String>> map1 =ohMy1.collect(Collectors.groupingByConcurrent(s->s.length()));
		System.out.println(map1);//{5=[bears, lions], 6=[tigers]}
		
		
		
	}
	public static void main(String[] args) {
//		example1();
//		example2();
//		example3();
//		example4();
		example5();
	}
}