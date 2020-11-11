package application.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.Figur;
import application.Position;
import application.SpielFeld;
import application.SpielFeldIO;

class BauerTest {
	SpielFeld sf;

	@BeforeEach
	void setUp() throws Exception {
		sf = SpielFeldIO.einlesen("test_data/bauer01.txt");
	}

	/**
	 * 2 als erster Zug
	 */
	@Test
	void testSpielZugMoeglich01() {
		Position von = new Position(6, 3);
		Position nach = new Position(4, 3);
		Figur bauer = (Figur) sf.getFeld(von);
		boolean moeglich = bauer.spielZugMoeglich(sf, von, nach);
		assertTrue(moeglich);
	}

	/**
	 * 1 als erster Zug
	 */
	@Test
	void testSpielZugMoeglich02() {
		Position von = new Position(6, 3);
		Position nach = new Position(5, 3);
		Figur bauer = (Figur) sf.getFeld(von);
		boolean moeglich = bauer.spielZugMoeglich(sf, von, nach);
		assertTrue(moeglich);
	}

	/**
	 * 3 als erster Zug
	 */
	@Test
	void testSpielZugMoeglich03() {
		Position von = new Position(6, 3);
		Position nach = new Position(3, 3);
		Figur bauer = (Figur) sf.getFeld(von);
		boolean moeglich = bauer.spielZugMoeglich(sf, von, nach);
		assertFalse(moeglich);
	}

}
