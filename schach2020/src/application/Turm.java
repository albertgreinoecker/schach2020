package application;

public class Turm extends Figur {
	public Turm(boolean farbeweiss) {
		super(farbeweiss);
	}

	@Override
	public void spielZug(SpielFeld sf, Position von, Position nach) {
		// TODO implement
		super.spielZug(sf, von, nach);
	}

	public boolean spielZugMoeglich(SpielFeld sp, Position von, Position nach) {
		return super.spielZugMoeglich(sp, von, nach) && spielZugMoeglichGerade(sp, von, nach);
	}

	public String toString() {
		return "T" + super.toString();
	}
}
