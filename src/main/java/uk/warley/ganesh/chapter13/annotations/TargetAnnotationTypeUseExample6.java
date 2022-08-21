package uk.warley.ganesh.chapter13.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Target({ ElementType.TYPE_USE })
@interface Annotation40 {
}

@Annotation40 //applied to class
public class TargetAnnotationTypeUseExample6 {//AnnotationTypeUseExample1 is type
	
	public static void main(@Annotation40 String[] args) {
		@Annotation40 List<@Annotation40 String> t=new @Annotation40 ArrayList<@Annotation40 String>();//List is type, String is type
	
		@Annotation40  TargetAnnotationTypeParameterExample7 annotationTypeParameterExample1;
		
		@Annotation40 int bl;//int is type
		
		@Annotation40	Predicate<@Annotation40  String>p= (@Annotation40 String s)->false;
		
//		types - class is type, int is type, String is type  , T would type
		
		
		@Annotation40  int remaining = (@Annotation40 int )10.1;
	}
}

class MyClass1<@Annotation40 T> {
//	@Annotation30 T t;//does not work
	T t;
}