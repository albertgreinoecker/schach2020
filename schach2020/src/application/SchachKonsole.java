package application;

import java.io.FileNotFoundException;

public class SchachKonsole {
	public static void main(String[] args) throws FileNotFoundException {
		SpielFeld sf = SpielFeldIO.einlesen("start.txt");
		sf.ausgabe();
		
		SpielFeld sf2 = sf;
		
		sf.spielzug("e2-e4");
		sf.ausgabe();
		
		System.out.println("Hier kommt Spielfeld 2");
		sf2.ausgabe();
	}
}
