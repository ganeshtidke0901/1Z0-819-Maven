package uk.warley.ganesh.pkg1;

public class Classroom {
	private int roomNumber;
	protected static String teacherName;
	static int globalKey = 54321;
	public static int floor=3;
	
	 Classroom(int r, String t) {
		roomNumber=r;
		teacherName=t;
	}
}
