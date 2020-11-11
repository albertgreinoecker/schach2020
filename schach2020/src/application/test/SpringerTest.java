package application.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.Figur;
import application.Position;
import application.SpielFeld;
import application.SpielFeldIO;

class SpringerTest {
	SpielFeld sf;
	
	@BeforeEach
	void setUp() throws Exception {
		sf = SpielFeldIO.einlesen("test_data/springer01.txt");
	}

	/**
	 * Gueltiger Sprung 2,1
	 */
	@Test
	void testSpielZugMoeglich01() {
		Position von = new Position(7,1);
		Position nach = new Position(5,0);
		Figur springer = (Figur)sf.getFeld(von);
		boolean moeglich = springer.spielZugMoeglich(sf, von, nach); 
		assertTrue(moeglich);
	}
	
	
	/**
	 * Springer springt auf Zelle daneben => false
	 */
	@Test
	void testSpielZugMoeglich02() {
		Position von = new Position(7,1);
		Position nach = new Position(6,1);
		Figur springer = (Figur)sf.getFeld(von);
		boolean moeglich = springer.spielZugMoeglich(sf, von, nach); 
		assertFalse(moeglich);
	}	

	/**
	 * Ungueltiger Sprung 2,2
	 */
	@Test
	void testSpielZugMoeglich03() {
		Position von = new Position(7,1);
		Position nach = new Position(5,3);
		Figur springer = (Figur)sf.getFeld(von);
		boolean moeglich = springer.spielZugMoeglich(sf, von, nach); 
		assertFalse(moeglich);
	}
	
	/**
	 * Weiter Sprung 
	 */
	@Test
	void testSpielZugMoeglich04() {
		Position von = new Position(0,0);
		Position nach = new Position(5,3);
		Figur springer = (Figur)sf.getFeld(von);
		boolean moeglich = springer.spielZugMoeglich(sf, von, nach); 
		assertFalse(moeglich);
	}
	
	
}
