package uk.warley.ganesh.chapter13.annotations;

import java.lang.annotation.Inherited;

@Inherited
@interface ABCC {
}


@ABCC
class Hello{}

public class InheritedAnnotationExample10 extends Hello{// this class will have @Vertebrate from hello

}
