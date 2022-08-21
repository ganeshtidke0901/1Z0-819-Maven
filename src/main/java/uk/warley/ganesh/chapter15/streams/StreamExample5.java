package uk.warley.ganesh.chapter15.streams;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamExample5 {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("Ganesh", "Tidke");
		Consumer<? super CharSequence> consumer1 = s -> System.out.println(s instanceof CharSequence);
		Consumer<? super String> consumer2 = s -> System.out.println(s);
		Consumer<? extends CharSequence> consumer322 = s -> System.out.println(s instanceof CharSequence);

		consumer1.accept("Ganesh");// true
		consumer322.accept(null);
//		consumer322.accept("Ganesh");//wont work as Consumer<? extends CharSequence> can points to Consumer<String's child(anyway String child does not exist but just for an example) > 

		stream.forEach(consumer1);
//		stream.forEach(consumer2);

		// because consumer2 can point to <String>, <CharSequence> <Object>
		// consumer1 can point to CharSequence
		consumer2 = consumer1;
		consumer1 = (Consumer<? super CharSequence>) consumer2;
		consumer1.accept("");

		Consumer<? super CharSequence> consumer3 = s -> System.out.println(s);

		Consumer<? super Object> consumer4 = s -> System.out.println(s);
		;

		consumer3 = consumer4;

		consumer4 = (Consumer<? super Object>) consumer3;
		consumer4.accept(new Object());//java.lang.ClassCastException: if we comment out consumer3 = consumer4; line

		Consumer<? super CharSequence> consumer5 = new Consumer<Object>() {
			@Override
			public void accept(Object t) {
			}
		};
	}
}
