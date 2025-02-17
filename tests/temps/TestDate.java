import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import src.temps.Date;

class TestDate {

	@Test
	void testNouvelleDateParDefaut() {
		Date d;
		d = new Date();
		assertEquals(1, d.jour());
		assertEquals(1, d.mois());
		assertEquals(2025, d.annee());
	}

	@Test
	void testNouvelleDate() {
		Date d;
		d = new Date(27, 1, 2025);
		assertEquals(27, d.jour());
		assertEquals(1, d.mois());
		assertEquals(2025, d.annee());
	}

	@Test
	void testJourPlus1() {
		Date d;
		d = new Date(15, 6, 2028);
		d.jourPlus1();
		assertEquals(16, d.jour());
		assertEquals(6, d.mois());
		assertEquals(2028, d.annee());
		d = new Date(30, 6, 2028);
		d.jourPlus1();
		assertEquals(1, d.jour());
		assertEquals(7, d.mois());
		assertEquals(2028, d.annee());
		d = new Date(31, 12, 2026);
		d.jourPlus1();
		assertEquals(1, d.jour());
		assertEquals(1, d.mois());
		assertEquals(2027, d.annee());
		d = new Date(28, 2, 2025);
		d.jourPlus1();
		assertEquals(1, d.jour());
		assertEquals(3, d.mois());
		assertEquals(2025, d.annee());
	}

	@Test
	void testMoisPlus1() {
		Date d;
		d = new Date(10, 4, 2026);
		d.moisPlus1();
		assertEquals(10, d.jour());
		assertEquals(5, d.mois());
		assertEquals(2026, d.annee());
		d = new Date(30, 1, 2025);
		d.moisPlus1();
		assertEquals(28, d.jour());
		assertEquals(2, d.mois());
		assertEquals(2025, d.annee());
		d = new Date(20, 12, 2024);
		d.moisPlus1();
		assertEquals(20, d.jour());
		assertEquals(1, d.mois());
		assertEquals(2025, d.annee());
	}

	@Test
	void testAnneePlus1() {
		Date d;
		d = new Date(29, 2, 2024);
		d.anneePlus1();
		assertEquals(28, d.jour());
		assertEquals(2, d.mois());
		assertEquals(2025, d.annee());
	}

	@Test
	void testJourMoins1() {
		Date d;
		d = new Date(15, 6, 2028);
		d.jourMoins1();
		assertEquals(14, d.jour());
		assertEquals(6, d.mois());
		assertEquals(2028, d.annee());
		d = new Date(1, 7, 2028);
		d.jourMoins1();
		assertEquals(30, d.jour());
		assertEquals(6, d.mois());
		assertEquals(2028, d.annee());
		d = new Date(1, 1, 2027);
		d.jourMoins1();
		assertEquals(31, d.jour());
		assertEquals(12, d.mois());
		assertEquals(2026, d.annee());
		d = new Date(1, 3, 2025);
		d.jourMoins1();
		assertEquals(28, d.jour());
		assertEquals(2, d.mois());
		assertEquals(2025, d.annee());
	}

	@Test
	void testMoisMoins1() {
		Date d;
		d = new Date(10, 5, 2026);
		d.moisMoins1();
		assertEquals(10, d.jour());
		assertEquals(4, d.mois());
		assertEquals(2026, d.annee());
		d = new Date(31, 3, 2025);
		d.moisMoins1();
		assertEquals(28, d.jour());
		assertEquals(2, d.mois());
		assertEquals(2025, d.annee());
		d = new Date(20, 1, 2025);
		d.moisMoins1();
		assertEquals(20, d.jour());
		assertEquals(12, d.mois());
		assertEquals(2024, d.annee());
	}

	@Test
	void testAnneeMoins1() {
		Date d;
		d = new Date(29, 2, 2024);
		d.anneeMoins1();
		assertEquals(28, d.jour());
		assertEquals(2, d.mois());
		assertEquals(2023, d.annee());
	}

	@Test
	public void testBissextile() {
		assertTrue(Date.bissextile(2024));
		assertFalse(Date.bissextile(2025));
	}

	@Test
	public void testToString() {
		Date d;
		d = new Date(3, 5, 2024);
		assertEquals("03/05/2024", d.toString());
		d = new Date(11, 10, 2024);
		assertEquals("11/10/2024", d.toString());
	}

	@Test
	public void testNombreDeJoursDuMois() {
		assertEquals(31, Date.nombreDeJoursDuMois(1, 2024));
		assertEquals(29, Date.nombreDeJoursDuMois(2, 2024));
		assertEquals(28, Date.nombreDeJoursDuMois(2, 2025));
		assertEquals(30, Date.nombreDeJoursDuMois(4, 2024));
	}
}
