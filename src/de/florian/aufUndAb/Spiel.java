package de.florian.aufUndAb;

/**
 * Project: Auf und Ab Class: Spiel
 * 
 * @author Florian
 * @version 1.0
 */

public class Spiel {
	private int[][] leitern = {
			{ 6, 14, 19, 21, 27, 31, 33, 38, 42, 46, 51, 53, 57, 59, 62, 65, 68, 70, 76, 80, 85, 92, 98 },
			{ 27, 19, 14, 53, 6, 42, 38, 33, 31, 62, 59, 21, 96, 51, 46, 85, 80, 76, 70, 68, 65, 98, 92 } };
	private int spielstand;
	private int wurf;
	private int zaehler;
	private int maxZahl = 0;
	private Zustand fertig;
	private boolean leiterGefunden;

	/**
	 * Class constructor. Sets the values of spielstand, fertig and maxZahl to the
	 * default value
	 */
	public Spiel() {
		spielstand = 0;
		fertig = Zustand.nichtFertig;
		maxZahl = 0;
	}

	/**
	 * Checks if you can reach 100 with the value of wurf
	 */
	public void spieleRunde() {
		zaehler = 0;
		leiterGefunden = false;

		if (spielstand == 100) {
			fertig = Zustand.fertig;
		}

		if (fertig == Zustand.nichtFertig) {
			spielstand += wurf;
			if (spielstand == maxZahl) {
				fertig = Zustand.abgebrochen;
			}

			if (spielstand - wurf > maxZahl) {
				maxZahl = spielstand - wurf;
			}

			if (spielstand > 100) {
				spielstand -= (2 * wurf);
			}

			while (!leiterGefunden && zaehler < leitern[0].length) {
				if (spielstand == leitern[0][zaehler]) {
					spielstand = leitern[1][zaehler];
					leiterGefunden = true;
				}
				zaehler++;
			}
		}
	}

	/**
	 * @return the value of fertig
	 */
	public Zustand isFertig() {
		return fertig;
	}

	/**
	 * Sets the variables to default values Returns nothing
	 * 
	 * @param wert an Integer which is used to set the value of wurf
	 */
	public void setWurf(int wert) {
		wurf = wert;
		spielstand = 0;
		fertig = Zustand.nichtFertig;
		maxZahl = 0;
	}

	/**
	 * 
	 * @return the value of spielstand
	 */
	public int getSpielstand() {
		return spielstand;
	}

}
