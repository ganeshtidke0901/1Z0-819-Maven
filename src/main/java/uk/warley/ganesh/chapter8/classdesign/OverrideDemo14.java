package uk.warley.ganesh.chapter8.classdesign;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

class AB3 {
	double getAveWeigh() {
		return 60;
	}

	Number getAveWeigh(int a) {
		return 60;
	}

	Number test(int a) throws Exception {
		return 60;
	}

	Number getValue(int a) throws Exception {
		return 60;
	}

	int mm(List<String> a) throws Exception {
		return 60;
	}

	int nn(List<CharSequence> a) throws Exception {
		return 60;
	}

	protected List<String> pp(List<CharSequence> a) throws Exception {
		return null;
	}

}

public class OverrideDemo14 extends AB3 {

	@Override
	public double getAveWeigh() {

		return 20 + super.getAveWeigh();
	}

	@Override
	Integer getAveWeigh(int a) {
		return 60;
	}

	@Override
	Integer test(int a) {
		return 60;
	}

	@Override
	Number getValue(int a) throws FileNotFoundException, RuntimeException {
		return 60;
	}

	@Override
	int mm(List<String> a) throws Exception {
		return 60;
	}

//	@Override  //parametrs should be exact matching
//	int nn(List<String> a) throws Exception {
//		return 60;
//	}

	// return should be co-varient in case of generic and parameter type should be exact
	@Override
	protected ArrayList<String> pp(List<CharSequence> a) throws Exception {
		return null;
	}

	public static void main(String[] args) {
		System.out.println(new OverrideDemo14().getAveWeigh());
		System.out.println(new AB2().getAveWeigh());
	}
}
