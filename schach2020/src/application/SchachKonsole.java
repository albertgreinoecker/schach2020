package application;

import java.io.FileNotFoundException;

public class SchachKonsole {
	public static void main(String[] args) throws FileNotFoundException {
		SpielFeld sf = SpielFeldIO.einlesen("start.txt");
		sf.ausgabe();
	}
}
