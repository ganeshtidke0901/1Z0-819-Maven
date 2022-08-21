package uk.warley.ganesh.pkg2;

import uk.warley.ganesh.pkg1.Frog;

public class Tadpole extends Frog {
	public static void main(String[] args) {
		Tadpole tadpole = new Tadpole();
		tadpole.ribbit();
//		tadpole.jump();

		Frog frog = new Tadpole();
//		frog.ribbit();
//		frog.jump();
		frog.dd();

	}
	
}
