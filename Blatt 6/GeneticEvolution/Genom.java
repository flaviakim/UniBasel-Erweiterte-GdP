import java.util.Random;

/**
 * Class representing a simple model for a genom.
 * 
 * A genom consists of a linear sequence of amino acid represented
 * as characters. The characters used are 'A', 'C', 'G' and 'T'. 
 *
 */
public class Genom {
    
    char[] aminoAcids;
    
    /** 
     * Constructs a genom of length len.
     *
     * @param len The length of the sequence.
     */
    Genom(int len) {
        aminoAcids = new char[len];
        randomize();
    }

    /**
     * Returns the current genom as char-array.
     *
     * @return The current state of the genom as char array.
     */
    public char[] getGenom() {
        return aminoAcids;
    }
    
    /**
     * Returns the sequence as a String.
     */
    public String toString() {
        // TODO implement this ...
        String out = "";
        for (int i = 0; i < aminoAcids.length; i++) {
        	out += aminoAcids[i];
        }
        return out;
    }
    
    /**
     * @param other Genom to compare with.
     * @return Returns true only if the two genoms have the same length and a fully identical sequence.
     */
    public boolean isEqual(Genom other) {
    	if (other.getGenom().length != this.getGenom().length) // (this. ist optional, bloss zum Verständnis)
    		return false;
    	
    	for (int i = 0; i < aminoAcids.length; i++) {
    		if (other.getGenom()[i] != this.getGenom()[i]) { // (auch hier könnte direkt auf aminoAcids[i] zugegriffen werden)
    			return false;
    		}
    	}
        return true;
    }
    
    /**
     * Fill the sequence with a random pattern.
     */
    private void randomize() {
        // https://docs.oracle.com/javase/8/docs/api/java/util/Random.html für Erklärung, wie mit der zuoberst in diesem File importierten Random-Klasse umzugehen ist. (oder anhand vom Beispiel hier)
        
        // Zuerst erstellen wir ein neues Element dieser Random Klasse. (nb: Würden wir einen fixen seed eingeben, also den anderen Konstruktor aus dem Link nehmen, würde es jedesmal dieselben Zahlen ausgeben. Der leere Konstruktor nimmt einen zufälligen seed-Wert.)
        Random r = new Random();
        
        // Dann gehen wir jeden Platz in unserem Array durch und weisen einen zufälligen Buchstaben (A, C, G oder T) zu.
        for (int i = 0; i < aminoAcids.length; i++) {
        
        	// Dies erstellt eine zufällige ganze Zahl im Bereich [0,4) (also 0, 1, 2 oder 3) und weist sie der Variable zu.
        	int randomNumber = r.nextInt(4);
        	// Mit der unten implementierten Methode machen wir daraus den entsprechenden Buchstaben.
        	char c = getChar(randomNumber);
        	// Jetzt  weisen wir diesen Buchstaben an die Stelle im for loop, an der wir gerade sind.
        	aminoAcids[i] = c;
        	
        	// Das ganze würde auch abgekürzt gehen:
        	// aminoAcids[i] = getChar(r.nextInt(4));
        	
        }
        
        // Jetzt haben wir einen gefüllten Array mit einem zufälligen Buchstaben an jeder Stelle.
    }
    
    /**
     * Translates the number 0-3 into the amio acid characters A, C, G, T.
     * 
     * @param c Integer representing amino acid.
     * @return Character for amino acid.
     */
    private char getChar(int c) {
    	
    	switch (c) {
    		case 0:
    			return 'A';
    		case 1:
    			return 'C';
    		case 2:
    			return 'G';
    		case 3:
    			return 'T';
    		default:
    			System.out.println("ERROR Genom::getChar -- int c out of range!");
    			return 'A';
    	}
    	
    }
    
    /**
     * Sets a random amino acid at a random position.
     */
    public void pointMutation() {
        Random r = new Random();
        int pos = r.nextInt(aminoAcids.length);
        char aa = getChar(r.nextInt(4));
        aminoAcids[pos] = aa;
    }
    
    /**
     * Insert a random amino acid at a random position.
     * This could also be before the first amino acid or after the last one.
     */
    public void insertion() {
    	
    	if (aminoAcids.length >= 10) {
    		// Es soll nie weniger als 1 Aminosäure geben. Mutation Abbrechen.
    		return;
    	}
    	
        Random r = new Random();
        int pos = r.nextInt(aminoAcids.length + 1);
        char aa = getChar(r.nextInt(4));
        
        // Zuerst kopieren wir den Array in einen neuen, welcher eine Stelle grösser ist.
        // Aber wir brauchen einen kleinen Trick dabei. Wir brauchen im for-loop zwei ints,
        // für je einen Array und wenn wir bei unserer pos sind, überspringen wir die Stelle
        // im neuen Array, um sie somit frei zu lassen.
        // Wir könnten den Array auch einfach direkt rüberkopieren und dann wie bei
        // Priority Queue ab der gewünschten Stelle alle eins nach rechts rutschen lassen.
        char[] newAminoAcids = new char[aminoAcids.length + 1];
        for (int i = 0, j = 0; i < aminoAcids.length; i++, j++) {
        	if (j == pos) {
        		j++;
        	}
        	newAminoAcids[j] = aminoAcids [i];
        }
        
        // Jetzt müssen wir nur noch die leere Stelle mit unserer zufälligen aa füllen. (Hätten wir auch im if Statement im for loop machen können)
		newAminoAcids[pos] = aa;
		
		// Und natürlich den Array jetzt weiter geben
		aminoAcids = newAminoAcids;
    }
    
    /**
     * Removes a random amino acid.
     */
    public void deletion() {

    	if (aminoAcids.length <= 1) {
    		// Es soll nie weniger als 1 Aminosäure geben. Mutation Abbrechen.
    		return;
    	}
    	
    	// Nach dem gleichen Prinzip wie bei insertion() machen wir jetzt den Array, einfach dass wir vom
    	// grösseren in den kleineren schreiben und damit die Stelle einfach weglassen.
    	
		Random r = new Random();
        int pos = r.nextInt(aminoAcids.length);
        
    	char[] newAminoAcids = new char[aminoAcids.length - 1];
        for (int i = 0, j = 0; j < newAminoAcids.length; i++, j++) {
        	if (i == pos) {
        		i++;
        	}
        	newAminoAcids[j] = aminoAcids [i];
        }
        
    	aminoAcids = newAminoAcids;
    }
    
}
