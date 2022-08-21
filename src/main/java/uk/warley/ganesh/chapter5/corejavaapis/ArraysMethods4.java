package uk.warley.ganesh.chapter5.corejavaapis;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysMethods4 {
	public static void main(String[] args) {
		example1();
	}

	private static void example1() {
		Employee[] employees = { new Employee("Ganesh"), new Employee("tidke"), new Employee("ganesh"),
				new Employee("12a"), new Employee("12A") };
		Arrays.sort(employees);
		for (int i = 0; i < employees.length; i++) {
			System.out.print(employees[i] + " ");// Employee:12A Employee:12a Employee:Ganesh Employee:ganesh
													// Employee:tidke
		}
		System.out.println();
		int i1 = Arrays.binarySearch(employees, new Employee("Ganesh"));
		System.out.println(i1);//2

		int[] a2 = { 5, 3, 2, 6, 4 };
		Arrays.sort(a2);// 2 3 4 5 6
		System.out.println(Arrays.binarySearch(a2, 1));// -0-1
		System.out.println(Arrays.binarySearch(a2, 7));// -5-1
		System.out.println(Arrays.binarySearch(a2, 4));// 2

		int[] a3 = {2,3,4,5,6};
		int[] a4= {2,3,4,5,6};
		System.out.println(Arrays.equals(a3, a4));//true

		int[] a5 = {2,3,4,5,6};
		int[] a6= {1,3,4,5,6};
		System.out.println(Arrays.equals(a5, a6));//false
		
		int[] a7 = {2,3,4,5,6};
		int[] a8= {1,3,4,5,6,8};
		System.out.println(Arrays.compare(a7, a8));//Postive a7>a8
		System.out.println(Arrays.compare(a8, a7));//Negative a8< a7
		System.out.println(Arrays.compare(a3, a4));//0 a3==a4
		

		int[] a9 = {2,3,4,5,6};
		int[] a10= {1,3,4,5,6};
		System.out.println(Arrays.mismatch(a9, a10));//0
		System.out.println(Arrays.mismatch(a10, a9));//0
		System.out.println(Arrays.mismatch(a3, a4));//-1
		
		Employee[] employees1 = { new Employee("Ganesh"), new Employee("tidke"), new Employee("ganesh"),
				new Employee("12a"), new Employee("12A") };
		Employee[] employees2 = { new Employee("Ganesh"), new Employee("tidke"), new Employee("ganesh"),
				new Employee("12a"), new Employee("12A") };
		
		
		System.out.println(Arrays.equals(employees1, employees2));//true
//		List<String> l=null;
//		l.toArray(new Employee[l.size()]);
		List<Employee> s0=Arrays.asList(employees1);
		List<Employee> s1=Arrays.asList(employees1);
		List<Employee> s2=List.of(employees2);
		System.out.println("----"+s0.equals(s1));//----true
		Employee[] employees23 = { new Employee("Ganesh"), new Employee("tidke"), new Employee("ganesh"),
				new Employee("12a"), new Employee("12A") };
		List<Employee> s3=Arrays.asList(employees23);
		
		System.out.println("----"+s3.equals(s0));//----true
//		s2.add(null);//java.lang.UnsupportedOperationException
	}

	private static class Employee implements Comparable<Employee> {
		String name;

		public Employee(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Employee:" + name;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Employee)
			{
					return this.name.equals(((Employee)(obj)).name);
			}else
			{
				return false;
			}
		}
		@Override
		public int compareTo(Employee o) {
			return this.name.compareTo(o.name);
		}

	}

}
