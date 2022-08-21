package uk.warley.ganesh.chapter14.genericandcollections;

public class GenericsClassExample16 {
	public static void main(String[] args) {

		Generic1<String> gen1 = new Generic1<>();
		gen1.setA("Ganesh");
		System.out.println(gen1.getA());
	
		
		Generic1<Integer> gen2 = new Generic1<>();
		gen2.setA(12);
		System.out.println(gen2.getA());
		
		Generic1 gen3s = new Generic1<>();
		gen3s.setA(12);
		System.out.println(gen3s.getA());
		
	}
	
}

class Generic1<T> {
	private T a;
//	T b=new T();//cant do

	public T getA() {
		return a;
	}

	public void setA(T a) {
		this.a = a;
	}
}
