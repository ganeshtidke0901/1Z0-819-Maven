package uk.warley.ganesh.chapter13.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@interface Annotation50 {

}

@Retention(RetentionPolicy.SOURCE)
@interface Annotation51 {

}

@Retention(RetentionPolicy.RUNTIME)
@interface Annotation52 {

}


@Annotation52
public class RetentionAnnotationExample8 {

}
