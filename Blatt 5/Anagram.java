/**
 * Created by Flavia on 26.10.16.
 */
public class Anagram {
	
	public static boolean testAnagramm(String text1, String text2) {
		
		// This is to count the chars in the texts (letters[0] stands for 'a', 1 for 'b' …
		int[] letters1 = new int[24];
		int[] letters2 = new int[24];
		
		char[] chars1 = editText(text1);
		char[] chars2 = editText(text2);
		
		if (chars1.length != chars2.length) {
			return false;
		} // chars1.length == chars2.length
		
		int length = chars1.length;
		
		// This count's the letters in both texts.
		for (int i = 0; i < length; i++) {
			letters1[ chars1[i]-'a' ]++;
			letters2[ chars2[i]-'a' ]++;
		}
		
		// This checks, whether the two arrays contain the same values or not
		for (int i = 0; i < 24; i++) {
			if (letters1[i] != letters2[i]) {
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
				out += (char)(characters[i] + ('a' - 'A'));
			}
			// the character is no letter, ignore it.
		}
		return out.toCharArray();
	}
	
	
	public static void main (String[] args) {
		
		testAnagramm(args[0], args[1]);
		
	}
	
}
