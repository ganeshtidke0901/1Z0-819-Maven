package uk.warley.ganesh.chapter12.javafundamentals;

@FunctionalInterface
interface Walk3 {
	private static void abc() {
		
	}
	
	private void xyz()
	{
		
	}
	
	public default void mno()
	{
		
	}
	
	void pqr();

}

public class InterfaceExample14 implements Walk3 {

	public static void main(String[] args) {
	
		new InterfaceExample14().mno();
		new InterfaceExample14().pqr();;
		
	}

	@Override
	public void pqr() {
		
//		Walk3.super.pqr();//camt access 
	}
}
