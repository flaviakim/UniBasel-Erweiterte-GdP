import ch.unibas.informatik.cs101.ImageWindow;

class BubbleSortVisual {
	
	// PROPERTIES
	
	static ImageWindow window;
	static int width = 500;
	static int height = 500;
	
	static char[] characters;
	static int maxCharValue = 0;
	
	
	// BUBLE SORT METHODS

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
				clearWindow();
				drawBars();
				window.redraw();
				window.pause(10);
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
	
	
	// VISUAL METHODS
	
	public static int getSingleBarWidth () {
		return width / characters.length;
	}
	
	public static void drawBars () {
		for (int i = 0; i < characters.length; i++) {
			drawSingleBar (i*getSingleBarWidth(), (int)characters[i]);		// (int)characters[i] gets the ASCII value of the character at position i in the array
		}
	}
	
	public static void drawSingleBar(int startX, int value) {
		for (int x = startX; x < startX + getSingleBarWidth(); x++) {
			for (int y = (height - 1) - value; y < height; y++) {
				window.setPixel(x, y, (value*2), 0, 254-(value*2));
				//System.out.println("Set pixel at (" + x + ", " + y + ").");
			}
		}
	}
	
	public static void clearWindow () {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < width; y++) {
				window.setPixel(x, y, 254, 254, 254);
			}
		}
	}
	
	
	
	// MAIN METHOD

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
		characters = args[0].toCharArray();
		// This checks which character has the highest value.
		for (char c : characters) {
			if ((int)c > maxCharValue) {
				maxCharValue = (int)c;
			} 
		}
		
		window = new ImageWindow(width, height);
		window.openWindow();

		sort(characters);

		displayArray(characters);
	}

}