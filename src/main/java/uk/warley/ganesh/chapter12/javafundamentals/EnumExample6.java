package uk.warley.ganesh.chapter12.javafundamentals;

import java.util.Comparator;

enum Season {
	WINTER("winter") {

		@Override
		public String getHours() {
			return "10am-4pm";
		}

	},
	SUMMER("Hot") {

		@Override
		public String getHours() {
			return "9am- 6pm";
		}

	};

	Season(String string) {
		this.str = string;
	}

//	Season() { //error as final str is not intialized anywhere so has to be in constrcutor 
//	
//	}

	private final String str;

	public static void test() {
		System.out.println("static");
	}
	
	public abstract String getHours();

}

public class EnumExample6 {
	public static void main(String[] args) {
		Season winter=Season.WINTER;
		System.out.println(winter.getHours());//10am-4pm
		winter.test();//static 
		Season.test();//static 
	
		
	}
	
	
	
}


enum CCC{
	
}

//oho possible
enum XXY implements Comparator<String>{
;

@Override
public int compare(String o1, String o2) {
	return 0;
}

}