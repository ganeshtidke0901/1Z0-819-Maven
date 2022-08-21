

package uk.warley.ganesh.chapter13.annotations;

//marker annotation
@interface Annotation1 {
}

//marker annotation
@interface Annotation2 {
	int a = 0;// variable implicitly public static final as same of interface constant variables

	String surname();// Required Element- implicitly public abstract as same of interface method

//	private String ab() default "No";// Optional Element
	String ab() default "No";// Optional Element

	String s = "Hello";// act as constant-public static final
}

@interface Annotation3 {
	Enum1 e();

	int a();

	Class b();

//	AnnotationsExample1 annotationsExample1();// only primitive type, String, Class, annotation, enumeration are permitted or 1-dimensional array
	int[] c();

//	int [][] d();//multidimentional invalid
	String name() default "Ganesh";

	Annotation1 annotation1() default @Annotation1;

	Annotation2 annotation2() default @Annotation2(surname = "Tidke");

	String d() default "";
//	String f() default null;//not valid default value
//	String f() default new String("Ganesh");//not valid default value

}

@interface Annotation4 {
	int value();

	int a() default 11;
}

@interface Annotation5 {
	int[] value();

	int a() default 11;

	String[] b() default "Ganesh";

	String[] c() default { "Ganesh", "Tidke" };
	// private int d(); //implicitly public, cant be private,protected

}

@interface Annotation6 {
	int[] v();

	int a() default 11;
}

@Annotation1
@Annotation2(surname = "Tidke")
//@Annotation2 surname="Tidke" //invalid use of element-value and annotation cant be repeated unless it is @Repeated 
//@Annotation2(surname = "Tidke",a=11)//cant assign final variable value again
@Annotation3(a = 2, b = AnnotationsExample1.class, c = 1, annotation2 = @Annotation2(surname = "Else"), e = Enum1.HELLO)
@Annotation4(12) // or @Annotation3(value=13)
@Annotation5(13) // or @Annotation5({13}) or @Annotation5(value=12) or @Annotation5(value={1,2})
@Annotation6(v = 11) // shorthand of array {11} if single value
public class AnnotationsExample1 {
	public static void main(String[] args) {
	}
}

enum Enum1 {
	HELLO
}