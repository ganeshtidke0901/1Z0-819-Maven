package uk.warley.ganesh.chapter13.annotations;

import java.lang.annotation.Repeatable;

@interface Helper {
	Annotation60[] value();
}

@Repeatable(Helper.class)
@interface Annotation60 {
	int a();
}

//java 8 use
@Annotation60(a = 1)
@Annotation60(a = 2)
@Annotation60(a = 3)
public class RepeatableAnnoattionExample11 {

}

//OR  Earlier use
@Helper(value={ @Annotation60(a = 1), @Annotation60(a = 2), @Annotation60(a = 3) })//value is optional
class AXA {

}