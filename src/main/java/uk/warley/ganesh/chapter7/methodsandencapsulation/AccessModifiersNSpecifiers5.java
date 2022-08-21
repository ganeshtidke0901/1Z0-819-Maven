package uk.warley.ganesh.chapter7.methodsandencapsulation;

import uk.warley.ganesh.pkg1.Classroom;

public class AccessModifiersNSpecifiers5 {

}

class School {

	static void test() {
//		System.out.println(Classroom.globalKey); // it is package private
		Classroom classroom;// can access classroom as it is public
//		Classroom classroom = new Classroom(101, "MR Ganesh");// but can't access Classroom() constructor is default
//		System.out.println(Classroom.roomNumber);//private to Classroom
		System.out.println(Classroom.floor); //public 
//		System.out.println(Classroom.teacherName);//package private or available to child if inherited 
	}

}