package uk.warley.ganesh.chapter8.classdesign;

class AB2 {
	public double getAveWeigh() {
		return 60;
	}
}

public class OverrideDemo13 extends AB2 {

	@Override
	public double getAveWeigh() {

		return 20 + super.getAveWeigh();
	}

	public static void main(String[] args) {
		System.out.println(new OverrideDemo13().getAveWeigh());//80.0
		System.out.println(new AB2().getAveWeigh());//60.0
	}
}
