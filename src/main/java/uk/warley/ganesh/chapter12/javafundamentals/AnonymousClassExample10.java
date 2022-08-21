package uk.warley.ganesh.chapter12.javafundamentals;

public class AnonymousClassExample10 {
	int b=11;
	abstract class SaleTodayOnly {
		abstract int dollarOff();
	}

	public int admission(int basePrice) {
		int moreDiscount = 1;
		final int lessDiscount = 2;
		SaleTodayOnly only = new SaleTodayOnly() {
			int b=11;
		 final static int nn=10;
			@Override
			int dollarOff() {
				System.out.println(b+AnonymousClassExample10.this.b);
				return 3 + moreDiscount - lessDiscount;
			}
//			static void bb() {}//static not allowed
		};
//		moreDiscount=12;//should be effectively final or final
		return basePrice - only.dollarOff();
	}

	public static void main(String[] args) {

	}
}
