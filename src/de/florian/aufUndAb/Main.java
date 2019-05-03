package de.florian.aufUndAb;

/**
 * Project: Auf und Ab Class: Main
 * 
 * @author Florian
 * @version 1.0
 */

public class Main {
	public static void main(String[] args) {
		Spiel game1 = new Spiel();

		for (int i = 1; i <= 25; i++) {
			game1.setWurf(i);
			while (game1.isFertig() == Zustand.nichtFertig) {
				game1.spieleRunde();
			}
			if (game1.isFertig() == Zustand.fertig) {
				System.out.println("Mit der Zahl " + i + " erreicht man das Ziel!");
			} else {
				System.err.println("Mit der Zahl " + i + " erreicht man das Ziel nicht!");
			}
		}

	}

}
