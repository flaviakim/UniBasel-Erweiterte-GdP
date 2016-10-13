class BubbleSort {

	/**
	* Vertauscht zwei Werte in einem Array an den gegebenen Positionen.
	**/
	public static void swap(int i, int j, char[] characters) {
		char c = characters[i];
		characters [i] = characters[j];
		characters[j] = c;
	}

	/**
	* Sortiert das Eingabearray und aendert das Array in place
	**/
	public static void sort(char[] characters) {
		// As long as we had changed something, we want to loop through it again.
		// Only if in the whole loop nothing changed, we know that we are finished.
		boolean changed = false;
		do {
			changed = false;
			for (int i = 1; i < characters.length; i++) {
				// Characters can be compared like ints
				if (characters[i - 1] > characters[i]) {
					swap (i - 1, i, characters);
					changed = true;
				}
			}
		} while (changed);
	}

	/**
	* Schreibt das Array auf die Ausgabekonsole
	**/
	public static void displayArray(char[] characters) {
		for (int i = 0; i < characters.length; i++) {
			/* // If we only want letters without spaces uncomment this block
			if (characters[i] == ' ') {
				continue;
			} */
			System.out.print(characters[i]);
		}
		System.out.println();
	}

	/**
	* Die Hauptfunktion liest das Character Array und ruft die Sortierfunktion
	* und die Ausgabefunktion auf
	**/
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Bitte rufen Sie das Programm mit einem Eingabewert auf");
			System.out.println("  java BubbleSort 'dies ist ein text'");
			System.exit(-1);
		}
		char[] characters = args[0].toCharArray();

		sort(characters);

		displayArray(characters);
	}

}