package uk.warley.ganesh.chapter13.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@Target(ElementType.TYPE_PARAMETER )
@interface Annotation30 {
}

public class TargetAnnotationTypeParameterExample7 {
	public static void main(String[] args) {
	}
}

class MyClass<@Annotation30 T> {
//	@Annotation30 T t;//does not work
	T t;
}