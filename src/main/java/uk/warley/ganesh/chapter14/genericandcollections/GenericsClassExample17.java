package uk.warley.ganesh.chapter14.genericandcollections;

public class GenericsClassExample17 {
	public static void main(String[] args) {

		Generic2<String, Integer> gen1 = new Generic2<>();
		gen1.set("Ganesh", 11);
		System.out.println(gen1.getA());

		Generic2<String, Integer> gen2 = new Generic2<>();
		gen2.set("Tidke", 12);
		System.out.println(gen1.getA());

	}

}

class Generic2<T, U> {
	private U b;
	private T a;
//	T b=new T();//cant do

	public T getA() {
		return a;
	}

	public U getB() {
		return b;
	}

	public void set(T a, U b) {
		this.a = a;
		this.b = b;
	}
}
