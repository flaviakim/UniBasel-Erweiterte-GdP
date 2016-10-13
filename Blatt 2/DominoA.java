public class DominoA {
	
	static int maxNumber = 6;
	static int count = 0;
	
	public static void main (String[] args) {		
		
		String out = "";
		
		for (int i = 0; i <= maxNumber; i++) {
			for (int j = 0; j <= maxNumber; j++) {
				out += "(" + i + "|" + j + ")";
				count++;
				if (j < maxNumber) {
					out += ", ";
				}
			}
			out += "\n";
		}
		
		System.out.println(out);
		System.out.println("Total Domino Pieces: " + count);
		
	}
	
	
}