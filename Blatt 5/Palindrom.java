public class Palindrom {
	
    public static void main (String[] args) {
		
		if (args.length != 1) {
			return;
		}
		
		if (testPalindrom(args[0])) {
			System.out.println("Text ist ein Palindrom!");
		} else {
			System.out.println("Text ist KEIN Palindrom!");
		}
        
    }
	
	/**
	 * Returns true if text is a palindrom, false otherwise.
	 **/
	public static boolean testPalindrom(String text) {
		
		char[] characters = editText(text);
		
		for (int i = 0; i < (characters.length / 2); i++) {
			if (characters[i] != characters[characters.length - i - 1]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns the string with only lowercase letters.
	 **/
	static char[] editText (String text) {
		char[] characters = text.toCharArray();
		String out = "";
		for (int i = 0; i < characters.length; i++) {
			if (characters[i] >= 'a' && characters[i] <= 'z') {
				// The character is a lowercase letter. Add it directly to our String.
				out += characters[i];
			} else if (characters[i] >= 'A' && characters[i] <= 'Z') {
				// The character is an uppercse letter. Add the Unicode difference between upper- and lowercase letters to the letter to get the lowercase one and then add it to our String.
				out += (characters[i] + ('a' - 'A'));
			}
			// the caracter is no letter, ignore it.
		}
		return out.toCharArray();
	}
    
}
