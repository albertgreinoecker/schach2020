package application;

import java.util.ArrayList;

public class SpielFeld {

	/**
	 *  (0,0) ist links oben!!!
	 *  weiss ist immer unten!!
	 *  
	 *  (0,0) (0,1) (0,2) ....
	 *  (1,0) (1,1) (1,2) ....
	 *  ......
	 *  (7,0) (7,1) (7,2) ....
	 */
	private Feld[][] mat; // Zeile, Spalte
	private boolean werAmZug = true;

	/**
	 * Per default soll einfach ein Spielfeld mit lauter leeren Feldern erzeugt
	 * werden
	 */
	public SpielFeld() {
		mat = new Feld[8][8];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = new Feld();
			}
		}
	}

	public SpielFeld(Feld[][] mat) {
		this.mat = mat;
	}

	public boolean schach() {
		// TODO:implement
		return false;
	}

	public boolean schachmatt() {
		// TODO:implement
		return false;
	}

	public void ausgabe() {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.printf("%2s|", mat[i][j]);
			}
			System.out.println();
		}
	}

	/** 
	 * 
	 * @param zug Bsp. e2-e4
	 */
	public boolean spielzug(String zug) {
		String[] p = zug.split("-");
		Position von = schach2koordinate(p[0]);
		System.out.println(von);
		Position nach = schach2koordinate(p[1]);
		System.out.println(nach);
		if (isFigur(von)) {
			Figur f = (Figur) getFeld(von);
			// if (f.spielZugMoeglich(this, von, nach)) {
			f.spielZug(this, von, nach);
			werAmZug = !werAmZug; // Der andere Spieler ist jetzt am Zug

			// }
			return true;
		}
		return false;
	}

	/**
	 * Setze ein Feld auf eine bestimmte Position
	 */
	public void setFeld(Feld f, Position p) {
		mat[p.getX()][p.getY()] = f;
	}

	/**
	 * Uebertragung einer Schach-Koordinate in die Koordinaten der Matrix
	 * 
	 * @param schach z.B. e2 => (4,6)
	 */
	private Position schach2koordinate(String schach) {
		int y = schach.charAt(0) - 'a';
		int x = '8' - schach.charAt(1);
		return new Position(x, y);
	}

	/**
	 * @see #getFeld(Position)
	 */
	public Feld getFeld(int x, int y) {
		return mat[x][y];
	}

	/**
	 * Hole das Feld von einer bestimmten position
	 */
	public Feld getFeld(Position p) {
		return getFeld(p.getX(), p.getY());
	}

	/**
	 * @see 
	 * @param p
	 * @return
	 */
	public boolean isFigur(Position p) {
		return isFigur(p.getX(), p.getY());
	}

	/**
	 * Steht auf <i>p</i> eine Figur oder ist das Feld leer?
	 */
	public boolean isFigur(int x, int y) {
		return (mat[x][y] instanceof Figur);
	}
	
	/**
	 * 
	 * @param ps eine Menge an Positionen die Überprüft werden sollen
	 * @return true wenn alle Felder frei sind
	 */
	public boolean felderFrei(ArrayList<Position> ps)
	{
		for (Position p : ps)
		{
			if (isFigur(p))
			{
				return false;
			}
		}
		return true;
	}


}
