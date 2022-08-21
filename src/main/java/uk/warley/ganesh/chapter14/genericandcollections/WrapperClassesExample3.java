package uk.warley.ganesh.chapter14.genericandcollections;

import java.util.ArrayList;

public class WrapperClassesExample3 {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		var var = new ArrayList<Integer>();// ArrayList<Integer> var
		var var2 = new ArrayList<>();// ArrayList<Object> var2
		ArrayList<Integer> var3=new ArrayList<Integer>();
		ArrayList<Integer> var4=new ArrayList<>();
//		ArrayList<> var5=new ArrayList<Integer>();//does not work
		ArrayList var6=new ArrayList<>();
		ArrayList var7=new ArrayList();
		ArrayList<Object> var8=new ArrayList<>();
		ArrayList<Object> var9=new ArrayList();
//		ArrayList<Object> var9=new ArrayList<Integer>();//has to be same type parameter
		ArrayList var10=new ArrayList<Integer>();
		var10.add("String");
		ArrayList<Integer> var11=new ArrayList();
		
		
		var.add(1);
		var.add(2);// only integer is allowed
		var.add(null);// only integer is allowed

		var2.add("Ganesh");
		var2.add(2);// can add any object

		int a = var.get(2);// java.lang.NullPointerException- null is assigned to int a
		var.get(2);
		
		

	}
}
