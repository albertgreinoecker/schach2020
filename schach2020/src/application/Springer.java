package application;

public class Springer extends Figur {
	public Springer(boolean farbeweiss) {
		super(farbeweiss);
	}

	public boolean spielZugMoeglich(SpielFeld sp, Position von, Position nach) {
		if (!super.spielZugMoeglich(sp, von, nach)) return false;
		
		//Berechne den Abstand der beiden Positionen auf x- und y-Ebene
		int dx = Math.abs(von.getX() - nach.getX());
		int dy = Math.abs(von.getY() - nach.getY());
		//gib zurück, ob die Unterscheidung entweder 1 auf x, und 2 auf y-Ebene ist oder umgekehrt
		return (dx == 1 && dy == 2) || (dx == 2 && dy == 1);
	}

	public String toString() {
		return "S" + super.toString();
	}

}
