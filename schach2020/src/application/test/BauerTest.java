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
	 * weiss: 2 als erster Zug
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
	 * weiss: 1 als erster Zug
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
	 * weiss: 3 als erster Zug
	 */
	@Test
	void testSpielZugMoeglich03() {
		Position von = new Position(6, 3);
		Position nach = new Position(3, 3);
		Figur bauer = (Figur) sf.getFeld(von);
		boolean moeglich = bauer.spielZugMoeglich(sf, von, nach);
		assertFalse(moeglich);
	}
	
	/**
	 * schwarz: 2 als erster Zug
	 */
	@Test
	void testSpielZugMoeglich04() {
		Position von = new Position(1, 3);
		Position nach = new Position(3, 3);
		Figur bauer = (Figur) sf.getFeld(von);
		boolean moeglich = bauer.spielZugMoeglich(sf, von, nach);
		assertTrue(moeglich);
	}

	/**
	 * schwarz: 1 als erster Zug
	 */
	@Test
	void testSpielZugMoeglich05() {
		Position von = new Position(1, 3);
		Position nach = new Position(2, 3);
		Figur bauer = (Figur) sf.getFeld(von);
		boolean moeglich = bauer.spielZugMoeglich(sf, von, nach);
		assertTrue(moeglich);
	}

	/**
	 * schwarz: 3 als erster Zug
	 */
	@Test
	void testSpielZugMoeglich06() {
		Position von = new Position(1, 3);
		Position nach = new Position(4, 3);
		Figur bauer = (Figur) sf.getFeld(von);
		boolean moeglich = bauer.spielZugMoeglich(sf, von, nach);
		assertFalse(moeglich);
	}
	
	/**
	 * weiss: schlagen, wenn keine Figur da ist
	 */
	@Test
	void testWeissSchlagenOhneFigur() {
		Position von = new Position(6, 3);
		Position nach = new Position(5, 4);
		Figur bauer = (Figur) sf.getFeld(von);
		boolean moeglich = bauer.spielZugMoeglich(sf, von, nach);
		assertFalse(moeglich);
	}	
}
