package application;

public class Dame extends Figur {
	public Dame(boolean farbeweiss) {
		super(farbeweiss);
	}

	public boolean spielZugMoeglich(SpielFeld sp, Position von, Position nach) {
		// TODO: implement
		return false;
	}

	public String toString() {
		return "D" + super.toString();
	}
}
