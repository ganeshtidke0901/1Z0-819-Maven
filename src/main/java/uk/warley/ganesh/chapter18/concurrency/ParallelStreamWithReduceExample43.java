package uk.warley.ganesh.chapter18.concurrency;

import java.util.List;
import java.util.Optional;

public class ParallelStreamWithReduceExample43 {
	public static void example1() {
		Optional<String> optional = List.of("Ganesh", "Tidke").stream().reduce((s1, s2) -> s1 + s2);
		System.out.println(optional.get());// GaneshTidke

		String str2 = List.of("Ganesh", "Tidke").stream().reduce("Mr.", (s1, s2) -> {
			System.out.println("Accumalator:" + s1 + "+" + s2);
			;
			return s1 + s2;
		});
		System.out.println(str2);
//		Accumalator:Mr.+Ganesh
//		Accumalator:Mr.Ganesh+Tidke
//		Mr.GaneshTidke

		Integer i = List.of("Ganesh", "Tidke", "xyz", "Ramesh").stream().reduce(4, (n, s2) -> {
			System.out.println("Accumalator:" + n + "+" + s2 + ".length() :" + (n + s2.length()));
			return n + s2.length();
		}, (l1, l2) -> {
			System.out.println("Combiner:" + l1 + "+" + l2);
			return l1 + l2;
		});
		System.out.println(i);// Combiner is never called

//		Accumalator:4+Ganesh.length() :10
//		Accumalator:10+Tidke.length() :15
//		Accumalator:15+xyz.length() :18
//		Accumalator:18+Ramesh.length() :24
//		24

	}

	public static void example2() {

		Integer i = List.of("Ganesh", "Tidke", "xyz", "Ramesh").stream().parallel().reduce(4, (n, s2) -> {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Accumalator:" + n + "+" + s2 + ".length() :" + (n + s2.length()));
			return n + s2.length();
		}, (l1, l2) -> {
			System.out.println("Combiner:" + l1 + "+" + l2);
			return l1 + l2;
		});
		System.out.println(i);

//		Accumalator:4+Ramesh.length() :10
//		Accumalator:4+Ganesh.length() :10
//		Accumalator:4+Tidke.length() :9
//		Accumalator:4+xyz.length() :7
//		Combiner:10+9
//		Combiner:7+10
//		Combiner:19+17
//		36

	}

	public static void example3() {

//		String s=List.of("a","b","c","d","e","f","g","h","i","j","k","l").parallelStream().reduce("X",(s1,s2)-> s1+s2);
//		or
		String s = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l").parallelStream().reduce("X",
				(s1, s2) -> {
					System.out.println(
							"Thread id" + Thread.currentThread().getId() + " Accumalator:" + s1 + "+" + s2 + "");
					return s1 + s2;
				});

		System.out.println(s);//
		// could be any order
//		Thread id1 Accumalator:X+h
//		Thread id18 Accumalator:X+i
//		Thread id19 Accumalator:X+a
//		Thread id18 Accumalator:Xh+Xi
//		Thread id17 Accumalator:X+f
//		Thread id13 Accumalator:X+d
//		Thread id14 Accumalator:X+k
//		Thread id15 Accumalator:X+g
//		Thread id16 Accumalator:X+b
//		Thread id15 Accumalator:Xg+XhXi
//		Thread id13 Accumalator:X+l
//		Thread id13 Accumalator:Xk+Xl
//		Thread id17 Accumalator:X+j
//		Thread id19 Accumalator:X+e
//		Thread id18 Accumalator:X+c
//		Thread id19 Accumalator:Xe+Xf
//		Thread id17 Accumalator:Xj+XkXl
//		Thread id19 Accumalator:Xd+XeXf
//		Thread id18 Accumalator:Xb+Xc
//		Thread id17 Accumalator:XgXhXi+XjXkXl
//		Thread id18 Accumalator:Xa+XbXc
//		Thread id18 Accumalator:XaXbXc+XdXeXf
//		Thread id18 Accumalator:XaXbXcXdXeXf+XgXhXiXjXkXl
//		XaXbXcXdXeXfXgXhXiXjXkXl

	}

	static void example4() {
	}

	public static void main(String[] args) {
//		example1();
//		example2();
		example3();
//		example4();
	}
}