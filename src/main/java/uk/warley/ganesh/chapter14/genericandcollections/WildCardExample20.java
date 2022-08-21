package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WildCardExample20 {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
//		List<Object>list2=new ArrayList<String>();//type parameter should be same on both side-left and right of expression

		
		// Unbounded
		List<?> list3 = new ArrayList<String>();
//		list3.add("Ganesh");// not allowed as we dont know which data type to go into

		List<A> aa=null;
		List<B> bb=null;
		List<C>cc=null;
		// Upper bounded wildcard
		List<? extends A> list4 = new ArrayList<A>();
		List<? extends A> list5 = new ArrayList<B>();
		List<? extends A> list6 = new ArrayList<C>();
		List<? extends A> list41 = aa;
		List<? extends A> list51 =bb;
		List<? extends A> list61 = cc;
		aa=(List<A>) list4;
		
//		list4.add(new A());// not allowed as List<? extend A> can take new ArrayList<C>(); 
//		list4.add(new C());// not allowed as <? extend A> can take child of C
//		A a = list4.get(0);
		
//		list41.add(new A()); //not allowed as List<? extend A> can take List<C>; 

		// Lower bounded wildcard
		List<? super A> list7 = new ArrayList<A>();
		List<? super A> list8 = new ArrayList<Object>();
//		List<? super A> list9=new ArrayList<B>();//not allowed as anything that is A or super type of A
		list7.add(new A());
		list7.add(new B());
		list7.add(new C());
//		list7.add(new Object()); //does not allow where list7 can points to new ArrayList<A>();
		System.out.println("list7:"+list7.remove(new Object()));//false 

//		list7.add(new Object());// not allowed as <? super A> can take A
		Object object = list7.get(0);

//		List<?> list=new ArrayList<? extends A>();//does not work wildcard on both side


		list7.add(new A());
		for (Iterator iterator = list7.iterator(); iterator.hasNext();) {
			Object object1 = (Object) iterator.next();// if we made it as String , there would be class cast exception
			System.out.println(object1);
		}

		for (Iterator iterator = list3.iterator(); iterator.hasNext();) {
			Object object2 = (Object) iterator.next();
			System.out.println(object2);
		}
		
		for (Iterator<A> iterator = (Iterator<A>) list4.iterator(); iterator.hasNext();) {
			A object3 = iterator.next();
			System.out.println(object3);
		}
		
		
		list4=(List<? extends A>) list7;
		list7=(List<? super A>) list4;
		
		
		//heap polution
		String []ss=new String[2];
		Object[] oo=ss;
//		oo[0]=Integer.valueOf(1);//ArrayStoreException

		
		list3=list1;
		list1=(List<String>) list3;
//		
		list3=list4;
		list4=(List<? extends A>) list3;
//		
		list3=list7;
		list7 = (List<? super A>) list3;		
	}
}

class A {

}

class B extends A {
}

class C extends B {
}