//@Annotation17 //must be in package-info.java
package uk.warley.ganesh.chapter13.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//
@Target({ ElementType.TYPE })//can add more target values
@interface Annotation10 {

}

@Target({ ElementType.FIELD })
@interface Annotation11 {

}

@Target({ ElementType.METHOD })
@interface Annotation12 {

}

@Target({ ElementType.PARAMETER })
@interface Annotation13 {

}

@Target({ ElementType.CONSTRUCTOR})
@interface Annotation14 {

}

@Target({ ElementType.LOCAL_VARIABLE})
@interface Annotation15 {

}
@Target({ ElementType.ANNOTATION_TYPE})
@interface Annotation16 {

}
@Target({ ElementType.PACKAGE})
@interface Annotation17 {

}

@Target({ ElementType.TYPE_PARAMETER})
@interface Annotation18 {

}

@Target({ ElementType.TYPE_USE})
@interface Annotation19 {

}

@Target(ElementType.MODULE)
@interface Annotation20 {

}

@Annotation10
public class TargetAnnotationExample5 {
	@Annotation11
	int a;

	@Annotation14
	public TargetAnnotationExample5(@Annotation13 int a) {
		super();
//		@Annotation15//only local variable 
		this.a = a;
		@Annotation15
		int c;
	}

	// @Annotation11 //wont work as it is field
	@Annotation12
	public void test(@Annotation13 int a) {

		Predicate<String> t=(@Annotation13 String p)-> false;
		@Annotation15 
		int d;
		@Annotation15
		List<String> list=new ArrayList<String>();
		
	}

}

@Annotation10
interface ABC {

}

@Annotation10
enum XYZ {

}

@Annotation10
@Annotation16
@interface JustAnnotation {

}