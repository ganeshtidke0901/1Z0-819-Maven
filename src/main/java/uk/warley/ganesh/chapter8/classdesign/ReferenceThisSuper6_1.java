package uk.warley.ganesh.chapter8.classdesign;

class Mammal {
	int mm=11;
	String type = "mammal";
	protected int numberOfLegs=4;
}

public class ReferenceThisSuper6_1 extends Mammal {

	String type = "bat";
	protected int numberOfLegs=10;
	int nn=112;

	public void getType() {
		System.out.println(this.type + "--" + super.type);
	}

	private void printData() {
	
		System.out.println(this.type);//bat
		System.out.println(super.type);//mammal
		System.out.println(this.mm);//11
		System.out.println(super.mm);//11
		System.out.println(this.nn);//112
//		System.out.println(super.nn);// nn is not a part of parent class
		System.out.println(type);//bat
		System.out.println(numberOfLegs);//10
		System.out.println(nn);//112

	}

	public static void main(String[] args) {
		ReferenceThisSuper6_1 referenceThis = new ReferenceThisSuper6_1();
		referenceThis.getType();// bat--mammal
		referenceThis.printData();
	}
}
