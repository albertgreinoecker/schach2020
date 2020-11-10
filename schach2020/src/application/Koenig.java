package application;

public class Koenig extends Figur {
	public Koenig(boolean farbeweiss) {
		super(farbeweiss);
	}

	public boolean spielZugMoeglich(SpielFeld sp, Position von, Position nach) {
		//TODO: rochade
		if (!super.spielZugMoeglich(sp, von, nach)) return false;
		
		int dx = Math.abs(von.getX() - nach.getX());
		int dy = Math.abs(von.getY() - nach.getY());
		return dx <= 1 && dy <= 1;
	}

	@Override
	public void spielZug(SpielFeld sf, Position von, Position nach) {
		//TODO: rochade
		super.spielZug(sf, von, nach);
	}
	public String toString() {
		return "K" + super.toString();
	}
}
