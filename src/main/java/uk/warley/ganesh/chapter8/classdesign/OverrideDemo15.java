package uk.warley.ganesh.chapter8.classdesign;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

class AB4 {
	private double getAveWeigh() {
		return 60;
	}

	protected Number getAveWeigh(int a) {
		return 60;
	}

	List<?> pp(List<CharSequence> a) throws Exception {
		return null;
	}

	List<? extends CharSequence> qq(List<CharSequence> a) throws Exception {
		return null;
	}

	List<? super String> nn(List<CharSequence> a) throws Exception {
		return null;
	}
}

public class OverrideDemo15 extends AB4 {

//	@Override //does not override, as private is not inherited
	public double getAveWeigh() {
		return 20;
	}

	// overriding method access modifier must be equal or broader /more accessible than parent
//	@Override
//	Integer getAveWeigh(int a) {
//		return 60;
//	}

	// return should be co-varient in case of generic and parameter type should be exact
	@Override
	ArrayList<String> pp(List<CharSequence> a) throws Exception {
		return null;
	}

	
	@Override
	List<String> qq(List<CharSequence> a) throws Exception {
		return null;
	}
	
	@Override// Or Object
	ArrayList<CharSequence> nn(List<CharSequence> a) throws Exception {
		return null;
	}
	public static void main(String[] args) {
		System.out.println(new OverrideDemo15().getAveWeigh());//20
		System.out.println(new AB2().getAveWeigh());
		
//		List<CharSequence> ss=new ArrayList<String>();//not allowed so we have ? 

		
		List<? super String> aa=new ArrayList<CharSequence>();
		List<? > aa1=new ArrayList<CharSequence>();
		List<? extends CharSequence> aa4=new ArrayList<CharSequence>();
		List<? extends CharSequence> aa5=new ArrayList<String>();
		
		
	}
}
